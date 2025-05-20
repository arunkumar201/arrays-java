package leetcode;

public class lc_2765 {
	
	public static void main(String[] args) {
		//Input: nums = [2,3,4,3,4]
		//Output: 4
		
		lc_2765 solution = new lc_2765();
		int result = solution.alternatingSubarray(new int[]{2, 3, 4, 3, 4});
		System.out.println("Result: " + result);
	}
	
	public int alternatingSubarray(int[] nums) {
		int count = 0;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int firstElement = nums[i];
			int secondElement = nums[i + 1];
			
			if (secondElement != firstElement + 1) {
				continue;
			}
			
			for (int j = i + 1; j < n; j++) {
				int isValidSubArrayItem = (nums[j - 1] - nums[j]) * (j % 2 == 0 ? 1 : -1);
				
			}
		}
		return count;
	}
}
