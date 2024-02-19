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

    public static void main(String[] args) {
        int n = 3;
        boolean ans = isPowerOfTwo(n);
        System.out.println(ans);
    }
}
