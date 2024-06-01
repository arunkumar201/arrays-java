package leetcode;

public class lc_3110 {

    public int scoreOfString(String s) {
        int ans = 0;

        for (int i = 1; i < s.length() ; i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "zaz";
        int res = new lc_3110().scoreOfString(s);
        System.out.println(res);
    }
}
