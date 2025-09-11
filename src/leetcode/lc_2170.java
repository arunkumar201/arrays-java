package leetcode;

import java.util.HashMap;

public class lc_2170 {

	public static void main(String[] args) {
		// Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3]

		// int[] nums1 = { 4, 0, 1, 3, 2 };
		// int[] nums2 = { 4, 1, 0, 2, 3 };
		// int[] nums1 = { 2, 0, 1, 3 };
		// int[] nums2 = { 0, 1, 2, 3 };
		int[] nums1 = { 0, 1, 2, 3, 4 };
		int[] nums2 = { 0, 1, 2, 3, 4 };
		long res_bruteForce = new lc_2170().goodTriplets_bruteForce(nums1, nums2);
		System.out.println("Brute Force: " + res_bruteForce);
		long res_better = new lc_2170().goodTriplets_better(nums1, nums2);
		System.out.println("Better: " + res_better);
	}

	public long goodTriplets_better(int[] nums1, int[] nums2) {
		int n = nums1.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(nums2[i], i);
		}

		int[] mapped = new int[n];
		for (int i = 0; i < n; i++) {
			mapped[i] = map.get(nums1[i]);
		}

		int[] leftSmaller = new int[n];
		for (int j = 0; j < n; j++) {
			int count = 0;
			for (int i = 0; i < j; i++) {
				if (mapped[i] < mapped[j])
					count++;
			}
			leftSmaller[j] = count;
		}

		int[] rightLarger = new int[n];
		for (int j = 0; j < n; j++) {
			int count = 0;
			for (int k = j + 1; k < n; k++) {
				if (mapped[k] > mapped[j])
					count++;
			}
			rightLarger[j] = count;
		}

		long ans = 0;
		for (int j = 0; j < n; j++) {
			ans += (long) leftSmaller[j] * rightLarger[j];
		}
		return ans;
	}

	public long goodTriplets_bruteForce(int[] nums1, int[] nums2) {
		int n = nums1.length;
		long goodTriplets = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		// we will be store the second array item index in the map
		for (int i = 0; i < n; i++) {
			map.put(nums2[i], i);
		}

		// now as we have the index of each item of second array in the map
		// we will iterate over first arr , to get the valid triplets
		for (int i = 0; i < n - 2; i++) {
			int currentItem = nums1[i];
			int leftIndexInNums2 = map.get(currentItem);
			for (int j = i + 1; j < n - 1; j++) {
				int midIndexInNums2 = map.get(nums1[j]);
				if (midIndexInNums2 < leftIndexInNums2) {
					continue;
				} else {
					for (int k = j + 1; k < n; k++) {
						int rightIndexInNums2_2 = map.get(nums1[k]);
						if (rightIndexInNums2_2 < midIndexInNums2) {
							continue;
						} else {
							goodTriplets++;
						}
					}
				}
			}
		}
		return goodTriplets;
	}

}
