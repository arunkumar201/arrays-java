package leetcode;

public class lc_3392 {
	
	public static void main(String[] args) {
		//Input: nums = [1,2,1,4,1]
		int[] nums = new int[]{-1, -4, -1, 4};
		int result = new lc_3392().countSubarrays(nums);
		System.out.println(result);
		
	}
	
	public int countSubarrays(int[] nums) {
		int count = 0;
		for (int i = 0; i <= nums.length - 3; i++) {
			if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
				count++;
			}
		}
		return count;
	}
}
