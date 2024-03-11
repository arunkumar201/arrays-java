package leetcode;

import java.util.HashMap;

public class lc_791 {

    public String customSortString(String order, String s) {
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

    public static void main(String[] args) {
        String order = "bcafg";
        String s = "abcd";
        String res = new lc_791().customSortString(order, s);
        System.out.println(res);
    }
}
