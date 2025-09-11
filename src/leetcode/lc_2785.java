package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class lc_2785 {

	public static void main(String[] args) {
		// Input: s = "lEetcOde"
		String s = "lEetcOde";
		lc_2785 sol = new lc_2785();
		String res = sol.sortVowels(s);
		System.out.println("result " + res);
		String res_optimized = sol.sortVowels_optimized(s);
		System.out.println("result optimized " + res_optimized);

	}

	private boolean isVowel(char s) {
		return "AEIOUaeiou".indexOf(s) != -1;

	}

	public String sortVowels(String s) {
		StringBuilder sb = new StringBuilder(s);

		ArrayList<Character> vowelList = new ArrayList<>();

		// store as per asci order or value of char
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				vowelList.add(c);
			}
		}

		Collections.sort(vowelList);

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				sb.setCharAt(i, vowelList.get(j++));
			}
		}

		return sb.toString();

	}

	public int getNextVowel(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				return i;
			}
		}
		return -1;
	}

	public String sortVowels_optimized(String s) {
		StringBuilder sb = new StringBuilder(s);
		int len = s.length();
		// vowel
		int[] count = new int[52];
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				count[c - 'A']++;
			}
		}
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				int nextVowel = getNextVowel(count);
				if (nextVowel == -1)
					break;
				sb.setCharAt(i, (char) ('A' + nextVowel));
				count[nextVowel]--;
			}
		}
		return sb.toString();

	}
}
