package leetcode;

public class lc_1684 {
	public int countConsistentStrings(String allowed, String[] words) {
		int consistentStringsCount = 0;
		int[] allowedChars = new int[26];
		
		// Count the allowed characters
		for (char c : allowed.toCharArray()) {
			allowedChars[c - 'a'] = 1;
		}
		
		// Count the consistent strings
		for (String word : words) {
			boolean isConsistent = true;
			for (char c : word.toCharArray()) {
				if (allowedChars[c - 'a'] == 0) {
					isConsistent = false;
					break;
				}
			}
			if (isConsistent) {
				consistentStringsCount++;
			}
		}
		
		return consistentStringsCount;
		
	}
	
	public static void main(String[] args) {
		//Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
		String allowed = "ab";
		String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
		int res = new lc_1684().countConsistentStrings(allowed, words);
		System.out.println(res);
	}
}
