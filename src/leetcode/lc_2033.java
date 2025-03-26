package leetcode;

import java.util.Arrays;

public class lc_2033 {
	
	public static void main(String[] args) {
		//Input: grid = [[2,4],[6,8]], x = 2
		int[][] grid = {{2, 4}, {6, 8}};
		int x = 2;
		System.out.println(new lc_2033().minOperations(grid, x));
		
	}
	
	public int minOperations(int[][] grid, int x) {
		int operations = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		int[] list = new int[rows * cols];
		
		//make it flatted list
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				list[index++] = grid[i][j];
			}
		}
//		sort the list
		Arrays.sort(list);
		
		// get  median element
		int n = list.length;
		int median = list[n / 2];
		System.out.println("median: " + median);
		for (int i = 0; i < n; i++) {
			int current = list[i];
			
			if (current == median) {
				continue;
			}
			if (Math.abs(current - median) % x != 0) {
				return -1;
			}
			
			operations += Math.abs(current - median) / x;
		}
		
		return operations;
	}
}
