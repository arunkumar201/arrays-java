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
	
	public static boolean isPowerOfTwo_Log(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		double ans = Math.log(n) / Math.log(2);
        System.out.println(ans);
        double x=1e-10;
        return Math.abs(ans - Math.round(ans)) < x;
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
		System.out.println(ans);
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
		int n = 536870912;
		boolean ans = isPowerOfTwo_Log(n);
		System.out.println(ans);
	}
}
