
package leetcode;

import java.util.Arrays;

public class lc_611 {

	public static void main(String[] args) {
		lc_611 lc_611 = new lc_611();
		int[] nums = { 2, 2, 3, 4, 4, 3, 5, 6, 7, 1, 2, 3, 54 };
		System.out.println(lc_611.triangleNumber_bruteForce(nums));
		System.out.println(lc_611.triangleNumber_optimal(nums));
		System.out.println(lc_611.triangleNumber_better(nums));

	}

	public int triangleNumber_bruteForce(int[] nums) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			int a = nums[i];

			for (int j = i + 1; j < n - 1; j++) {
				int b = nums[j];
				for (int k = j + 1; k < n; k++) {
					int c = nums[k];
					// a+b>c
					// a+c>b
					// b+c>a
					if (a + b > c && a + c > b && b + c > a) {
						count++;
					}
				}
			}
		}

		return count;
	}

	public int triangleNumber_optimal(int[] nums) {
		int count = 0;
		int n = nums.length;
		Arrays.sort(nums);

		System.out.println(Arrays.toString(nums));

		for (int i = n - 1; i >= 0; i--) {
			int a = nums[i];
			int left = 0;
			int right = i - 1;
			while (left < right) {
				int b = nums[left];
				int c = nums[right];

				if (b + c > a) {
					count += right - left;
					right--;
				} else {
					left++;
				}
			}
		}
		return count;
	}

	public int binarySearch(int[] nums, int target, int left, int right) {
		int k = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				k = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return k;
	}

	public int triangleNumber_better(int[] nums) {
		int count = 0;
		int n = nums.length;

		// sort the array
		Arrays.sort(nums);

		if (n < 3) {
			return count;
		}

		for (int i = 0; i < n - 2; i++) {
			int a = nums[i];
			if (a == 0) {
				continue;
			}
			for (int j = i + 1; j < n - 1; j++) {
				int b = nums[j];

				// find the valid c , from j+1 to n-1
				// we are looking an item such that a+b> k where x is the item
				int target = a + b;
				int left = j + 1;
				int right = n - 1;

				int k = binarySearch(nums, target, left, right);
				if (k != -1) {
					// we could form the triangles that can form using i,j items to kth items
					count += k - j;
				}
			}
		}

		return count;
	}
}
