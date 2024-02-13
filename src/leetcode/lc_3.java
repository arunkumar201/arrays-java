package leetcode;

import java.util.HashSet;

public class lc_3 {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxStr =0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                maxStr = Math.max(maxStr, j - i);
            }

        }
        return maxStr;

    }

    public static void main(String[] args) {
        String s = "abcabcbbggggddgfxzxerstssxdfsdfsfdsstugbnmnlkjoi";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
