package leetcode;

import java.util.Arrays;

public class lc_1769 {
	
	public static void main(String[] args) {
		//Input: boxes = "110"
		String boxes = "001011";
		int[] res = new lc_1769().minOperations_BruteForce(boxes);
		System.out.println(Arrays.toString(res));
		//with Space
		res = new lc_1769().minOperations_withSpace(boxes);
		System.out.println(Arrays.toString(res));
		
	}
	
	public int[] minOperations_withSpace(String boxes) {
		int n = boxes.length();
		int[] result = new int[n];
		
		int[] left = new int[n];
		int[] right = new int[n];
		
		int operations_left = 0;
		int operations_right = 0;
		
		int count_left = 0;
		int count_right = 0;
		
		for (int i = 0; i < n; i++) {
			left[i] = operations_left;
			right[n - i - 1] = operations_right;
			
			if (boxes.charAt(i) == '1') {
				count_left++;
			}
			if (boxes.charAt(n - i - 1) == '1') {
				count_right++;
			}
			operations_left += count_left;
			operations_right += count_right;
		}
		for (int i = 0; i < n; i++) {
			result[i] = left[i] + right[i];
		}
		
		return result;
	}
	
	public int[] minOperations_BruteForce(String boxes) {
		int n = boxes.length();
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (i == j || boxes.charAt(j) == '0') continue;
				count += Math.abs(j - i);
				
			}
			result[i] = count;
		}
		return result;
		
	}
	
	
}
