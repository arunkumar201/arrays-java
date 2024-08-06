package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_3014_16 {
	public int minimumPushes(String word) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int assignKey = 2;
		int result = 0;
		for (int i = 0; i < word.length(); i++) {
			if (assignKey > 9) {
				assignKey = 2;
			}
			map.put(assignKey, map.getOrDefault(assignKey, 0) + 1);
			result += map.get(assignKey);
			assignKey++;
		}
		return result;
	}
	
	//optimal solution
	public int minimumPushes_optimal(String word) {
		int n = word.length();
		int[] freq = new int[10];
		int result = 0;
		int assignKey = 2;
		for (int i = 0; i < n; i++) {
			if (assignKey > 9) {
				assignKey = 2;
			}
			freq[assignKey] += 1;
			result += freq[assignKey];
			assignKey++;
		}
		return result;
	}
	
	//another way
	//3016
	public int minimumPushes_HashMap(String word) {
		int[] map = new int[26];
		int result = 0;
		
		for (int i = 0; i < word.length(); i++) {
			map[word.charAt(i) - 'a']++;
		}
		
		//sort the word count in ascending order
		Arrays.sort(map);
		
		for (int i = 0; i < 26; i++) {
			int freq = map[26 - i - 1];
			int pressCount = (i / 8 + 1);
			result += pressCount * freq;
		}
		return result;
	}
	
	public static void main(String[] args) {
		//Input: word = "abcde"
		String word = "xyzxyzxyzxyz";
		int res = new lc_3014_16().minimumPushes_HashMap(word);
		System.out.println(res); // Output: 5
	}
	
	
}
