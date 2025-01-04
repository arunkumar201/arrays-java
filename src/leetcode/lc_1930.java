package leetcode;

import java.util.HashSet;
import java.util.Set;

class Pair {
	int firstOcc;
	int secondOcc;
	
	Pair(int firstOcc, int secondOcc) {
		this.firstOcc = firstOcc;
		this.secondOcc = secondOcc;
	}
}


public class lc_1930 {
	
	
	public static void main(String[] args) {
		String s = "bbcbaba";
		int res = new lc_1930().countPalindromicSubsequence(s);
		System.out.println(res);
		
	}
	
	public int countPalindromicSubsequence(String s) {
		int n = s.length();
		Pair[] arr = new Pair[26];
		
		for (int i = 0; i < 26; i++) {
			arr[i] = new Pair(-1, -1);
			
		}
		int ans = 0;
		
		//now put the first occurrence index and last one
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i) - 'a';
			if (arr[index].firstOcc == -1) {
				arr[index].firstOcc = i;
				
			} else {
				arr[index].secondOcc = i;
			}
		}
		
		//now check the palindromic subsequence
		for (Pair pair : arr) {
			int first_index = pair.firstOcc;
			int last_index = pair.secondOcc;
			
			if (first_index != -1 && last_index != -1) {
				Set<Character> set = new HashSet<>();
				for (int j = first_index+1; j < last_index; j++) {
					set.add(s.charAt(j));
				}
				ans += set.size();
			}
		}
		return ans;
	}
}
