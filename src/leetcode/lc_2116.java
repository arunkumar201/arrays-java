package leetcode;

import java.util.Stack;

public class lc_2116 {
	
	public static void main(String[] args) {
		//Input: s = "))()))", locked = "010100"
		String s = "))()))";
		String locked = "010100";
		System.out.println(new lc_2116().canBeValid(s, locked));
	}
	
	public boolean canBeValid(String s, String locked) {
		int n = s.length();
		
		if (n % 2 != 0) {
			return false;
		}
		
		Stack<Integer> unlockedStack = new Stack<>();
		Stack<Integer> lockedStack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			char lock = locked.charAt(i);
			
			if (lock == '0') {
				unlockedStack.push(i);
			} else if (c == '(') {
				lockedStack.push(i);
				
			} else {
				if (!lockedStack.isEmpty()) {
					lockedStack.pop();
				} else if (!unlockedStack.isEmpty()) {
					unlockedStack.pop();
				} else {
					return false;
				}
				
			}
		}
		
		while (!lockedStack.isEmpty() && !unlockedStack.isEmpty() && lockedStack.getLast() < unlockedStack.getLast()) {
			lockedStack.pop();
			unlockedStack.pop();
		}
		return lockedStack.isEmpty();
	}
}
