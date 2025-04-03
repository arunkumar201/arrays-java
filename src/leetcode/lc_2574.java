package leetcode;

import java.util.Arrays;

public class lc_2574 {
	
	
	public static void main(String[] args) {
		//Input: nums = [10,13,6,2]
		//Output: 77
		int[] nums = {10, 13, 6, 2};
		System.out.println(new lc_2574().maximumTripletValue(nums));
	}
	
	// Time Complexity: O(n^3)
	// Space Complexity: O(1)
	public long maximumTripletValue_BruteForce(int[] nums) {
		long max = 0;
		//this case can't be possible as per the question
		if (nums.length < 3) {
			return 0;
		}
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[j] > nums[i]) {
					continue;
				}
				for (int k = j + 1; k < nums.length; k++) {
					max = Math.max(max, (nums[i] - (long) nums[j]) * (long) nums[k]);
				}
			}
		}
		return max;
	}
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(n)
	public long maximumTripletValue_betterSolution(int[] nums) {
		long max = 0;
		//this case can't be possible as per the question
		if (nums.length < 3) {
			return 0;
		}
		//approach
		/*
		  1. prefix sum array - hold the max value we can get on current index to its left
		  2.iterate over the array
		  3.for each element we pick a middle element that makes the diff positive
		  4.then we calculate the max value - (element-middle)*prefixSum[middle]
		 */
		int[] maxElement = new int[nums.length];
		int maxDiff = Integer.MIN_VALUE;
		int n = nums.length;
		//1. prefix sum array - hold the max value we can get on current index to its left
		for (int i = n - 1; i >= 0; i--) {
			maxElement[i] = Math.max(maxElement[i == n - 1 ? n - 1 : i + 1], nums[i]);
		}
		System.out.println(Arrays.toString(maxElement));
		//2.iterate over the array
		//3.for each element we pick a middle element that makes the diff positive
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				if (nums[j] > nums[i]) {
					continue;
				}
				//4.then we calculate the max value - (element-middle)*prefixSum[middle]
				max = Math.max(max, (nums[i] - (long) nums[j]) * (long) maxElement[j + 1]);
			}
		}
		return max;
	}
	
	// Time Complexity: O(N)
	// Space Complexity: O(N+N) ~ O(N)
	public long maximumTripletValue(int[] nums) {
		long max = 0;
		int n = nums.length;
		if (n < 3) {
			return 0;
		}
		
		// Step 1: Compute prefix max array (max value from left)
		int[] prefixMax = new int[n];
		prefixMax[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
		}
		
		// Step 2: Compute suffix max array (max value from right)
		int[] suffixMax = new int[n];
		suffixMax[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
		}
		
		// Step 3: Compute the max value for each triplet
		for (int j = 1; j < n - 1; j++) {  // Middle element
			if (prefixMax[j - 1] > nums[j] && suffixMax[j + 1] > 0) {
				long value = (long) (prefixMax[j - 1] - nums[j]) * suffixMax[j + 1];
				max = Math.max(max, value);
			}
		}
		return max;
	}
}
