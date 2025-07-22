package leetcode;

import java.util.HashSet;

public class lc_1695 {
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 1, 2, 5, 2, 1, 2, 5};
		System.out.println(new lc_1695().maximumUniqueSubarray(arr));
		System.out.println("Optimized : " + new lc_1695().maximumUniqueSubarray_optimized(arr));
		
	}
	
	public int maximumUniqueSubarray(int[] nums) {
		int n = nums.length;
		int i = 0, j = 0;
		int maxSum = 0, currentSum = 0;
		HashSet<Integer> set = new HashSet<>();
		
		while (j < n) {
			if (!set.contains(nums[j])) {
				set.add(nums[j]);
				currentSum += nums[j];
				maxSum = Math.max(maxSum, currentSum);
				j++;
			} else {
				currentSum -= nums[i];
				set.remove(nums[i]);
				maxSum = Math.max(maxSum, currentSum);
				i++;
			}
		}
		return maxSum;
	}
	
	public int maximumUniqueSubarray_optimized(int[] nums) {
		int n = nums.length;
		int maxSum = 0;
		int currentSum = 0;
		int i = 0;
		int j = 0;
		//set array to store the unique elements
		int[] arr = new int[100001];
		
		while (j < n) {
			if (arr[nums[j]] == 0) {
				currentSum += nums[j];
				maxSum = Math.max(maxSum, currentSum);
				arr[nums[j]] = 1;
				j++;
			} else {
				currentSum -= nums[i];
				arr[nums[i]] = 0;
				maxSum = Math.max(maxSum, currentSum);
				i++;
			}
		}
		
		return maxSum;
	}
	
}

