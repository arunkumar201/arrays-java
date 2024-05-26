package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class lc_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));
        HashMap<Character, String> mp = new HashMap<>();
        HashMap<String, Character> mp2 = new HashMap<>();
        int n = pattern.length();
        if (n != str.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(pattern.charAt(i)) && !mp2.containsKey(str[i])) {
                mp.put(pattern.charAt(i), str[i]);
                mp2.put(str[i], pattern.charAt(i));
                System.out.println(mp2 + " " + mp);
            } else {
                String prevMatch = mp.get(pattern.charAt(i));
                boolean isPresent2 = mp2.containsKey(str[i]);
                char prevMatch2char = isPresent2 ? mp2.get(str[i]) : ' ';
                System.out.println(prevMatch + " " + str[i]);
                if (prevMatch == null || prevMatch2char == ' ') {
                    return false;
                }
                if (!prevMatch.equals(str[i]) || prevMatch2char != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern_optimize(String pattern, String s) {
        String[] str = s.split(" ");
        int n = pattern.length();
        if (n != str.length) {
            return false;
        }
        HashMap<Character, String> mp = new HashMap<>();
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(pattern.charAt(i))) {
                if (mp.containsValue(str[i])) return false;
                mp.put(pattern.charAt(i), str[i]);
            } else {
                if (!mp.get(pattern.charAt(i)).equals(str[i])) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        Input: pattern = "abba", s = "dog cat cat dog"

        String pattern = "abba";
        String s = "dog dog dog dog";
        boolean res = new lc_290().wordPattern(pattern, s);
        System.out.println(res);
    }
}
