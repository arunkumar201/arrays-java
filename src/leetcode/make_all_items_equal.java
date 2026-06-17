package leetcode;

import java.util.Arrays;

public class make_all_items_equal {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4};
		
		make_all_items_equal solution = new make_all_items_equal();
		System.out.println("Minimum operations to make array equal: " + solution.minimumOperations(nums));
	}
	
	/**
	 * Returns the minimum number of operations to make all array elements equal.
	 * One operation means incrementing or decrementing an element by 1.
	 * The optimal target is the median of the sorted array.
	 */
	public int minimumOperations(int[] nums) {
		Arrays.sort(nums); // Sort the array to find the median easily
		int n = nums.length;
		
		// If the array length is odd, use the middle element
		if (n % 2 == 1) {
			int median = nums[n / 2];
			return totalOperations(nums, median);
		}
		
		// If even, try both middle elements and return the one with fewer operations
		int mid1 = nums[n / 2 - 1];
		int mid2 = nums[n / 2];
		return Math.min(totalOperations(nums, mid1), totalOperations(nums, mid2));
	}
	
	private int totalOperations(int[] nums, int target) {
		int ops = 0;
		for (int num : nums) {
			ops += Math.abs(num - target);
		}
		return ops;
	}
}
