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

    public static int countPalindrome(String s, int low, int high) {
        int res = 0;
        int len = s.length();
        while (low >= 0 && high < len) {
            if (s.charAt(low) == s.charAt(high)) {
                res++;
                low--;
                high++;
            } else {
                break;
            }
        }
        return res;
    }

    public static int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int high = i;
            //for odd length palindromes
            res += countPalindrome(s, i, high);//O(N)
            high = i + 1;
            //for even length palindromes
            res += countPalindrome(s, i, high); //O(N)
        }
        //overall time Complexity O(N^2)+O(N^2)=2*O(N^2)=~O(N^2)
        return res;
    }

    public static void main(String[] args) {

        String s = "abccbc";

        int res = countSubstrings(s);
        System.out.println("result is " + res);

    }
}
