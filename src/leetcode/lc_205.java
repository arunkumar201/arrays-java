package leetcode;

import java.util.HashMap;

public class lc_205 {

    public boolean isIsomorphic_map(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapTS.containsKey(c1) && mapTS.get(c1) != c2) {
                return false;
            }
            if (mapST.containsKey(c2) && mapST.get(c2) != c1) {
                return false;
            }

            mapTS.put(c1, c2);
            mapST.put(c2, c1);

        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i = 0; i < n1; i++) {
            int ascii1 = s.charAt(i) ;
            int ascii2 = t.charAt(i) ;
            if (map1[ascii1] != map2[ascii2]) {
                return false;
            }
            map1[ascii1] = i + 1;
            map2[ascii2] = i + 1;

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean res = new lc_205().isIsomorphic(s, t);
        System.out.println(res);
    }
}
