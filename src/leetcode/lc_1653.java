package leetcode;

import java.util.Stack;

public class lc_1653 {
	
	public int minimumDeletions(String s) {
		Stack<Character> stack = new Stack<>();
		int deletions = 0;
		
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
				stack.pop();
				deletions++;
			} else {
				stack.push(c);
			}
		}
		
		return deletions;
	}
	
	//optimal solution
	public int minDeletionsOptimal(String s) {
		int countB = 0;
		int deletions = 0;
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'b') {
				countB++;
			} else if (countB != 0) {
				deletions++;
				countB--;
			}
		}
		return deletions;
	}

	// using extra space with pre-processing

	public int minDeletionsExtraSpace(String s) {
		int n = s.length();
		int res = n;
		int[] a_count_left = new int[n];

		a_count_left[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			a_count_left[i] += a_count_left[i + 1];
			if (s.charAt(i + 1) == 'a') {
				a_count_left[i] += 1;
			}
		}

		int b_count_right = 0;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, a_count_left[i] + b_count_right);
			if (s.charAt(i) == 'b') {
				b_count_right++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		//Input: s = "aababbab"
		String s = "aababbab";
		int res = new lc_1653().minDeletionsOptimal(s);
		System.out.println(res);
		int res1 = new lc_1653().minDeletionsExtraSpace(s);
		System.out.println("res with extra space " + res1);
	}
}
