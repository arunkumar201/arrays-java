
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_3346 {

	public static void main(String[] args) {
		// Input: nums = [5,11,20,20], k = 5, numOperations = 1 - ans=2
		// int[] nums = { 88, 53 };
		int[] nums = { 1, 4, 5 };
		int k = 1;
		int numOperations = 2;
		lc_3346 lc_3346 = new lc_3346();
		System.out.println(lc_3346.maxFrequencyBruteForce(nums, k, numOperations));
		System.out.println("--  ------ --- ");
		System.out.println(lc_3346.maxFrequencyBruteForce_1(nums, k, numOperations));

		System.out.println("Optimized " + lc_3346.maxFrequency(nums, k, numOperations));
	}

	public int maxFrequency(int[] nums, int k, int numOperations) {
		int maxFrequency = 0;

		// Step 1: Find the maximum value to determine array size
		int max_item = Integer.MIN_VALUE;
		for (int num : nums) {
			max_item = Math.max(max_item, num);
		}

		// Step 2: Create frequency array
		// Size = max_item + k + 1 (because we can increase max_item by k)
		int[] freq = new int[max_item + k + 1];
		for (int num : nums) {
			freq[num]++; // Count how many times each number appears
		}

		// Step 3: Convert to prefix sum (cumulative sum)
		// freq[i] now = total count of numbers from 0 to i
		for (int i = 1; i < freq.length; i++) {
			freq[i] += freq[i - 1];
		}
		// Example: nums = [1,4,5], freq becomes [0,1,1,1,2,3,...]
		// means: 0 nums ≤0, 1 num ≤1, 1 num ≤2, 1 num ≤3, 2 nums ≤4, 3 nums ≤5

		// Step 4: Try each existing number as a target
		for (int target = 0; target <= max_item; target++) {
			// Skip if this number doesn't exist in original array
			if (freq[target] == 0)
				continue;

			// Define the range: any number in [target-k, target+k] can become target
			int leftNum = target - k;
			int rightNum = target + k;

			// Count how many numbers are in range [leftNum, rightNum]
			// Using prefix sum: freq[right] - freq[left-1]
			int totalCount = freq[rightNum] - (leftNum - 1 < 0 ? 0 : freq[leftNum - 1]);

			// Count how many numbers already equal target (no operation needed)
			int targetCount = freq[target] - (target - 1 < 0 ? 0 : freq[target - 1]);

			// Count how many numbers need conversion (are in range but not equal to target)
			int needsConversion = totalCount - targetCount;

			// We can convert at most numOperations numbers
			// Final frequency = already equal + converted
			int maxPossibleFreq = targetCount + Math.min(needsConversion, numOperations);

			maxFrequency = Math.max(maxFrequency, maxPossibleFreq);
		}

		return maxFrequency;
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

	public int maxFrequencyBruteForce_1(int[] nums, int k, int numOperations) {
		int maxFrequency = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int target = nums[i];
			int count = 0;
			int ops = numOperations;

			for (int j = 0; j < n; j++) {
				int diff = Math.abs(nums[j] - target);
				if (diff == 0) { // already equal or same item
					count++;
				} else if (ops > 0 && diff <= k) {
					count++; // Can reach target with operation
					ops--;
				}
			}
			maxFrequency = Math.max(maxFrequency, count);
		}

		// Try all possible target values (that aren't in the array)
		int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
		for (int num : nums) {
			minVal = Math.min(minVal, num - k);
			maxVal = Math.max(maxVal, num + k);
		}

		for (int target = minVal; target <= maxVal; target++) {
			int count = 0;
			int ops = numOperations;

			for (int num : nums) {
				int diff = Math.abs(num - target);
				if (diff <= k && ops > 0) {
					count++;
					ops--;
				}
			}
			maxFrequency = Math.max(maxFrequency, count);
		}

		return maxFrequency;
	}
}
