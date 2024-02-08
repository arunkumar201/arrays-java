package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_1647 {

    public static int minDeletions(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        System.out.println(mp);

        HashMap<Integer, Integer> freqCnt = new HashMap<>();
        int ans = 0;
        for (int cnt : mp.values()) {
            System.out.println(cnt);
            if (freqCnt.containsKey(cnt)) {
                while (cnt > 0 && freqCnt.containsKey(cnt)) {
                    cnt--;
                    ans++;
                }
            }
            freqCnt.put(cnt, freqCnt.getOrDefault(cnt, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {


        String s = "aaabbbcc";
        int res = minDeletions(s);
        System.out.println("result is " + res);

    }
}
