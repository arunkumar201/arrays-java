package leetcode;

import java.util.Stack;

public class lc_2696 {
	public int minLength(String s) {
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		
		while (i < sb.length() - 1) {
			if (sb.substring(i, i + 2).equals("AB") || sb.substring(i, i + 2).equals("CD")) {
				sb.delete(i, i + 2);
				i = Math.max(0, i - 1);
			} else {
				i++;
			}
		}
		
		return sb.length();
	}
	
	//using Stack
//
	public int minLengthStack(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			char current_char = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(current_char);
				continue;
			}
			char top_char = stack.peek();
			if (current_char == 'B' && top_char == 'A' || current_char == 'D' && top_char == 'C') {
				stack.pop();
			} else {
				stack.push(current_char);
			}
		}
		
		return stack.size();
	}
	
	public static void main(String[] args) {
		String s = "ABFCACDB";
		int res = new lc_2696().minLength(s);
		System.out.println(res);  // Output: 2
		
        int res1 = new lc_2696().minLengthStack(s);
		System.out.println(res1);  // Output: 2
	}
}