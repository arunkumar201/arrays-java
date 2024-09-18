package leetcode;

import java.util.Arrays;

public class lc_179 {
	   public String largestNumber(int[] nums) {
        int n = nums.length;
        int i=0;
        String[] strs = new String[n];
		
        for (int num : nums) {
            strs[i++] = String.valueOf(num);
        }
        // Sort the strings based on custom comparison logic
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
	
	public static void main(String[] args) {
		//Input: nums = [3,30,34,5,9]
		int[] nums = new int[]{3, 30, 34, 5, 9};
		System.out.println(new lc_179().largestNumber(nums)); // Output: "9534330"
	}
}
