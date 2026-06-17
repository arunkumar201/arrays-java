package leetcode;

import java.util.Arrays;

public class lc_2300 {

	public static void main(String[] args) {
		// Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
		lc_2300 lc_2300 = new lc_2300();
		int[] spells = { 5, 1, 3 };
		int[] potions = { 1, 2, 3, 4, 5 };
		long success = 7;
		System.out.println("brute force solution");
		int[] result = lc_2300.successfulPairs_bruteForce(spells, potions, success);
		System.out.println(Arrays.toString(result));
		System.out.println("optimal solution");
		int[] result_optimal = lc_2300.successfulPairs_optimal(spells, potions, success);
		System.out.println(Arrays.toString(result_optimal));
	}

	public int[] successfulPairs_bruteForce(int[] spells, int[] potions, long success) {
		int n = spells.length;

		int[] successfulPairs = new int[n];

		for (int i = 0; i < n; i++) {
			int spell = spells[i];
			int spell_count = 0;
			for (int j = 0; j < potions.length; j++) {
				long product = (long) spell * potions[j];
				if (product >= success) {
					spell_count++;
				}
			}
			successfulPairs[i] = spell_count;
		}

		return successfulPairs;
	}

	private int getValidPotionPairs(int[] potions, int spell, long success) {
		int left = 0;
		int right = potions.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if ((long) spell * potions[mid] >= success) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans == -1 ? 0 : potions.length - ans;

	}

	public int[] successfulPairs_optimal(int[] spells, int[] potions, long success) {
		int n = spells.length;
		int[] successfulPairs = new int[n];

		Arrays.sort(potions);

		for (int i = 0; i < n; i++) {

			int spell = spells[i];

			int successfulPairs_count = getValidPotionPairs(potions, spell, success);

			successfulPairs[i] = successfulPairs_count;
		}

		return successfulPairs;

	}
}
