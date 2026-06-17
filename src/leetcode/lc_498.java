package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc_498 {
	
	public static void main(String[] args) {
		//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
		int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int m = mat.length;
		int n = mat[0].length;
		
		int[] result = new int[m * n];
		lc_498 sol = new lc_498();
		result = sol.findDiagonalOrder_BruteForce(mat);
		
		System.out.println("Result " + Arrays.toString(result));
	}
	
	public int[] findDiagonalOrder_BruteForce(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		
		List<Integer> result = new ArrayList<>();
		
		for (int sum = 0; sum <= n + m - 2; sum++) {
			List<Integer> diagonal = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int j = sum - i;
				if (j >= 0 && j < m) {
					diagonal.add(mat[i][j]);
				}
			}
			if (sum % 2 == 0) {
				Collections.reverse(diagonal);
			}
			result.addAll(diagonal);
		}
		
		int[] ans = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			ans[i] = result.get(i);
		}
		return ans;
	}
}
