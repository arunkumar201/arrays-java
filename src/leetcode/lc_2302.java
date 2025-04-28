package leetcode;

import java.util.Arrays;

public class lc_2302 {
	
	public static void main(String[] args) {
		//Input: nums = [2,1,4,3,5], k = 10
		int[] nums = {2, 1, 4, 3, 5};
		long k = 10;
		long result = new lc_2302().countSubarrays_bruteForce(nums, k);
		System.out.println(result);
		
		System.out.println("-----Optimal Solution-----");
		
		result = new lc_2302().countSubarrays(nums, k);
		System.out.println(result);
		
		System.out.println("-----Optimized Solution-----");
		
		result = new lc_2302().countSubarrays_optimized(nums, k);
		System.out.println(result);
		
		
	}
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(1)
	public long countSubarrays_bruteForce(int[] nums, long k) {
		long count = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			long x = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				x++;
				if (sum * (x) >= k) {
					break;
				}
				if (sum * (x) < k) {
					count++;
				}
				
			}
		}
		return count;
	}
	
	public long countSubarrays(int[] nums, long k) {
		long count = 0;
		int n = nums.length;
		
		//prefix sum
		long[] prefixSum = new long[n];
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		System.out.println(Arrays.toString(prefixSum));
		
		int left = 0;
		for (int right = 0; right < n; right++) {
			while (left <= right) {
				long sum = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
				long x = right - left + 1;
				if ((sum * x) < k) {
					break;
				}
				left++;
				
			}
			count += right - left + 1;
		}
		
		return count;
	}
	
	public long countSubarrays_optimized(int[] nums, long k) {
		long count = 0;
		int n = nums.length;
		long sum = 0;
		int left = 0;
		for (int right = 0; right < n; right++) {
			
			sum += nums[right];
			
			while (left <= right && sum * (right - left + 1) >= k) {
				sum= sum - nums[left];
				left++;
			}
			count += right - left + 1;
		}
		return count;
	}
}
