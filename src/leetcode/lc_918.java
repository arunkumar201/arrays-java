package leetcode;

public class lc_918 {
	
	
	public static void main(String[] args) {
		//Input: nums = [1,-2,3,-2]
		//Output: 3
		
		lc_918 solution = new lc_918();
		int[] nums = new int[]{5, -3, 5};
		System.out.println("----brute force-----");
		System.out.println("Result: " + solution.maxSubarraySumCircular_bruteForce(nums));
		System.out.println("----better solution-----");
		System.out.println("Result: " + solution.maxSubarraySumCircular(nums));
		
	}
	
	public int maxSubarraySumCircular_bruteForce(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int currentSum = 0;
			for (int j = i; j < n + i; j++) {
				currentSum += nums[j % n];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		return maxSum;
	}
	
	/*
	 * circular sum=totalSum-minSum
	 * maxSum=regular kadane's algorithm sum
	 * minSum=modified kadane's algorithm sum
	 */
	
	/**
	 * Time Complexity: O(N),
	 * Space Complexity: O(1), constant space.
	 */
	public int maxSubarraySumCircular(int[] nums) {
		int totalSum = 0;
		
		int currentMax = 0;
		int currentMin = 0;
		
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		
		for (int num : nums) {
			currentMax = Math.max(num, currentMax + num);
			maxSum = Math.max(maxSum, currentMax);
			
			currentMin = Math.min(num, currentMin + num);
			minSum = Math.min(minSum, currentMin);
			
			totalSum += num;
		}
		
		// when all elements are negative, e.g., [-1, -1, -1]
		// totalSum = -3
		// maxSum = -1 (largest single element)
		// minSum = -3
		// totalSum - minSum = 0 → not a valid subarray (empty)
		// So, we return maxSum directly as the correct maximum subarray sum
		if (maxSum < 0) {
			return maxSum;
		}
		int maxSumCircular = totalSum - minSum;
		int maxSumRegular = maxSum;
		return Math.max(maxSumRegular, maxSumCircular);
	}
}
