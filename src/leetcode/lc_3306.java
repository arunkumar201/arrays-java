package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_3306 {
	
	public static void main(String[] args) {
		//Input: word = "aeioqq", k = 1
		
		long count = countOfSubstrings("iqeaouqi", 2) - countOfSubstrings("iqeaouqi", 3);
		System.out.println("count = " + count);
		
	}
	
	public static long atLeastK(String word, int k) {
		int n = word.length();
		long countOfSubstrings = 0;
		
		int left = 0, right = 0;
		int consonantCount = 0;
		int result = 0;
		
		Map<Character, Integer> vowelCountMap = new HashMap<>();
		
		
		while (right < n) {
			char ch = word.charAt(right);
			if (isVowel(ch)) {
				vowelCountMap.put(ch, vowelCountMap.getOrDefault(ch, 0) + 1);
			} else {
				consonantCount++;
			}
			
			while (vowelCountMap.size() == 5 && consonantCount >= k) {
				char leftChar = word.charAt(left);
				if (isVowel(leftChar)) {
					vowelCountMap.put(leftChar, vowelCountMap.get(leftChar) - 1);
					if (vowelCountMap.get(leftChar) == 0) {
						vowelCountMap.remove(leftChar);
					}
				} else {
					consonantCount--;
				}
				countOfSubstrings += n - right;
				left++;
			}
			right++;
		}
		return countOfSubstrings;
	}
	
	public static long countOfSubstrings(String word, int k) {
		//ans=countOfSubstrings(word,k)-countOfSubstrings(word,k+1)
		return atLeastK(word, k) - atLeastK(word, k + 1);
		
	}
	
	public static long countOfSubstrings_bruteForce(String word, int k) {
		int n = word.length();
		int countOfSubstrings = 0;
		for (int i = 0; i < n; i++) {
			Set<Character> current_set = new HashSet<>();
			int current_consonant_count = 0;
			for (int j = i; j < n; j++) {
				if (isVowel(word.charAt(j))) {
					current_set.add(word.charAt(j));
				} else {
					current_consonant_count++;
				}
				if (current_consonant_count == k && current_set.size() == 5) {
					countOfSubstrings++;
				}
			}
			
			current_set.clear();
		}
		return countOfSubstrings;
	}
	
	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
