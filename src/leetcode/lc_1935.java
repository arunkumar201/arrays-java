package leetcode;

import java.util.Arrays;

public class lc_1935 {

	public static void main(String[] args) {
		// Input: text = "hello world", brokenLetters = "ad"
		String text = "leet code";
		String brokenLetters = "lt";
		int res = new lc_1935().canBeTypedWords(text, brokenLetters);
		System.out.println("result " + res);
		System.out.println("-".repeat(20));
		int res_1 = new lc_1935().canBeTypedWords_optimized(text, brokenLetters);
		System.out.println("result using optimized " + res_1);

	}

	public int canBeTypedWords_optimized(String text, String brokenLetters) {
		int res = 0;
		int n = text.length();
		int[] chars = new int[26];
		for (int i = 0; i < brokenLetters.length(); i++) {
			chars[brokenLetters.charAt(i) - 'a'] = 1;
		}

		boolean hasBrokenLetter = false;
		for (int i = 0; i < n; i++) {
			char c = text.charAt(i);
			if (c != ' ') {
				if (chars[c - 'a'] > 0) {
					hasBrokenLetter = true;
				}
			}
			if (c == ' ' || i == n - 1) {
				if (!hasBrokenLetter) {
					res++;
				}
				hasBrokenLetter = false;
			}
		}

		return res;
	}

	public int canBeTypedWords(String text, String brokenLetters) {
		int res = 0;
		int n = text.length();
		int[] chars = new int[26];
		for (int i = 0; i < brokenLetters.length(); i++) {
			chars[brokenLetters.charAt(i) - 'a'] = 1;
		}

		for (int i = 0; i < n; i++) {
			boolean isBreakable = false;
			while (i < n && text.charAt(i) != ' ') {
				if (chars[text.charAt(i) - 'a'] > 0) {
					isBreakable = true;
				}
				i++;
			}
			if (!isBreakable) {
				res++;
			}
		}

		return res;
	}

}
