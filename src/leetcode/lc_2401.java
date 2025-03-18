package leetcode;

public class lc_2401 {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 3, 8, 48, 10};
		System.out.println(new lc_2401().longestNiceSubarray(nums)); // Output: 3
	}
	
	public int longestNiceSubarray(int[] nums) {
		int n = nums.length;
		int maxLen = 0;
		int curr_mask = 0; //set of active bits for the current subarray.
		//A subarray is valid if no two elements in it share the same bit.
		int left = 0, right = 0;
		while (right < n) {
			System.out.println(curr_mask);
			while ((curr_mask & nums[right]) != 0) {
				curr_mask ^= nums[left]; // rm leftmost element's bits
				left++;
			}
			curr_mask |= nums[right]; //set rightmost element's bits
			right++;
			
			int len = right - left;
			maxLen = Math.max(maxLen, len);
		}
		return maxLen;
	}
}
