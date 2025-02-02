package leetcode;

public class biweekly_contest_149 {
	
	public static void main(String[] args) {
		//Input: s = "2523533"
		String s = "2523533";
		System.out.println(new biweekly_contest_149().findValidPair(s)); // Output: "23"
		
	}
	
	public String findValidPair(String s) {
		int[] digits = new int[10];
		char[] str = s.toCharArray();
		int n = s.length();
		for (char c : str) {
			digits[c - '0']++;
		}
		
		for (int i = 1; i < n; i++) {
			int first_pair = str[i - 1] - '0';
			int second_pair = str[i] - '0';
			
			if (first_pair != second_pair && (digits[first_pair] == first_pair && digits[second_pair] == second_pair)) {
				return String.valueOf(first_pair) + second_pair;
			}
		}
		
		return "";
	}
	
}

