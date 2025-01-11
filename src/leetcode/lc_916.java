package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_916 {
	
	public static void main(String[] args) {
		//Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
		String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
		String[] words2 = {"l", "e"};
		
		List<String> res = new lc_916().wordSubsets_Hashmap(words1, words2);
		System.out.println(res);
		
	}
	
	public List<String> wordSubsets_BruteForce(String[] words1, String[] words2) {
		List<String> result = new ArrayList<>();
		
		for (String word : words1) {
			int[] count = new int[26];
			
			for (char c : word.toCharArray()) {
				count[c - 'a']++;
			}
			
			boolean isValid = true;
			
			for (String subset : words2) {
				int[] subsetCount = new int[26];
				for (char c : subset.toCharArray()) {
					subsetCount[c - 'a']++;
				}
				
				for (int i = 0; i < 26; i++) {
					if (count[i] < subsetCount[i]) {
						isValid = false;
						break;
					}
				}
				if (!isValid) break;
			}
			
			if (isValid) {
				result.add(word);
			}
			
		}
		return result;
	}
	
	public List<String> wordSubsets_optimized(String[] words1, String[] words2) {
		List<String> result = new ArrayList<>();
		
		int[] maxCount = new int[26];
		
		// Calculate the maximum count for each character in words2
		for (String word : words2) {
			int[] tempCount = new int[26];
			
            for (char c : word.toCharArray()) {
                tempCount[c - 'a']++;
            }
			for (int i = 0; i < 26; i++) {
				maxCount[i] = Math.max(maxCount[i], tempCount[i]);
			}
		}
		
		// Check each word in words1
		for (String word : words1) {
			int[] wordCount = new int[26];
			
			for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
			
			boolean isValid = true;
			for (int i = 0; i < 26; i++) {
				if (wordCount[i] < maxCount[i]) {
					isValid = false;
					break;
				}
			}
			
			if (isValid) {
				result.add(word);
			}
		}
		return result;
	}
	
	public int[] getCharCount(String word) {
		int[] count = new int[26];
		for (char c : word.toCharArray()) {
			count[c - 'a']++;
		}
		return count;
	}
}

