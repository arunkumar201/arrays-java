package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_884 {
	
	
	public String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> wordCount = new HashMap<>();
		
		String[] words1 = s1.split(" ");
		String[] words2 = s2.split(" ");
		
		for (String word : words1) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		
		for (String word : words2) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		
		// Collect words that appear exactly once
		List<String> result = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			if (entry.getValue() == 1) {
				result.add(entry.getKey());
			}
		}
		
		return result.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
//		Input: s1 = "this apple is sweet", s2 = "this apple is sour"
		String s1 = "this apple is sweet";
		String s2 = "this apple is sour";
		String[] res = new lc_884().uncommonFromSentences(s1, s2);
		for (String s : res) {
			System.out.println(s);
		}
		
		
	}
}
