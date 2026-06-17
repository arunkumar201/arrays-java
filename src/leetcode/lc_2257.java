
package leetcode;

import java.util.Arrays;

public class lc_2257 {

	public static void main(String[] args) {
		// Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls =
		// [[0,1],[2,2],[1,4]]
		// Output: 7
		int m = 4;
		int n = 6;
		int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
		int[][] walls = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
		System.out.println(new lc_2257().countUnguarded(m, n, guards, walls));
	}

	public void markGuarded(int row, int col, int[][] grid) {

		//up direction - col will be same and row will be decreasing
		for (int i = row - 1; i >= 0; i--) {
			//1- wall, 2- guard
			if (grid[i][col] == 1 || grid[i][col] == 2) {
				break;
			}
			//3- guarded
			grid[i][col] = 3;
			//default is 0- empty
		} 
		//down direction - col will be same and row will be increasing
		for (int j = row + 1; j < grid.length; j++) {
			//1- wall, 2- guard
			if (grid[j][col] == 1 || grid[j][col] == 2) {
				break;
			}
			//3- guarded
			grid[j][col] = 3;
			//default is 0- empty
		}
		//left direction - row will be same and col will be decreasing
		for (int k = col - 1; k >= 0; k--) {
			//1- wall, 2- guard
			if (grid[row][k] == 1 || grid[row][k] == 2) {
				break;
			}
			//3- guarded
			grid[row][k] = 3;
			//default is 0- empty
		}

		//right direction - row will be same and col will be increasing
		for (int l = col + 1; l < grid[0].length; l++) {
			//1- wall, 2- guard
			if (grid[row][l] == 1 || grid[row][l] == 2) {
				break;
			}
			//3- guarded
			grid[row][l] = 3;
			//default is 0- empty
		}
	}

	public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
		int unguarded = 0;
		int[][] grid = new int[m][n];
		// 0 = empty, 1 = wall, 2 = guard, 3 = guarded

		// mark guards
		for (int i = 0; i < guards.length; i++) {
			int gRow = guards[i][0];
			int gCol = guards[i][1];
			grid[gRow][gCol] = 2;
		}

		// mark walls
		for (int i = 0; i < walls.length; i++) {
			int wRow = walls[i][0];
			int wCol = walls[i][1];
			grid[wRow][wCol] = 1;
		}


		for (int[] guard : guards) {
			int r = guard[0] ;
			int c = guard[1];
			markGuarded(r,c,grid);
		}

		// count unguarded (still 0)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					unguarded++;
				}
			}
		}

		System.out.println(Arrays.deepToString(grid));
		return unguarded;
	}

}
