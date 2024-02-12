package leetcode;

import java.util.HashMap;

public class lc_242 {


    public static boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len2 != len1) {
            return false;
        }
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!mp.containsKey(c) || mp.get(c) == 0) {
                return false;
            }
            mp.put(c, mp.get(c) - 1);
        }
        return true;

    }

    //another approach for this question is
    //use 2 lookup Array as strings always consists the lowercase 26 characters
    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] lookup = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lookup[s.charAt(i) - 'a']++;
            lookup[t.charAt(i) - 'a']--;
        }
        for (int i : lookup) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "nagaram";
        boolean res = isAnagram(s, "anagram");
        System.out.println(res);
    }
}
