package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class lc_966 {
	/**
	 * Given a wordlist, we want to implement a spellchecker that converts a query
	 * word into a correct word.
	 * 
	 * For a given query word, the spell checker handles two categories of spelling
	 * mistakes:
	 * 
	 * Capitalization: If the query matches a word in the wordlist
	 * (case-insensitive), then the query word is returned with the same case as the
	 * case in the wordlist.
	 * Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
	 * Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
	 * Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
	 * Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the
	 * query word with any vowel individually, it matches a word in the wordlist
	 * (case-insensitive), then the query word is returned with the same case as the
	 * match in the wordlist.
	 * Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
	 * Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
	 * Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
	 * In addition, the spell checker operates under the following precedence rules:
	 * 
	 * When the query exactly matches a word in the wordlist (case-sensitive), you
	 * should return the same word back.
	 * When the query matches a word up to capitlization, you should return the
	 * first such match in the wordlist.
	 * When the query matches a word up to vowel errors, you should return the first
	 * such match in the wordlist.
	 * If the query has no matches in the wordlist, you should return the empty
	 * string.
	 * Given some queries, return a list of words answer, where answer[i] is the
	 * correct word for query = queries[i].
	 * 
	 */

	public static void main(String[] args) {
		String[] wordlist = { "KiTe", "kite", "hare", "Hare", "YellOw" };
		String[] queries = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto", "yollow" };
		String[] res = new lc_966().spellchecker_bruteForce(wordlist, queries);
		System.out.println(Arrays.toString(res));

	}

	/*
	 * 1. first we will be targetting the exact match
	 * 2. if not found then we will be targetting the case insensitive match ie.
	 * "Kite".lower() == "kite"
	 * 3. if not found then we will be targetting the vowel insensitive match with
	 * wild card ie. "KiTe" -> "k*t*"
	 * 4. if not found then we will be returning the empty string
	 */
	public void displayMap(Map<String, List<String>> map) {
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

	public boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	public String getWildCardKey(String word) {
		char[] chars = word.toLowerCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (isVowel(chars[i])) {
				chars[i] = '*';
			}
		}
		return new String(chars);
	}

	public String[] spellchecker_bruteForce(String[] wordlist, String[] queries) {
		String[] res = new String[queries.length];

		Map<String, List<String>> map = new HashMap<>();

		// 1 . [key -> [value_1, value_2, value_3]]
		for (String word : wordlist) {
			String key = word.toLowerCase();
			map.put(key, map.getOrDefault(key, new ArrayList<String>()));
			map.get(key).add(word);
			// wild card key
			String wildCardKey = getWildCardKey(word);
			map.put(wildCardKey, map.getOrDefault(wildCardKey, new ArrayList<String>()));
			map.get(wildCardKey).add(word);
		}

		displayMap(map);

		for (int i = 0; i < queries.length; i++) {
			String key = queries[i].toLowerCase();
			if (map.containsKey(key)) {
				res[i] = map.get(key).contains(queries[i]) ? queries[i] : map.get(key).get(0);
				continue;
			}
			String wildCardKey = getWildCardKey(queries[i]);
			if (map.containsKey(wildCardKey)) {
				res[i] = map.get(wildCardKey).contains(queries[i]) ? queries[i] : map.get(wildCardKey).get(0);
				continue;
			}

			res[i] = "";
		}

		return res;
	}

	public String[] spellchecker_better(String[] wordlist, String[] queries) {
		String[] res = new String[queries.length];
		
		HashSet<String> exactMatch = new HashSet<>();

		HashMap<String, String> caseInsensitiveMatch = new HashMap<>();
		HashMap<String, String> vowelInsensitiveMatch = new HashMap<>();


		for (String word : wordlist) {
			exactMatch.add(word);
			caseInsensitiveMatch.putIfAbsent(word.toLowerCase(), word);
			vowelInsensitiveMatch.putIfAbsent(getWildCardKey(word), word);
		}

		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];

			//1. do exact match
			if (exactMatch.contains(query)) {
				res[i] = query;
				continue;
			}

			//2. do case insensitive match
			String lowerCaseQuery = query.toLowerCase();
			if (caseInsensitiveMatch.containsKey(lowerCaseQuery)) {
				res[i] = caseInsensitiveMatch.get(lowerCaseQuery);
				continue;
			}
			String wildCardKey = getWildCardKey(query);

			//3. do vowel insensitive match
			if (vowelInsensitiveMatch.containsKey(wildCardKey)) {
				res[i] = vowelInsensitiveMatch.get(wildCardKey);
				continue;
			}

			res[i] = "";
		}

		return res;
	}

}
