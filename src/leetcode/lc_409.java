package leetcode;

public class lc_409 {
    public int longestPalindrome(String s) {
        int ans = 0;

        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean hasOdd = false;
        for (int v : count) {
            if (v % 2 == 0) {
                ans += v;
            } else {
                ans += v - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        //Input: s = "abccccdd"

        String s = "abccccdd";
        int res = new lc_409().longestPalindrome(s);
        System.out.println(res);

    }
}
