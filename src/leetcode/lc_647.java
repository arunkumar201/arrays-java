package leetcode;

public class lc_647 {

    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    //brute force approach
    public static int countSubstrings_BruteForce(String s) {
        int len = s.length();
        if (len < 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

        String s = "aaa";

        int res = countSubstrings_BruteForce(s);
        System.out.println("result is " + res);

    }
}
