package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_594 {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
		lc_594 solution = new lc_594();
		System.out.println("Result: " + solution.findLHS(nums));
		System.out.println("Result using sorting: " + solution.findLHS_sorting(nums));
	}
	
	public int findLHS(int[] nums) {
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int result = 0;
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
			int key = pair.getKey();
			int value = pair.getValue();
			
			if (map.containsKey(key + 1)) {
				result = Math.max(result, value + map.get(key + 1));
			}
			
		}
		return result;
		
	}
	
	public int findLHS_sorting(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int maxLen = 0;
		int start = 0;
		
		for (int i = 0; i < n; i++) {
			while (nums[i] - nums[start] > 1) {
				start++;
			}
			if (nums[i] - nums[start] == 1) {
				maxLen = Math.max(maxLen, i - start + 1);
			}
		}
		
		return maxLen;
	}
}
