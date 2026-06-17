package leetcode;

import java.util.*;

public class lc_2273 {

	public static void main(String[] args) {
		// Input: words = ["abba","baba","bbaa","cd","cd"]

		String[] words = { "abba", "baba", "bbaa", "cd", "cd" };
		lc_2273 lc_2273 = new lc_2273();
		System.out.println(lc_2273.removeAnagrams(words));
		System.out.println("--");
		System.out.println(lc_2273.removeAnagrams_better(words));
	}

	public List<String> removeAnagrams(String[] words) {
		int n = words.length;

		HashMap<String, String> mp = new HashMap<>();

		for (String word : words) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String sortedWord = new String(ch);
			if (!mp.containsKey(word)) {
				mp.put(word, sortedWord);
			}
		}
		ArrayList<String> result = new ArrayList<>();

		// remove the adjacent anagrams continuously
		result.add(words[0]);
		for (int i = 1; i < n; i++) {
			String prev = words[i - 1];

			String sortedPrev = mp.get(prev);

			String curr = words[i];
			String sortedCurr = mp.get(curr);

			if (!sortedPrev.equals(sortedCurr)) {
				result.add(curr);
			}

		}

		return result;

	}

	public boolean isAnagram(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		if (n1 != n2) {
			return false;
		}

		int[] char_count = new int[26];

		for (int i = 0; i < n1; i++) {
			char_count[s1.charAt(i) - 'a']++;
			char_count[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (char_count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public List<String> removeAnagrams_better(String[] words) {
		int n = words.length;

		ArrayList<String> result = new ArrayList<>();
		result.add(words[0]);

		for (int i = 1; i < n; i++) {
			String curr = words[i];
			String prev = words[i - 1];
			if (!isAnagram(curr, prev)) {
				result.add(curr);
			}
		}
		return result;
	}
}
