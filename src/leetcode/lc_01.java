package leetcode;

import java.util.HashMap;

public class lc_01 {
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = new lc_01().twoSum(nums, target);
		System.out.println("index1: " + result[0] + ", index2: " + result[1]);
		
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		HashMap<Integer, Integer> mp = new HashMap<>();
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int searchNum = target - nums[i];
			if (mp.containsKey(searchNum)) {
				return new int[]{i, mp.get(searchNum)};
			} else {
				mp.put(nums[i], i);
			}
		}
		
		return ans;
	}
}
