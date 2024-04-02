package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_205 {

    public boolean isIsomorphic_Map(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }
        HashMap<Character, Character> mst = new HashMap<>();
        HashMap<Character, Character> mts = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mst.containsKey(c1) && mst.get(c1) != c2) {
                return false;
            }
            if (mts.containsKey(c2) && mts.get(c2) != c1) {
                return false;
            }
            mst.put(c1, c2);
            mts.put(c2, c1);
        }
        return true;
    }


    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }
        int[] mst = new int[256];
        int[] mts = new int[256];

        for (int i = 0; i < n1; i++) {
            int c1 = s.charAt(i) - 'a';
            int c2 = t.charAt(i) - 'a';
            if(mst[c1]!=mts[c2]){
                return false;
            }
            System.out.println(c1+"----"+c2);
            mst[c1]=i+1;
            mts[c2]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean res = new lc_205().isIsomorphic(s, t);
        System.out.println(res);
    }
}
