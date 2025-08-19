package leetcode;

public class lc_2348 {
	
	public static void main(String[] args) {
		
		//Input: nums = [1,3,0,0,2,0,0,4] -6
//		Input: nums = [0,0,0,2,0,0] -9
		
		int[] nums = {0, 0, 0, 2, 0, 0};
		lc_2348 lc = new lc_2348();
		long res = lc.zeroFilledSubarray(nums);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.zeroFilledSubarray_optimized(nums);
		System.out.println(res);
		
	}
	
	public long zeroFilledSubarray(int[] nums) {
		
		int len = nums.length;
		long ans = 0;
		
		int left = 0;
		int right = 0;
		while (right < len) {
			int currentNum = nums[right];
			
			if (currentNum != 0) {
				left = right + 1;
			}
			ans += (long) right - left + 1;
			right++;
		}
		return ans;
	}
	
	public long zeroFilledSubarray_optimized(int[] nums) {
		long ans = 0;
		int count = 0;
		for (int num : nums) {
			if (num == 0) {
				count++;
				ans += count;
			} else {
				count = 0;
			}
		}
		return ans;
	}
	
}
