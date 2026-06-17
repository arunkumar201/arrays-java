package leetcode;

public class lc_2169 {

	public static void main(String[] args) {

		// Input: num1 = 2, num2 = 3
		int num1 = 2, num2 = 3;
		lc_2169 lc = new lc_2169();
		int result = lc.countOperations(num1, num2);
		System.out.println("Result: " + result);
		System.err.println("Optimized Result: " + lc.countOperations_optimized(num1, num2));

	}

	public int countOperations(int num1, int num2) {
		int count = 0;

		while (num1 > 0 && num2 > 0) {
			if (num1 >= num2)
				num1 -= num2;
			else
				num2 -= num1;
			count++;
		}

		return count;
	}

	public int countOperations_optimized(int num1, int num2) {
		int count = 0;

		while (num1 != 0 && num2 != 0) {
			int operationNeeded = 0;
			if (num1 >= num2) {
				int mod = num1 % num2;
				operationNeeded = num1 / num2;
				num1 = mod;
			} else {
				int mod = num2 % num1;
				operationNeeded = num2 / num1;
				num2 = mod;
			}
			count+=operationNeeded;
		}
		return count;

	}
}
