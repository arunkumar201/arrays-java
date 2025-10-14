package leetcode;

import java.util.List;

public class lc_3349 {

	public static void main(String[] args) {
		// Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
		List<Integer> nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
		int k = 3;
		lc_3349 lc_3349 = new lc_3349();
		System.out.println(lc_3349.hasIncreasingSubarrays(nums, k));
	}

	public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
		int n = nums.size();

		for (int i = 0; i <= n - 2 * k; i++) {
			// left subarray [i,i+k] - has to be strictly increasing with size k
			boolean leftSubarray = true;
			for (int j = i; j < i + k - 1; j++) {
				if (nums.get(j) >= nums.get(j + 1)) {
					leftSubarray = false;
					break;
				}
			}
			if (!leftSubarray) {
				continue;
			}
			// right subarray [i+k+1,i+k] - has to be strictly increasing with size k
			boolean rightSubarray = true;
			for (int j = i + k; j < i + k + k - 1; j++) {
				if (nums.get(j) >= nums.get(j + 1)) {
					rightSubarray = false;
					break;
				}
			}
			if (leftSubarray && rightSubarray) {
				return true;
			}
		}
		return false;
	}
}
