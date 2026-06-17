public class lc_1590 {

	public static void main(String[] args) {
		// Input: nums = [3,1,4,2], p = 6
		lc_1590 sol = new lc_1590();

		int[] nums = new int[] { 4, 4, 2 };
		int p = 7;

		System.out.println("Result: " + sol.minSubarray_bruteForce(nums, p));

	}

	// NOTE: for modulo problems, prefix sum with hashmap is mandatory
	public int minSubarray_bruteForce(int[] nums, int p) {
		long total_sum = 0;
		int n = nums.length;
		int min_subarray_size = Integer.MAX_VALUE;

		for (int num : nums) {
			total_sum += num;
		}

		if (total_sum < p) {
			return -1;
		}

		if (total_sum % p == 0) {
			return 0;

		}

		for (int i = 0; i < n; i++) {
			long curr_sum = 0;

			for (int j = i; j < n; j++) {
				curr_sum += nums[j];
				long remaining_sum = total_sum - curr_sum;
				if (remaining_sum >0 && remaining_sum % p == 0) {
					System.out.println("inner");
					min_subarray_size = Math.min(min_subarray_size, j - i + 1);
				}
			}
		}
		return min_subarray_size == Integer.MAX_VALUE ? -1 : min_subarray_size;
	}

}
