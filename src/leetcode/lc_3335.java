package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_3335 {
	
	public static void main(String[] args) {
		//Input: s = "abcyy", t = 2
		//Output: 7
		String s = "jqktcurgdvlibczdsvnsg";
		int t = 7517;
		lc_3335 solution = new lc_3335();
		System.out.println(solution.lengthAfterTransformations(s, t));
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
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }
}
