package leetcode;

public class lc_2206 {
	
	public static void main(String[] args) {
		//Input: nums = [3,2,3,2,2,2]
		//Output: true
		
		int[] nums = {1, 2, 3, 4, 4, 3};
		System.out.println(new lc_2206().divideArray(nums)); // Output: true
		
	}
	
	public boolean divideArray(int[] nums) {
		int[] count = new int[501];
		int n = nums.length;
		for (int num : nums) {
			count[num]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0 && count[i] % 2 != 0) {
				return false;  // if any element is odd, then return false
			}
		}
		// if all elements are even, then return true
		return true;
	}
}
