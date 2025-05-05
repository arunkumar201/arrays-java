package leetcode.weekly_contest_48;

import java.util.Arrays;

public class question_1 {
	
	public static void main(String[] args) {
		int n = 31;
		int res = new question_1().maxProduct_optimized(n);
		System.out.println(res);
	}
	
	public int maxProduct(int n) {
		String s = String.valueOf(n);
		int len = s.length();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = s.charAt(i) - '0';
		}
		Arrays.sort(nums);
		return nums[len - 1] * nums[len - 2];
	}
	
	public int maxProduct_optimized(int n) {
		int x = Integer.MIN_VALUE;
		int y = Integer.MAX_VALUE;
		
		while (n > 0) {
			int digit = n % 10;
			if (digit >= x) {
				y = x;
				x = digit;
			} else if (digit > y) {
				y = digit;
			}
			n /= 10;
		}
		return x * y;
	}
}
