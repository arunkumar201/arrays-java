package leetcode;

import java.util.Arrays;

public class lc_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int n = s.length();
//we can also do without the prefixLen
//        int[] prefixLen = new int[n];
//        for (int i = 0; i < n; i++) {
//            prefixLen[i] = Math.abs(s.charAt(i) - t.charAt(i));
//        }
        int currCost = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            currCost += Math.abs(s.charAt(right) - t.charAt(right));
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
//     Input: s = "abcd", t = "bcdf", maxCost = 3

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int res = new lc_1208().equalSubstring(s, t, maxCost);
        System.out.println(res);


    }
}
