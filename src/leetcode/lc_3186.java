package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class lc_3186 {
	public static void main(String[] args) {
		// Input: power = [1,1,3,4]

		int[] power = { 7, 1, 6, 3 };
		lc_3186 lc_3186 = new lc_3186();
		System.out.println(lc_3186.maximumTotalDamage(power));
	}
   //not complete solution 
	public long maximumTotalDamage(int[] power) {
		long maximumTotalDamage = 0;
		int n = power.length;

		// [[damage:count],[damage:count]...]
		long[][] damage_count = new long[n][2];
		HashMap<Long, Integer> indexMap = new HashMap<>();

		int uniqueCount = 0;

		for (int i = 0; i < n; i++) {
			long curr = power[i];
			if (!indexMap.containsKey(curr)) {
				damage_count[uniqueCount][0] = curr;
				damage_count[uniqueCount][1] = 1;
				indexMap.put(curr, uniqueCount);
				uniqueCount++;
			} else {
				int idx = indexMap.get(curr);
				damage_count[idx][1]++;
			}
		}

		HashSet<Long> can_not_select_damage = new HashSet<>();

		Arrays.sort(damage_count, 0, uniqueCount, (a, b) -> Long.compare(a[0], b[0]));

		for (int i = uniqueCount - 1; i >= 0; i--) {
			long curr = damage_count[i][0];
			long count = damage_count[i][1];
			if (!can_not_select_damage.contains(curr)) {
				maximumTotalDamage += curr * count;
				can_not_select_damage.add(curr + 1);
				can_not_select_damage.add(curr + 2);
				can_not_select_damage.add(curr - 1);
				can_not_select_damage.add(curr - 2);
			}
		}
		return maximumTotalDamage;
	}

}
