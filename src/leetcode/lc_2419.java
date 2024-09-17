package leetcode;

public class lc_2419 {
	
	public int longestSubarray(int[] nums) {
		int max_bitwise_AND = 0;
		int max_length = 0;
		int n = nums.length;
		
		
		return max_length;
		
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 3, 2, 2};
		int res = new lc_2419().longestSubarray(nums);
		System.out.println(res); // Output: 2 , max_Bitwise_AND=3, [3,3]
	}
}
