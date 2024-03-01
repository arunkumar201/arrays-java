package leetcode;

import java.util.Arrays;

public class lc_2864 {
    //    2864. Maximum Odd Binary Number
    public String maximumOddBinaryNumber(String s) {
        char[] res = new char[s.length()];
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }
            res[i] = '0';
        }
        res[s.length() - 1] = '1';
        countOnes--;
        for (int i = 0; i < countOnes; i++) {
            res[i] = '1';
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "0101";
        String res = new lc_2864().maximumOddBinaryNumber(s);
        System.out.println(res);
    }
}
