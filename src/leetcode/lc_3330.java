package leetcode;

public class lc_3330 {
	
	public static void main(String[] args) {
		String word = "abbcccc";
		lc_3330 solution = new lc_3330();
		System.out.println("Result: " + solution.possibleStringCount(word));
	}
	
	public int possibleStringCount(String word) {
		int result = 1;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i - 1) == word.charAt(i)) {
				result++;
			}
		}
		return result;
	}
}
