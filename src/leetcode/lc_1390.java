package leetcode;

public class lc_1390 {

	public static void main(String[] args) {
		// Input array
		// nums = [21, 4, 7]
		//
		// Output: 32
		//
		// Explanation:
		// Only 21 has exactly four divisors: 1, 3, 7, and 21.
		// Their sum is 32.
		// Numbers 4 and 7 do not have exactly four divisors.

		int[] nums = { 21, 4, 7 };
		int result = new lc_1390().sumFourDivisors(nums);
		System.out.println(result); // Expected output: 32
	}

	public int countDivisors(int num) {
		int count = 0;
		int sum = 0;

		for (int i = 1; i*i <= num; i++) {

			// If i divides num, it is a divisor
			if (num % i == 0) {
				count++;
				sum += i;

				/*
				 * Example: num = 36
				 * Divisors come in pairs: (1,36), (2,18), (3,12), (4,9), (6,6)
				 *
				 * If i is a divisor, then num / i is also a divisor.
				 * We must ensure we do not double-count when i == num / i
				 * (this happens when i is the square root of num).
				 */
				if (num / i != i) {
					sum += num / i;
					count++;
				}
			}
		}

		// Return the sum only if the number has exactly 4 divisors
		return count == 4 ? sum : 0;
	}

	public int sumFourDivisors(int[] nums) {
		int totalSum = 0;

		for (int num : nums) {
			int sum = countDivisors(num);

			if (sum > 0) {
				totalSum += sum;
			}
		}

		return totalSum;
	}
}
