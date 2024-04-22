package leetcode;

import java.util.HashMap;

public class lc_3121 {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i)) && Character.isUpperCase(word.charAt(i))) {
                continue;
            } else {
                map.put(word.charAt(i), i);
            }
        }
        for (Character c : map.keySet()) {
            char s = (char) (c ^ 32);
            boolean isUpper = Character.isUpperCase(c);
            if (isUpper && map.containsKey(s)) {
                if (map.get(c) > map.get(s)) {
                    count += 1;
                    map.put(s, -1);
                    map.put(c, -1);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String str = "cCceDC";
        System.out.println(new lc_3121().numberOfSpecialChars(str));
    }
}
