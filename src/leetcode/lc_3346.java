
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_3346 {

	public static void main(String[] args) {
		// Input: nums = [5,11,20,20], k = 5, numOperations = 1 - ans=2
		int[] nums = { 88, 53 };
		int k = 27;
		int numOperations = 2;
		lc_3346 lc_3346 = new lc_3346();
		System.out.println(lc_3346.maxFrequencyBruteForce(nums, k, numOperations));
	}

	public int maxFrequencyBruteForce(int[] nums, int k, int numOperations) {
		int maxFrequency = 1;

		Map<Integer, Integer> original_frequency_map = new HashMap<>();
		Map<Integer, Integer> frequency_map = new HashMap<>();

		for (int num : nums) {
			original_frequency_map.put(num, original_frequency_map.getOrDefault(num, 0) + 1);

			for (int i = -k; i <= k; i++) {
				int modified_num = num + i;
				frequency_map.put(modified_num, frequency_map.getOrDefault(modified_num, 0) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : frequency_map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			int orig = original_frequency_map.getOrDefault(key, 0);
			int canGet = Math.min(value, orig + numOperations);
			maxFrequency = Math.max(maxFrequency, canGet);
		}
	
		return maxFrequency;
	}
}
