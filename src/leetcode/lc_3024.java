package leetcode;

import java.util.Arrays;

public class lc_3024 {
	
	public static void main(String[] args) {
		//Input: nums = [3,3,3]
		//Output: "Triangle"
		lc_3024 solution = new lc_3024();
		String result = solution.triangleType(new int[]{3, 3, 3});
		System.out.println("Result: " + result);
		
	}
	
	public String triangleType_sort(int[] nums) {
		//Sort the array
		Arrays.sort(nums);
		
		//check for invalid triangle
		if (nums[0] + nums[1] <= nums[2]) {
			return "none";
		}
		
		//check for equilateral triangle
		if (nums[0] == nums[1] && nums[1] == nums[2]) {
			return "equilateral";
		}
		
		//check for isosceles triangle
		if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
			return "isosceles";
		}
		
		//check for scalene triangle
		return "scalene";
	}
	
	public String triangleType(int[] nums) {
		int a = nums[0];
		int b = nums[1];
		int c = nums[2];
		
		if (a + b <= c || a + c <= b || b + c <= a) {
			return "none";
		} else if (a == b && b == c) {
			return "equilateral";
		} else if (a == b || b == c || a == c) {
			return "isosceles";
		} else {
			return "scalene";
		}
	}
}
