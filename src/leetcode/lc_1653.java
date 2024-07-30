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
	
	public static void main(String[] args) {
		//Input: s = "aababbab"
		String s = "aababbab";
		int res = new lc_1653().minDeletionsOptimal(s);
		System.out.println(res);
	}
}
