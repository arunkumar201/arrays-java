package leetcode;

public class lc_3024 {
	
	public static void main(String[] args) {
		//Input: nums = [3,3,3]
		//Output: "Triangle"
		lc_3024 solution = new lc_3024();
		String result = solution.triangleType(new int[]{3, 3, 3});
		System.out.println("Result: " + result);
		
	}
	
	public String triangleType(int[] nums) {
		int a = nums[0], b = nums[1], c = nums[2];
		// Check if the triangle is valid
		if (a + b <= c || a + c <= b || b + c <= a) return "none";
		if (a == b && b == c) return "equilateral";
		if (a == b || b == c || a == c) return "isosceles";
		return "scalene";
	}
}
