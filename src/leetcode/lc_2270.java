package leetcode;

import java.util.Arrays;

public class lc_2270 {
	
	
	public static void main(String[] args) {
		//Input: nums = [10,4,-8,7]
		int[] array = new int[]{5, -9, 3, 10};
		int res = new lc_2270().waysToSplitArray(array);
		
		System.out.println("res " + res);
		
		
	}
	
	public int waysToSplitArray_optimized(int[] nums) {
		int ans = 0;
		long total = 0;
		
		for (int num : nums) {
			total += num;
		}
		long prefixSum = 0;
		
		for (int num : nums) {
			prefixSum += num; //left sum so far
			long rightSum = total - prefixSum;
			
			if (prefixSum >= rightSum) {
				ans++;
			}
			
		}
		return ans;
	}
	
	public int waysToSplitArray(int[] nums) {
		int n = nums.length;
		long[] prefixSum = new long[n];
		
		for (int i = n - 1; i >= 0; i--) {
			prefixSum[i] = i == n - 1 ? nums[i] : prefixSum[i + 1] + nums[i];
			
		}
		System.out.println(Arrays.toString(prefixSum));
		int ans = 0;
		
		/*
1.The sum of the first i + 1 elements is greater than or equal to the
 sum of the last n - i - 1 elements.
2.There is at least one element to the right of i. That is, 0 <= i < n - 1.
		 */
		for (int i = 0; i < n - 1; i++) {
			long sum_fist = prefixSum[0] - prefixSum[i + 1];
			long last_sum = prefixSum[i + 1];
			if (sum_fist >= last_sum) {
				ans++;
			}
			
		}
		
		return ans;
		
	}
}
