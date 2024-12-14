package leetcode;

import java.util.TreeMap;

public class lc_2762 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3};
		long res = new lc_2762().continuousSubarrays_optimized_using_ordered_map(arr);
		System.out.println(res);
	}
	
	public long continuousSubarrays_optimized_using_ordered_map(int[] nums) {
		long res = 0;
		int n = nums.length;
		
        TreeMap<Integer, Integer> map = new TreeMap<>();
		
		int left = 0;
		int right = 0;
		
		while (right < n) {
			map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
			
			while (map.lastKey() - map.firstKey() > 2) {
				int count = map.get(nums[left]);
				if (count == 1) {
					map.remove(nums[left]);
				} else {
					map.put(nums[left], count - 1);
				}
				left++;
			}
			
			res += right - left + 1;
			right++;
		}
		
		return res;
	}
	
	
	public boolean isValidSubArray(int[] nums, int start, int end) {
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		if (nums.length == 1) {
			return true;
		}
		
		for (int i = start; i < end; i++) {
			maxValue = Math.max(maxValue, nums[i]);
			minValue = Math.min(minValue, nums[i]);
			
		}
		int isValid = Math.abs(maxValue - minValue);
		
		return isValid <= 2;
		
	}
	
	public long continuousSubarrays_bruteForce(int[] nums) {
		long ans = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				
				//we can do optimization here
				if (isValidSubArray(nums, i, j + 1)) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	public long continuousSubarrays_bruteForce_optimization(int[] nums) {
		long ans = 0;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int min = nums[i];
			int max = nums[i];
			for (int j = i; j < n; j++) {
				
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);
				
				int isValid = Math.abs(max - min);
				if (isValid <= 2) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	
	//optimize solution
	public long continuousSubarrays_optimized(int[] nums) {
		long ans = 0;
		int n = nums.length;
		int left = 0;
		int right = 0;
		int min = nums[0];
		int max = nums[0];
		
		while (right < n) {
			min = Math.min(min, nums[right]);
			max = Math.max(max, nums[right]);
			
			while (Math.abs(max - min) > 2) {
				left++;
				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;
				for (int j = left; j <= right; j++) {
					min = Math.min(min, nums[j]);
					max = Math.max(max, nums[j]);
				}
			}
			
			ans += right - left + 1;
			right++;
		}
		
		return ans;
	}
}
