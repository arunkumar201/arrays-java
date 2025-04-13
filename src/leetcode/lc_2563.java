package leetcode;

import java.util.Arrays;

public class lc_2563 {
	
	
	public static void main(String[] args) {
		//Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
		//Output: 6
		int[] nums = {1, 7, 9, 2, 5};
		int lower = 11;
		int upper = 11;
		System.out.println(new lc_2563().countFairPairs_bruteForce(nums, lower, upper));
		System.out.println("--------------");
		System.out.println(new lc_2563().countFairPairs(nums, lower, upper));
	}
	
	public long countFairPairs_bruteForce(int[] nums, int lower, int upper) {
		long count = 0;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = nums[i] + nums[j];
				if (sum >= lower && sum <= upper) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public long countFairPairs(int[] nums, int lower, int upper) {
		long count = 0;
		int n = nums.length;
		Arrays.sort(nums);
		
		for (int i = 0; i < n; i++) {
			long high = binarySearch(nums, i + 1, n - 1, upper - nums[i] + 1);
			long low = binarySearch(nums, i + 1, n - 1, lower - nums[i]);
			count += (high - low);
			
		}
		return count;
	}
	
	public int binarySearch(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
	
}

