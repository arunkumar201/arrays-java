package leetcode.weekly_contest_446;

import java.util.HashSet;
import java.util.Set;

public class question_1 {
	
	public static void main(String[] args) {
		//Input: instructions = ["jump","add","add","jump","add","jump"], values = [2,1,3,1,-2,-3]
		//Output: 1
		int[] values = {2, 1, 3, 1, -2, -3};
		String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
		System.out.println(new question_1().calculateScore(instructions, values));
	}
	
	public long calculateScore(String[] instructions, int[] values) {
		int n = instructions.length;
		//we need to keep track the current index and the current value
		Set<Integer> set = new HashSet<>();
		int index = 0;
		long score = 0;
		
		while (index < n && index >= 0) {
			String instruction = instructions[index];
			int value = values[index];
			int currentIndex = index;
			//if we have already visited this index, we can skip it
			if (set.contains(index)) {
				return score;
			}
			
			if (instruction.equals("jump")) {
				index += value;
			} else {
				score += value;
				index++;
			}
			set.add(currentIndex);
			
		}
		return score;
	}
}
