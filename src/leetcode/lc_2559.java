package leetcode;

import java.util.Arrays;

public class lc_2559 {
	
	
	public static void main(String[] args) {
		//Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
		String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
		int[][] queries = new int[][]{{0, 2}, {1, 4}, {1, 1}};
		int[] res = new lc_2559().vowelStrings_1(words, queries);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}
	
	public int[] vowelStrings(String[] words, int[][] queries) {
		boolean[] isVowel = new boolean[128];
		isVowel['a'] = true;
		isVowel['e'] = true;
		isVowel['i'] = true;
		isVowel['o'] = true;
		isVowel['u'] = true;
		int n = words.length;
		
		int[] prefixSum = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			String s = words[i];
			char start = s.charAt(0);
			char end = s.charAt(s.length() - 1);
			
			if (isVowel[start] && isVowel[end]) {
				prefixSum[i] = i != 0 ? prefixSum[i - 1] + 1 : 1;
			} else {
				prefixSum[i] = i != 0 ? prefixSum[i - 1] : 0;
				
			}
		}
		int len = queries.length;
		int[] ans = new int[len];
		
		for (int i = 0; i < len; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			ans[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
		}
		return ans;
	}
	
	public int[] vowelStrings_1(String[] words, int[][] queries) {
		int n = words.length;
		int[] prefixSum = new int[n];
		
		for (int i = 0; i < n; i++) {
			int isVowel = isStringVowel(words[i]) ? 1 : 0;
			prefixSum[i] = i != 0 ? prefixSum[i - 1] + isVowel : isVowel;
		}
		System.out.println(Arrays.toString(prefixSum) + "  --- ");
		int len = queries.length;
		int[] ans = new int[len];
		
		for (int i = 0; i < len; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			ans[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
			
		}
		return ans;
		
	}
	
	public boolean isStringVowel(String s) {
		return s.length() >= 2 ? isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1)) : isVowel(s.charAt(0));
	}
	
	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
