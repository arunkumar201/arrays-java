
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class lc_1488 {

	public static void main(String[] args) {
		// Input: rains = [1,2,0,1,2]
		int[] rains = { 1, 2, 0, 0, 2, 1 };
		lc_1488 lc_1488 = new lc_1488();
		int[] result = lc_1488.avoidFlood(rains);
		System.out.println(Arrays.toString(result));
		System.out.println("Optimal solution");
		int[] result_optimal = lc_1488.avoidFlood_binary_search(rains);
		System.out.println(Arrays.toString(result_optimal));

	}

	public int[] avoidFlood(int[] rains) {
		int[] result = new int[rains.length];

		HashMap<Integer, Integer> fullLakeMap = new HashMap<>();

		TreeSet<Integer> dryDays = new TreeSet<>();

		for (int i = 0; i < rains.length; i++) {
			int lake = rains[i];
			if (lake == 0) {
				dryDays.add(i);
				result[i] = 1;
			} else {
				// its raining
				result[i] = -1;
				if (fullLakeMap.containsKey(lake)) {

					// last rain day - when lake was full
					int lastRainDay = fullLakeMap.get(lake);

					// try to find a day which is greater than last rain day so we can empty the
					// lake
					Integer dryDay = dryDays.higher(lastRainDay);

					// no dry day available before this rain → flood
					if (dryDay == null)
						return new int[] {};

					// on dry day which lake gets empty
					result[dryDay] = lake;
					// remove the dry day from the set
					dryDays.remove(dryDay);
				}

				fullLakeMap.put(lake, i);
			}
		}
		return result;

	}

	// find index in a[0..k-1] of the first element > target, or -1 if none
	private int find_just_greater_num(int[] a, int k, int target) {
		int left = 0, right = k - 1, ans = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] > target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	// using binary search
	public int[] avoidFlood_binary_search(int[] rains) {
		int n = rains.length;

		int[] result = new int[n];

		// keep track of lakes
		HashMap<Integer, Integer> rainOnLakeMp = new HashMap<>();

		int[] dryDays = new int[n];

		int k = 0;
		for (int day = 0; day < n; day++) {
			int lake = rains[day];

			// if curr day is dry day
			if (lake == 0) {
				dryDays[k++] = day;
				result[day] = 1;
			} else {
				result[day] = -1;
				// if lake is already filled , so we need to check can we perform the
				// cleaning or empty
				if (rainOnLakeMp.containsKey(lake)) {

					int lakeWasFilledAt = rainOnLakeMp.get(lake);

					int idx = find_just_greater_num(dryDays, k, lakeWasFilledAt);

					if (idx == -1) {
						// no available dry day after last filled day -> impossible
						return new int[] {};
					}
					int chosenDryDay = dryDays[idx];
					result[chosenDryDay] = lake;
					for (int j = idx; j < k - 1; j++) {
						dryDays[j] = dryDays[j + 1];
					}
					k--;
				}
				rainOnLakeMp.put(lake, day);
			}
		}

		return result;

	}
}
