package leetcode;

import java.util.Arrays;

public class lc_2099 {
	public static void main(String[] args) {
		//Input: nums = [1,2,3,1], k = 2
		//Output: [1,2,3,1]
		lc_2099 solution = new lc_2099();
		int[] nums = new int[]{1, 2, 3, 1};
		int k = 2;
		System.out.println("Result: " + Arrays.toString(solution.maxSubsequence(nums, k)));
		
	}
	
	public int[] maxSubsequence(int[] nums, int k) {
		int[] result = new int[k];
		int n = nums.length;
		
		// enhanced 2D array - which holds the items - [value, index]
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = nums[i]; // value
			arr[i][1] = i;
		}
		
		// sort the array based on the value
		Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
		
		//copy the first k elements
		int[][] copy = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			copy[i][0] = arr[i][0];
			copy[i][1] = arr[i][1];
		}
		//sort them in descending order by index
		Arrays.sort(copy, (a, b) -> Integer.compare(b[1], a[1]));
		
		// copy the values in the result array
		for (int i = 0; i < k; i++) {
			result[i] = copy[i][0];
		}
		return result;
	}
	
	public int[] maxSubsequence_priorityQueue(int[] nums, int k) {
		int[] result = new int[k];
		int n = nums.length;
		
		//TODO
		
		return result;
		
		
	}
}
