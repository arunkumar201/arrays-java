package leetcode;

public class lc_1800 {
	
	public static void main(String[] args) {
		//Input: nums = [10,20,30,5,10,50]
		int[] nums = {10,20,30,40,50};
		System.out.println(new lc_1800().maxAscendingSum(nums));
		
	}
	
	public int maxAscendingSum(int[] nums) {
		int max_sum = Integer.MIN_VALUE;
		int n = nums.length;
		int my_current_sum = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0 || nums[i - 1] >= nums[i]) {
				my_current_sum = nums[i];
			} else {
				my_current_sum += nums[i];
			}
			// update max_sum
			max_sum = Math.max(max_sum, my_current_sum);
			
		}
		return max_sum;
	}
}
