package leetcode;

import java.util.HashMap;

public class lc_340 {
	
	public static void main(String[] args) {
		//Input: s = "aabacbebebe", k = 3
		String s = "aabacbebebe";
		int k = 3;
		int res = new lc_340().longestSubstring(s, k);
		System.out.println(res);
	}
	
	public int longestSubstring(String s, int k) {
		int n = s.length();
		char[] arr = s.toCharArray();
		
		HashMap<Character, Integer> freqMap = new HashMap<>();
		
		int left = 0, right = 0;
		int maxLen = -1;
		
		while (right < n) {
			
			freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
			
			while (freqMap.size() > k && left < n) {
				freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
				if (freqMap.get(arr[left]) == 0) {
					freqMap.remove(arr[left]);
				}
				left++;
				
			}
			if (freqMap.size() == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}
			right++;
		}
		return maxLen;
	}
}
