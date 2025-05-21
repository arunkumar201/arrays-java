package leetcode;

import java.util.Arrays;

public class lc_73 {
	
	public static void main(String[] args) {
		//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
		//Output: [[1,0,1],[0,0,0],[1,0,1]]
		lc_73 solution = new lc_73();
		int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		System.out.println("------- Brute force solution - O(M*N) ------");
		solution.setZeroes_bruteForce(matrix);
		System.out.println("Result: " + Arrays.deepToString(matrix));
		System.out.println("------- better solution - O(1) space------");
		solution.setZeroes(matrix);
		System.out.println("Result: " + Arrays.deepToString(matrix));
	}
	
	//time complexity O(M*N)
	//space complexity O(M+N)
	public void setZeroes_bruteForce(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					// Mark all cells in the same row as zero
					for (int k = 0; k < m; k++) {
						visited[k][j] = true;
					}
					// Mark all cells in the same column as zero
					for (int k = 0; k < n; k++) {
						visited[i][k] = true;
					}
				}
			}
		}
		//construct the result
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = visited[i][j] ? 0 : matrix[i][j];
			}
		}
		
	}
	
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean firstCol = false;
		boolean firstRow = false;
		
		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 0) {
				firstCol = true;
				break;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// Step 3: Zero out first row and column if needed
		if (firstCol) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		
		if (firstRow) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		
		
	}
}
