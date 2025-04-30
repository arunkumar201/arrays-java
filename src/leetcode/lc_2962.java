package leetcode;

public class lc_2962 {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 2, 3, 3};
		int k = 2;
		long res = new lc_2962().countSubarrays(nums, k);
		System.out.println("result=: " + res);
	}
	
	public int getMaxValue(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		return max;
	}
	
	public long countSubarrays(int[] nums, int k) {
		int n = nums.length;
		int max = getMaxValue(nums);
		long res = 0;
		int left = 0, count = 0;
		
		for (int right = 0; right < n; right++) {
			if (nums[right] == max) {
				count++;
			}
			
			while (count >= k) {
				res += n - right;
				if (nums[left] == max) {
					count--;
				}
				left++;
			}
		}
		
		return res;
	}
	
}
