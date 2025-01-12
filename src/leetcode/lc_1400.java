package leetcode;

public class lc_1400 {
	
	
	public static void main(String[] args) {
		//Input: s = "annabelle", k = 2
		String s = "annabelle";
		int k = 2;
		System.out.println(new lc_1400().canConstruct(s, k));
	}
	
	public boolean canConstruct(String s, int k) {
		int n = s.length();
		// If the length of s is less than k,
		//it's impossible to construct k palindromes
		if (n < k) return false;
		
		int[] count = new int[26];
		for (char c : s.toCharArray()) count[c - 'a']++;
		int oddCharCount = 0;
		int evenCharCount = 0;
		for (int i : count) {
			if (i == 0) continue;
			if (i % 2 == 0) evenCharCount++;
			else oddCharCount++;
		}
        // we can construct k palindromes
		// if and only if
		// the number of odd characters is not more than k.
        // Otherwise, we can't form a palindrome with k odd characters.
		return oddCharCount <= k;
	}
}
