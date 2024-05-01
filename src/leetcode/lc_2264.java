package leetcode;

public class lc_2264 {
    public String largestGoodInteger(String num) {
        StringBuilder res = new StringBuilder();
        int len = num.length();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len - 2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);
            if (c1 == c2 && c2 == c3) {
                int n = (c1 - '0') * 100 + (c2 - '0') * 10 + c3 - '0';
                max = Math.max(max, n);
                i += 2;
            }
        }
        res.append(max == 0 ? "000" : max);
        return max == Integer.MIN_VALUE ? "" : res.toString();
    }

    public static void main(String[] args) {
        String num = "6777133339";

        System.out.println(new lc_2264().largestGoodInteger(num));
    }
}
