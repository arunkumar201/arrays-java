package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc_3335 {
	
	public static void main(String[] args) {
		//Input: s = "abcyy", t = 2
		//Output: 7
		String s = "jqktcurgdvlibczdsvnsg";
		int t = 7517;
		lc_3335 solution = new lc_3335();
		System.out.println(solution.lengthAfterTransformations(s, t));
		System.out.println("--Map solution--");
		System.out.println(solution.lengthAfterTransformations_mp(s, t));
	}
	
	public int lengthAfterTransformations_bruteForce(String s, int t) {
		final int MOD = 1_000_000_007;
		
		List<Character> list = new ArrayList<>();
		for (char c : s.toCharArray()) {
			list.add(c);
		}
		
		for (int i = 0; i < t; i++) {
			List<Character> nextList = new ArrayList<>();
			for (char c : list) {
				if (c == 'z') {
					nextList.add('a');
					nextList.add('b');
				} else {
					nextList.add((char) (c + 1));
				}
			}
			list = nextList;
		}
		
		return list.size() % MOD;
	}
	
	
	public int lengthAfterTransformations(String s, int t) {
		int MOD = 1_000_000_007;
		
		int[] cnt = new int[26];
		
		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}
		
		for (int round = 0; round < t; round++) {
			int[] nxt = new int[26];
			
			for (int i = 0; i < 26; i++) {
				//if Z comes, we will replace it with A and B
				if (i == 25) {
					nxt[0] = (nxt[0] + cnt[25]) % MOD;
					nxt[1] = (nxt[1] + cnt[25]) % MOD;
				} else {
					// 'a' to 'y' → next character
					nxt[i + 1] = (nxt[i + 1] + cnt[i]) % MOD;
				}
			}
			cnt = nxt;
		}
		int ans = 0;
		for (int i = 0; i < 26; ++i) {
			ans = (ans + cnt[i]) % MOD;
		}
		return ans;
	}
	
	
	public int lengthAfterTransformations_mp(String s, int t) {
		int MOD = 1_000_000_007;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for (int round = 0; round < t; round++) {
			HashMap<Character, Integer> nxt = new HashMap<>();
			for (char ch : map.keySet()) {
				int curr_char_count = map.getOrDefault(ch, 0);
				if (ch == 'z') {
					//if Z comes, we will replace it with A and B
					int count_a = nxt.getOrDefault('a', 0);
					int count_b = nxt.getOrDefault('b', 0);
					
					nxt.put('a', (count_a + curr_char_count) % MOD);
					nxt.put('b', (count_b + curr_char_count) % MOD);
				} else {
					//will update every character with next character
					//e.g. if 'a' comes, we will update it with 'b'
					char nextChar = (char) (ch + 1);
					int next_char_count = (nxt.getOrDefault(nextChar, 0) + curr_char_count) % MOD;
					nxt.put(nextChar, next_char_count);
				}
			}
			map = nxt;
		}
		int ans = 0;
		for (int count : map.values()) {
			ans = (ans + count) % MOD;
		}
		return ans;
	}
}
