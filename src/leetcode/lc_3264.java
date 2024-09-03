package leetcode;

public class lc_3264 {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		int n = nums.length;
		while (k > 0) {
			int maxIndex = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (nums[i] < min) {
					maxIndex = i;
					min = nums[i];
				}
			}
			
			nums[maxIndex] *= multiplier;
			k--;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		//Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
		int[] nums = new int[]{2, 1, 3, 5, 6};
		int k = 5;
		int multiplier = 2;
		int[] res = new lc_3264().getFinalState(nums, k, multiplier);
		for (int num : res) {
			System.out.print(num + " ");
		}
		
	}
}
