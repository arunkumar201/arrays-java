package leetcode;

public class lc_3190 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(new lc_3190().minimumOperations(nums));

	}
	
	public int minimumOperations(int[] nums) {
		int n = nums.length;
		int count = 0;

		//if remainder is 2, then we just need to add 1 to make it divisible by 3
		//if remainder is 1, then we need to subtract 1 to make it divisible by 3
		//if remainder is 0, then we do not need to do anything
		for (int i = 0; i < n; i++) {
			count += nums[i] % 3 == 2 ? 1 : nums[i] % 3;
			//or we can do 
			//if(nums[i]%3!=0) count++;
		}
		
		return count;
		
	}
}
