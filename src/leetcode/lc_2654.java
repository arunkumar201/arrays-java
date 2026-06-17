package leetcode;

public class lc_2654 {

	public static void main(String[] args) {
		// [2,6,3,4]
		int[] nums = { 6, 10, 15 };
		lc_2654 obj = new lc_2654();
		System.out.println(obj.minOperations(nums));
	}

	private int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	public int minOperations(int[] nums) {
		int ops = 0;
		int n = nums.length;
		int overallGcd = nums[0];
		for (int i = 1; i < n; i++) {
			overallGcd = GCD(overallGcd, nums[i]);
		}

		if (overallGcd != 1) {
			return -1;
		}

		int ones = 0;
		for (int x : nums)
			if (x == 1)
				ones++;
		if (ones > 0)
			return n - ones;


		

		return ops;
	}
}
