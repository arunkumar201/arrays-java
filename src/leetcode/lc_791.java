package leetcode;

import java.util.HashMap;

public class lc_791 {

    public String customSortString_1(String order, String s) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                while (map.get(c) > 0) {
                    res += c;
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                while (map.get(c) > 0) {
                    res += c;
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        return res;

    }


    public  String customSortString(String order, String s) {
        int [] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a'] > 0) {
                sb.append(c);
                cnt[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                sb.append((char)('a' + i));
                cnt[i]--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String order = "bcafg";
        String s = "abcd";
        String res = new lc_791().customSortString(order, s);
        System.out.println(res);
    }
}
