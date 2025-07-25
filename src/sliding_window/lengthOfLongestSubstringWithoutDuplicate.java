package sliding_window;

import java.util.HashSet;

public class lengthOfLongestSubstringWithoutDuplicate {
	
	public static void main(String[] args) {
		String s = "a b!c@d#e$f%g^";
		lengthOfLongestSubstringWithoutDuplicate lols = new lengthOfLongestSubstringWithoutDuplicate();
		System.out.println("Brute Force : " + lols.lengthOfLongestSubstringBruteForce(s));
		System.out.println("better Solution : " + lols.lengthOfLongestSubstring(s));
		System.out.println("Optimized : " + lols.lengthOfLongestSubstring_optimized(s));
	}
	
	//Brute Force
	public int lengthOfLongestSubstringBruteForce(String s) {
		int n = s.length();
		int maxLen = 0;
		HashSet<Character> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.clear();
			for (int j = i; j < n; j++) {
				if (!set.contains(s.charAt(j))) {
					set.add(s.charAt(j));
					maxLen = Math.max(maxLen, j - i + 1);
				} else {
					break;
				}
			}
			
		}
		return maxLen;
	}
	
	// better solution
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLen = 0;
		int left = 0, right = 0;
		
		HashSet<Character> set = new HashSet<>();
		
		while (right < n) {
			char currentChar = s.charAt(right);
			while (set.contains(currentChar) && left < right) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(currentChar);
			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}
		return maxLen;
	}
	
	//optimized solution
	public int lengthOfLongestSubstring_optimized(String s) {
		int n = s.length();
		int maxLen = 0;
		int left = 0, right = 0;
		//total number possible unique characters would be
		int[] arr = new int[128];
		
		
		while (right < n) {
			int currentChar = s.charAt(right);
			while (arr[currentChar] == 1 && left < right) {
				arr[s.charAt(left)] = 0;
				left++;
			}
			arr[currentChar] = 1;
			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}
		return maxLen;
	}
}
