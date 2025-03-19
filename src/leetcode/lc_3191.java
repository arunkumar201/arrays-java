package leetcode;

public class lc_3191 {
	
	public static void main(String[] args) {
		//Input: nums = [0,1,1,1,0,0]
		//Output: 3
		
		int[] nums = {0, 1, 1, 1, 0, 0};
		System.out.println(new lc_3191().minOperations(nums)); // Output: 3
		
	}
	
	public int minOperations(int[] nums) {
		int n = nums.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				if (i + 2 < n) {
					nums[i] = 1;
					nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
					nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
					ans++;
				} else {
					return -1;
				}
			}
		}
		return ans;
	}
}
