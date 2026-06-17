package leetcode;

import java.util.HashMap;

public class lc_1358 {
	public static void main(String[] args) {
		
		String s = "abcabc";
		lc_1358 lc = new lc_1358();
		int res = lc.numberOfSubstrings(s);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.numberOfSubstrings_optimized(s);
		System.out.println(res);
		
	}
	
	public int numberOfSubstrings_optimized(String s) {
		int n = s.length();
		int count = 0;
		
		int[] map = new int[4];
		
		
		int left = 0;
		for (int right = 0; right < n; right++) {
			char currentChar = s.charAt(right);
			map[currentChar - 'a']++;
			
			while (map[0] > 0 && map[1] > 0 && map[2] > 0) {
				count += n - right;
				char leftChar = s.charAt(left);
				map[leftChar - 'a']--;
				left++;
			}
		}
		return count;
	}
	
	public int numberOfSubstrings(String s) {
		int n = s.length();
		int count = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		int left = 0;
		for (int right = 0; right < n; right++) {
			char currentChar = s.charAt(right);
			map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
			
			while (map.size() == 3) {
				count += n - right;
				
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				left++;
			}
		}
		return count;
	}
}
