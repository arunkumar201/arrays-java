package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_2598 {

	public static void main(String[] args) {

		// Input: nums = [1,-10,7,13,6,8], value = 5

		int[] nums = { 1, -10, 7, 13, 6, 8 };
		int value = 5;
		lc_2598 lc_2598 = new lc_2598();
		System.out.println(lc_2598.findSmallestInteger(nums, value));
	}

	public int findSmallestInteger(int[] nums, int value) {
		int n = nums.length;
		int mex = 0;

		int[] count = new int[value];

		// iterate over the nums
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			int rem = num % value;
			if (rem < 0) {
				rem += value;
			}
			count[rem]++;
		}

		while (true) {
			int rem = mex % value;
			if(count[rem]==0) {
				break;
			}
			count[rem]--;
			mex++;
		}
		return mex;
	}
}
