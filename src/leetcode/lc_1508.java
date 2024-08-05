package leetcode;

import java.util.Arrays;

public class lc_1508 {
	
	public int rangeSum(int[] nums, int n, int left, int right) {
		double[] subArraySum = new double[n * (n + 1) / 2];
		double sum = 0;
		int k = 0;
		double x = Math.pow(10, 9) + 7;
		
		// Calculate sum of all possible sub-arrays and their sum
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum += nums[j];
				subArraySum[k++] += sum;
			}
			sum = 0;
		}
		Arrays.sort(subArraySum);
		
		// Calculate sum of subarrays in range [left, right]
		double sumRange = 0;
		for (int i = left - 1; i < right; i++) {
			sumRange += subArraySum[i];
		}
		
		double ans = sumRange % x;
		return (int) ans;
	}
	
	public static void main(String[] args) {
		
		//Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
		int[] nums = new int[]{1, 2, 3, 4};
		int n = 4;
		int left = 1;
		int right = 10;
		int res = new lc_1508().rangeSum(nums, n, left, right);
		System.out.println(res); // Output: 13
		
	}
}
