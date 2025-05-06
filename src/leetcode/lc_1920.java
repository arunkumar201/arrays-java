package leetcode;

import java.util.Arrays;

public class lc_1920 {
	
	public static void main(String[] args) {
		//Input: nums = [0,2,1,5,3,4]
		int[] nums = {0, 2, 1, 5, 3, 4};
		int[] res = new lc_1920().buildArray_optimized(nums);
		System.out.println(Arrays.toString(res));
		
	}
	
	public int[] buildArray(int[] nums) {
		int[] ans = new int[nums.length];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			ans[i] = nums[nums[i]];
		}
		
		return ans;
		
	}
	
	public int[] buildArray_optimized(int[] nums) {
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] + (1001 * (nums[nums[i]] % 1001));
		}
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] / 1001;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
