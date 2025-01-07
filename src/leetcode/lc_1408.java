package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_1408 {
	
	
	public static void main(String[] args) {
		String[] words = {"mass", "as", "hero", "superhero"};
		List<String> res = new lc_1408().stringMatching(words);
		System.out.println(res);
		
	}
	
	public List<String> stringMatching(String[] words) {
		int n = words.length;
		List<String> result = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (words[j].contains(words[i])) {
					result.add(words[i]);
					break;
				}
				
			}
		}
		return result;
	}
}
