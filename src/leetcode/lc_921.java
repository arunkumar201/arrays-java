package leetcode;

import java.util.Stack;

public class lc_921 {
	
	public int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray()) {
			
			if (c == '(') {
				stack.push(c);
			} else if (!stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size();
	}
	
	public int optimalMinAddToMakeValid(String s) {
		int open = 0, close = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				open++;
			} else if (open > 0) {
				open--;
			} else {
				close++;
			}
		}
		return open + close;
	}
	
	public static void main(String[] args) {
//		Input: s = "())"
		String s = "()";
		int res = new lc_921().minAddToMakeValid(s);
		System.out.println(res);
	}
	
}
