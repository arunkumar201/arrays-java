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
        int rows = grid.length;
        int cols = grid[0].length;

        // Flatten grid into a 1D array
        int[] flat = new int[rows * cols];
        int index = 0;

        for (int[] row : grid) {
            for (int value : row) {
                flat[index++] = value;
            }
        }

        // Sort to find median
        Arrays.sort(flat);
        int median = flat[flat.length / 2];

        int minOps = 0;

        for (int value : flat) {
            int diff = Math.abs(value - median);

            // If not divisible by x , not possible to make equal 
            if (diff % x != 0) {
                return -1;
            }

            // Count operations needed
            minOps += diff / x;
        }

        return minOps;
    }

	//we can use the quick sort to sort the half of the array and then find the median
	//as we are interested in the median, we can sort the half of the array and then find the median
	public int minOperations_quickSort(int[][] grid, int x) {
		int rows = grid.length;
		int cols = grid[0].length;

		int[] flat = new int[rows * cols];
		int index = 0;

		for (int[] row : grid) {
			for (int value : row) {
				flat[index++] = value;
			}
		}

		// MyQuickSort(flat, 0, flat.length - 1);
		int median = flat[flat.length / 2];

		int minOps = 0;

		for (int value : flat) {
			int diff = Math.abs(value - median);

			if (diff % x != 0) {
				return -1;
			}

			minOps += diff / x;
		}
		return minOps;
	}
}
