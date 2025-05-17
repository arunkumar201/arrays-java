package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_3337 {
	
	
	public static void main(String[] args) {
		//Input: s = "abcyy", t = 2,
		// nums = [1, 2, 3]
		//Output: 7
		String s = "abcyy";
		int t = 2;
		List<Integer> nums = List.of(1, 2, 3);
		lc_3337 solution = new lc_3337();
		System.out.println(solution.lengthAfterTransformations(s, t, nums));
		
		
	}
	
	public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
		int MOD = 1_000_000_007;
		
		int[] cnt = new int[26];
		int n = s.length();
		
		Map<Integer, Character> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			cnt[s.charAt(i) - 'a']++;
			map.put(i, s.charAt(i));
		}
		System.out.println("map of index->char: " + map);
		
		for (int round = 0; round < t; round++) {
			int[] nxt = new int[26];
			
			
			
		}
		int ans = 0;
		
		return ans;
		
	}
}
