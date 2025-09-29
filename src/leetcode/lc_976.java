package leetcode;

import java.util.Arrays;

public class lc_976 {

	public static void main(String[] args) {
		lc_976 lc_976 = new lc_976();
		int[] nums = { 1, 2, 1, 10 };
		System.out.println(lc_976.largestPerimeter(nums));
		System.out.println(lc_976.largestPerimeter_optimal(nums));
	}

	public int largestPerimeter(int[] nums) {
		int largestPerimeter = 0;
		int n = nums.length;
		Arrays.sort(nums);

		for (int i = n - 1; i >= 2; i--) {
			int c = nums[i];
			int b = nums[i - 1];
			int a = nums[i - 2];
			if (a + b > c) {
				return a + b + c;
			}
		}

		return largestPerimeter;
	}

	public int largestPerimeter_optimal(int[] nums) {
		int largestPerimeter = 0;
		int n = nums.length;

		// find out the two max element and place them at the end of the array
		swapMaxElement(nums, n - 1);
		swapMaxElement(nums, n - 2);

		for (int i = n - 1; i >= 2; i--) {
			int c = nums[i];
			int b = nums[i - 1];
			// find out the third max element
			swapMaxElement(nums, i - 2);
			int a = nums[i - 2];

			if (a + b > c) {
				return a + b + c;
			}
		}
		return largestPerimeter;

	}

	public void swapMaxElement(int[] nums, int idx) {
		int maxIdx = idx;
		int maxElement = nums[idx];

		for (int i = 0; i <= idx; i++) {
			if (nums[i] > maxElement) {
				maxIdx = i;
				maxElement = nums[i];
			}
		}
		// swap the idx element with maxElement
		int temp = nums[idx];
		nums[idx] = maxElement;
		nums[maxIdx] = temp;
	}
}
