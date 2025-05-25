package leetcode;

public class lc_53 {
	public static void main(String[] args) {
		lc_53 solution = new lc_53();
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("----brute force-----");
		System.out.println(solution.maxSubArray_bruteForce(nums));
		
		System.out.println("----better solution-----");
		System.out.println(solution.maxSubArray(nums));
	}
	
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int n = nums.length;
		int currentSum = 0;
		for (int num : nums) {
			currentSum += num;
			System.out.println("currentSum: " + currentSum);
			maxSum = Math.max(maxSum, currentSum);
			if (currentSum < 0) {
				currentSum = 0;
			}
			System.out.println("currentSum: " + currentSum);
		}
		return maxSum;
	}
	
	public int maxSubArray_bruteForce(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}
}
