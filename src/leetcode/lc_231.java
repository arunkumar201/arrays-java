package leetcode;

public class lc_231 {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
//        double ans = (Math.log(n) / Math.log(2));
//        return Math.abs(ans - Math.round(ans)) < 1e-10;
        //another solution
        return ((n & (n - 1)) == 0);

    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
//        while (n != 1) {
//            if (n % 3 != 0) {
//                return false;
//            }
//            n = n / 3;
//        }
//        return true;
        double ans = Math.log(n) / Math.log(3);
        return Math.abs(ans - Math.round(ans)) < 1e-10;
    }

    //Brute force
    public static boolean isPowerOfFour_BruteForce(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;

        int i = n;
        while (i != 1) {
            if (i % 2 != 0) {
                return false;
            }
            i /= 2;
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 3;
        boolean ans = isPowerOfFour_BruteForce(n);
        System.out.println(ans);
    }
}
