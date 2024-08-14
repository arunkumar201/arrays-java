package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_1512 {
	
	//Brute Force solution
	public int numIdenticalPairs(int[] nums) {
		int ans = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j]) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	//using HashMap
	public int numIdenticalPairs_HashMap(int[] nums) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int num : nums) {
			ans += map.getOrDefault(num, 0);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		//Input: nums = [1,2,3,1,1,3]
		int[] nums = new int[]{1, 1, 1, 1};
		int res = new lc_1512().numIdenticalPairs(nums);
		System.out.println(res);
		
	}
}
