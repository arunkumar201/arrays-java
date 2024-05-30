package leetcode;

import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class lc_1404 {

    public int numSteps(String s) {
        int n = s.length();
        if (n == 1 && s.charAt(0) == '1') {
            return 0;
        }
        int carry = 0;
        int ans = 0;
        for (int i = n - 1; i >= 1; i--) {
            int digit = (s.charAt(i) - '0' + carry) % 2;
            if (digit == 0) {
                ans++;
            } else if (digit == 1) {
                carry = 1;
                ans += 2;
            }
        }
        return ans + carry;
    }

    //    using big number
    public int numSteps_Big_Number(String s) {
        int ans = 0;
        BigInteger num = new BigInteger(s, 2);

        while (!num.equals(java.math.BigInteger.ONE)) {
            if (num.testBit(0)) { //EVEN
                num = num.add(BigInteger.ONE);
            } else {
                // Even number: divide by 2 (right shift)
                num = num.shiftRight(1);
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        Input: s = "1101"

        String s = "1101";
        int res = new lc_1404().numSteps(s);
        System.out.println(res);
    }
}
