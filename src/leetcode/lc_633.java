package leetcode;

public class lc_633 {
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }

        for (int a = 0; a < Math.sqrt(c) + 1; a++) {
            double a_squared = a * a;
            double b_squared = c - a_squared;
            if (b_squared < 0) {
                continue;
            }
            int isPerfectSquare = (int) Math.sqrt(b_squared);
            if (isPerfectSquare * isPerfectSquare == b_squared) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Input: c = 5
        //Output: true
        int c = 3;
        boolean res = new lc_633().judgeSquareSum(c);
        System.out.println(res);
    }
}
