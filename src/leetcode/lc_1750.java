package leetcode;

public class lc_1750 {
    public int minimumLength(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            while (left <= right && (s.charAt(right) == currentChar)) {
                right--;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        String s = "cabaabac";

        int res = new lc_1750().minimumLength(s);
        System.out.println(res);
    }
}
