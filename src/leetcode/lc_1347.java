package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_1347 {


    public int minSteps(String s, String t) {
        int[] charCounts = new int[26];

        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        int ans = 0;
        for (int count : charCounts) {
            if (count > 0) {
                ans += count;
            }
        }
        return ans;
    }

    public int minSteps_1(String s, String t) {
        int ans = 0;
        int[] sCharCounts = new int[26];
        int[] tCharCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharCounts[s.charAt(i) - 'a']++;
            tCharCounts[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int sCount = sCharCounts[i];
            int tCount = tCharCounts[i];

            if (sCount > tCount) {
                ans += sCount - tCount;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

//     Input: s = "bab", t = "aba"
        String s = "leetcode";
        String t = "practice";
        int res = new lc_1347().minSteps_1(s, t);
        System.out.println(res);

    }

}
