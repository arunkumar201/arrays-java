package leetcode;

import java.util.Stack;

public class lc_2375 {
	
	
	public static void main(String[] args) {
		//Input: pattern = "IIIDIDDD"
		String pattern = "IIIDIDDD";
		System.out.println(new lc_2375().smallestNumber(pattern));
		
	}
	
	public String smallestNumber(String pattern) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int num = 1;
		
		for (int i = 0; i <= pattern.length(); i++) {
			stack.push(num++);
			if (i == pattern.length() || pattern.charAt(i) == 'I') {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
			}
		}
		
		return result.toString();
	}
}
