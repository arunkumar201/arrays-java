
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class lc_1488 {

	public static void main(String[] args) {
		// Input: rains = [1,2,0,1,2]
		int[] rains = { 1, 2, 0, 0, 2, 1 };
		lc_1488 lc_1488 = new lc_1488();
		int[] result = lc_1488.avoidFlood(rains);
		System.out.println(Arrays.toString(result));

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

					//last rain day - when lake was full 
					int lastRainDay = fullLakeMap.get(lake);

					//try to find a day which is greater than last rain day so we can empty the lake 
					Integer dryDay = dryDays.higher(lastRainDay);

					// no dry day available before this rain → flood
					if (dryDay == null)
						return new int[] {};

					result[dryDay] = lake;
					dryDays.remove(dryDay);
				}

				fullLakeMap.put(lake, i);
			}
		}
		return result;

	}
}
