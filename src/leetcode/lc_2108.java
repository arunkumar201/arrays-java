package leetcode;

//2108. Find First Palindromic String in the Array
public class lc_2108 {

    public static boolean isPalindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String firstPalindrome(String[] words) {

        for (String s : words) {
            if (isPalindrom(s)) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] s = new String[]{"abc", "car", "ada", "racecar", "cool"};
        String res = firstPalindrome(s);
        System.out.println(res);
    }
}
