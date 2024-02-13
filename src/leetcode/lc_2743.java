package leetcode;

import java.util.HashSet;

public class lc_2743 {
    //pending problem
    public static int numberOfSpecialSubstrings(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxStr = 0;
        for (int i = 0; i < s.length(); i++) {
            maxStr += 1;
        }
        return maxStr;
    }

    public static void main(String[] args) {

        String s = "abcd";
        int res = numberOfSpecialSubstrings(s);
        System.out.println("result is " + res);
    }
}
