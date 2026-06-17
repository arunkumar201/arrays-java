package leetcode;

import java.util.List;

public class lc_3350 {
	public static void main(String[] args) {
		// Input: nums = [2,5,7,8,9,2,3,4,3,1]
		// List<Integer> nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1); // 3
		// -8,7,-16,-7,18
		// List<Integer> nums2 = List.of(-8, 7, -16, -7, 18);//2
		// 13,-7,17,-10,1,7);//2
		List<Integer> nums3 = List.of(13, -7, 17, -10, 1, 7);// 2
		lc_3350 lc_3350 = new lc_3350();
		System.out.println(lc_3350.maxIncreasingSubarrays(nums3));
	}

	public int maxIncreasingSubarrays(List<Integer> nums) {
		int n = nums.size();
		int maxK = 0;

		int prevInc = 0;
		int currInc = 1;

		for (int i = 1; i < n; i++) {
			if (nums.get(i) > nums.get(i - 1)) {
				currInc++;
			} else {
				maxK = Math.max(maxK, Math.min(prevInc, currInc));
				prevInc = currInc;
				currInc = 1;
			}
		}
		maxK = Math.max(maxK, currInc / 2);
		maxK = Math.max(maxK, Math.min(prevInc, currInc));
		return maxK;
	}

	public int maxIncreasingSubarrays_bruteForce(List<Integer> nums) {
		int n = nums.size();
		int max_sized_subarray = 0;
		int left_sub_arr_size = 0;
		int right_sub_arr_size = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			left_sub_arr_size = 1;
			for (j = 1 + i; j < n; j++) {
				if (nums.get(j) > nums.get(j - 1)) {
					left_sub_arr_size++;
				} else {
					break;
				}
			}
			System.out.println("left_sub_arr_size:" + left_sub_arr_size);

			max_sized_subarray = Math.max(max_sized_subarray, left_sub_arr_size / 2);
			right_sub_arr_size = 1;

			// check can we found next Kth size subarray
			System.out.println("when i was ->>>>>>> " + i);
			System.out.println("(2 * j) - i:" + ((2 * j) - i));
			if ((2 * j) - i <= n) {
				for (int k = j + 1; k < ((2 * j) - i) && k < n; k++) {
					System.out.println("curr item " + nums.get(k) + " prev item " + nums.get(k - 1));
					if (nums.get(k) > nums.get(k - 1)) {
						right_sub_arr_size++;
					} else {
						break;
					}
				}
			}
			System.out.println("right_sub_arr_size:" + right_sub_arr_size);
			if (left_sub_arr_size == right_sub_arr_size) {
				max_sized_subarray = Math.max(max_sized_subarray, right_sub_arr_size);
			}
			System.out.println("----->>> >>>> - >>>> ");
		}

		return max_sized_subarray;
	}
}
