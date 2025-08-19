package leetcode;

import java.util.Arrays;

public class lc_2438 {
	
	public static void main(String[] args) {
		//Input: n = 15, queries = [[0,1],[2,2],[0,3]]
		
		int n = 13;
		int[][] queries = new int[][]{{1, 2}, {1, 1}};
		lc_2438 lc = new lc_2438();
		int[] res = lc.productQueries(n, queries);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] calculatePowers(int n, int[][] queries, int[] powers, int k) {
		int Mod = 1_000_000_007;
		int[] res = new int[n];
		
		for (int i = 0; i < n; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			long ans = 1;
			for (int j = start; j <= end; j++) {
				ans = (ans * powers[j]);
			}
			res[i] = (int) ans % Mod;
		}
		return res;
		
	}
	
	public int[] productQueries(int n, int[][] queries) {
		int len = queries.length;
		int[] powers = new int[32];
		
		int k = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				powers[k++] = 1 << i;
			}
		}
		
		int x = n;
		int rep = 1;
		while (x > 0) {
			System.out.println(rep + "---");
			if (x % 2 == 1) {
				powers[k++] = x;
			}
			x = x / 2;
			rep *= 2;
			
		}
		
		return calculatePowers(len, queries, powers, k);
	}
}
