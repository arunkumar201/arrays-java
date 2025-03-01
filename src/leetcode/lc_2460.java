package leetcode;

import java.util.Arrays;

public class lc_2460 {
	
	
	public static void main(String[] args) {
		//Input: nums = [1,2,2,1,1,0]
		//Output: [1,4,2,0,0,0]
		int[] nums = {0, 1};
		System.out.println(Arrays.toString(new lc_2460().applyOperations(nums)));
		
	}
	
	public int[] applyOperations(int[] nums) {
		int n = nums.length;
		
		for (int i = 0; i < n - 1; i++) {
			int a = nums[i];
			int b = nums[i + 1];
			if (a != 0 && a == b) {
				nums[i] = a * 2;
				nums[i + 1] = 0;
			}
		}
		//shift all zero to last
		int j = 0;
		//extra effort - we can optimize it
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		while (j < n) {
			nums[j++] = 0;
		}
		
		return nums;
	}
	
	
}
