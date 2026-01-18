public class lc_1895 {

	public static void main(String[] args) {
		int[][] grid = {
				{ 7, 1, 4, 5, 6 },
				{ 2, 5, 1, 6, 4 },
				{ 1, 5, 4, 3, 2 },
				{ 1, 2, 7, 3, 4 }
		};

		lc_1895 sol = new lc_1895();
		System.out.println(sol.largestMagicSquare(grid));
	}

	public int largestMagicSquare(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		int maxSize = Math.min(rows, cols);

		for (int size = maxSize; size >= 2; size--) {
			for (int i = 0; i <= rows - size; i++) {
				for (int j = 0; j <= cols - size; j++) {
					if (isMagicSquare(grid, i, j, size)) {
						return size;
					}
				}
			}
		}

		return 1;
	}

	private boolean isMagicSquare(int[][] grid, int row, int col, int size) {
		int targetSum = 0;

		// row- start row of the sub-square matrix
		// col - start col of sub-square matrix
		// size - would size of square matrix
		// first row sum
		// (row,col)
		// r- 1,2,3,4
		// 2,4,6,7
		// 4,5,6,7
		// here - 1,2,3,4 - sum would 10 , we consider as target sum
		//
		for (int j = col; j < col + size; j++) {
			targetSum += grid[row][j];
		}

		// check rows
		// Loops through each row inside the square
		// Calculates row sum
		// If any row ≠ targetSum, it’s NOT magic → exit immediately 
		for (int i = row; i < row + size; i++) {
			int sum = 0;
			for (int j = col; j < col + size; j++) {
				sum += grid[i][j];
			}
			if (sum != targetSum)
				return false;
		}

		// check columns
		for (int j = col; j < col + size; j++) {
			int sum = 0;
			for (int i = row; i < row + size; i++) {
				sum += grid[i][j];
			}
			if (sum != targetSum)
				return false;
		}

		// main diagonal
		int diag1 = 0, diag2 = 0;
		for (int i = 0; i < size; i++) {
			diag1 += grid[row + i][col + i];
			diag2 += grid[row + i][col + size - 1 - i];
		}

		return diag1 == targetSum && diag2 == targetSum;
	}
}
