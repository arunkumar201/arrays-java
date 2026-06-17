package leetcode;

import java.util.Arrays;

public class lc_3354 {

	public static void main(String[] args) {
		// Input: nums = [1,0,2,0,3]
		int[] nums = { 1, 0, 2, 0, 3 };
		lc_3354 lc_3354 = new lc_3354();
		System.out.println(lc_3354.countValidSelections(nums));
	}

	public int countValidSelections(int[] nums) {
		int validSelections = 0;
		int n = nums.length;

		int total_sum = 0;

		for (int i = 0; i < n; i++) {
			total_sum += nums[i];
		}

		int left_sum = 0;
		for (int i = 0; i < n; i++) {
			left_sum += nums[i];
			int right_sum = total_sum - left_sum;

			if (nums[i] == 0) {
				if (left_sum == right_sum) {
					validSelections += 2;
				} else if (Math.abs(left_sum - right_sum) == 1) {
					validSelections += 1;
				}
			}
		}
		return validSelections;
	}
}
