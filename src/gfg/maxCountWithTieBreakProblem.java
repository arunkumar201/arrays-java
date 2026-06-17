package gfg;

import java.util.HashMap;
import java.util.Map;

public class maxCountWithTieBreakProblem {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 3, 3 };
		int[] arr2 = { 4, 4, 5, 5, 5, 4 };
		int[] arr3 = { 10, 20, 20, 10 };

		System.out.println(maxCountWithTieBreak(arr1)); // 3
		System.out.println(maxCountWithTieBreak(arr2)); // 5
		System.out.println(maxCountWithTieBreak(arr3)); // 20

	}
	
	public static int maxCountWithTieBreak(int[] arr) {
		HashMap<Integer, Integer> mp = new HashMap<>();

		for (int num : arr) {
			mp.put(num, mp.getOrDefault(mp, 0) + 1);
		}

		int max_count = 0;
		int max_num = Integer.MIN_VALUE;


		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();

			if (value > max_count || (value == max_count && key > max_num)) {
				max_count = value;
				max_num = key;
			}
		}

		return max_num;
	}
	
}
