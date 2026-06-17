package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_3337 {

	public static void main(String[] args) {
		// Input: s = "abcyy", t = 2, nums =
		// [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
		String s = "abcyy";
		int t = 2;
		List<Integer> nums = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
		lc_3337 solution = new lc_3337();
		System.out.println(solution.lengthAfterTransformations_bruteForce(s, t, nums));

	}

	public int lengthAfterTransformations_bruteForce(String s, int t, List<Integer> nums) {
		int MOD = 1_000_000_007;

		int[] cnt = new int[26];
		int n = s.length();

		for (int i = 0; i < n; i++) {
			cnt[s.charAt(i) - 'a']++;
		}

		for (int round = 0; round < t; round++) {
			int[] nxt = new int[26];

			for (int i = 0; i < 26; i++) {
				int trans_needs = nums.get(i);
				System.out.println("trans_needs: " + trans_needs);
				// if trans_needs=5 , i=0 or 'a' then a-> bcdef
				// if trans_needs=5 , i=1 or 'b' then b-> cdefg
				// transformation for i based on trans_needs
				// For letter i, transform into next trans letters cyclically
				for (int j = 1; j <= trans_needs; j++) {
					int nextIndex = (i + j) % 26;
					nxt[nextIndex] = (nxt[nextIndex] + cnt[i]) % MOD;
				}
			}
			cnt = nxt;
		}

		int ans = 0;
		for (int i = 0; i < 26; i++) {
			ans = (ans + cnt[i]) % MOD;
		}
		return ans;

	}
}
