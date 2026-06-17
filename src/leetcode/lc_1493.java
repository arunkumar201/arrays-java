package leetcode;

public class lc_1493 {
	
	
	public static void main(String[] args) {
		//Input: nums = [0,1,1,1,0,1,1,0,1]

//		int[] nums = new ihnt[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
		int[] nums = new int[]{1};
		
		lc_1493 sol = new lc_1493();
		
		int result = sol.longestSubarray_bruteForce(nums);
		
		System.out.println("Brute Force " + result);
		result = sol.longestSubarray_slidingWindow(nums);
		System.out.println("using Sliding window " + result);
		
		result = sol.longestSubarray_optimal(nums);
		System.out.println("Optimal Solution " + result);
		
	}
	
	public int longestSubarray_bruteForce(int[] nums) {
		int longest_subarray = 0;
		boolean hasZero = false;
		
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int count = 0;
			
			for (int j = i; j < n; j++) {
				if (nums[j] == 0) {
					hasZero = true;
					count++;
				}
				if (count <= 1) {
					int current_sub_arr_len = count == 0 ? j - i + 1 : j - i;
					longest_subarray = Math.max(longest_subarray, current_sub_arr_len);
				} else {
					break;
				}
			}
			
		}
		
		return hasZero ? longest_subarray : longest_subarray - 1;
		
	}
	
	public int longestSubarray_slidingWindow(int[] nums) {
		int longest_subarray = 0;
		int left = 0;
		int right = 0;
		int n = nums.length;
		int count = 0;
		while (right < n) {
			
			if (nums[right] == 0) {
				count++;
			}
			
			while (count > 1 && left < n) {
				if (nums[left] == 0) {
					count--;
				}
				left++;
			}
			
			longest_subarray = Math.max(longest_subarray, right - left + 1);
			right++;
			
			
		}
		return longest_subarray - 1;
	}
	
	public int longestSubarray_optimal(int[] nums) {
		int n = nums.length;
		
		int left = 0;
		int right = 0;
		int firstZeroIndex = -1; // index of the first zero in the current window
		int maxLength = 0;
		
		while (right < n) {
			if (nums[right] == 0) {
				if (firstZeroIndex == -1) {
					// got - First zero in this window
					firstZeroIndex = right;
					right++;
				} else {
					// Found a second zero → must "cut off" the old window
					//0,1,1,1,0 -> 3 by 4-0-1= 3
					maxLength = Math.max(maxLength, right - left - 1);
					left = firstZeroIndex + 1;
					//reset , and looking for first zero
					firstZeroIndex = -1;
				}
			} else {
				//expand the window
				right++;
			}
		}
		
		// After loop ends, we may still have a valid window at the end
		return Math.max(maxLength, right - left - 1);
	}
}
