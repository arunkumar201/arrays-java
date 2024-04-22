package leetcode;

import java.util.HashMap;

public class lc_3120 {
    //    Brute force approach
    public int numberOfSpecialChars_BruteForce(String word) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        for (Character c : map.keySet()) {
            char s = (char) (c ^ 32);
            if (map.containsKey(s) && map.get(s)>0) {
                count +=1;
                map.put(s, 0);
                map.put(c, 0);
            }
        }
        return count;
    }

    public int numberOfSpecialChars(String word) {
        return 0;
    }

    public static void main(String[] args) {
        String word = "AbBCab";
        System.out.println(new lc_3120().numberOfSpecialChars(word));
        System.out.println(new lc_3120().numberOfSpecialChars_BruteForce(word));

    }
}
