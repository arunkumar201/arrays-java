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

	public int largestMagicSquare_bruteForce(int[][] grid) {
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

	// we will use the prefix sum approach
	// will store prefix rows sum and also prefix cols sum in arr
	public int largestMagicSquare(int[][] grid) {

		int maxMagicSquareSize = 1;

		int rows = grid.length;
		int cols = grid[0].length;

		/*
		 * prefixRowSum[i][j]
		 * = sum of elements in row i from column 0 to j-1
		 * Extra column (+1) helps to calculate range sum easily
		 */
		int[][] prefixRowSum = new int[rows][cols + 1];

		/*
		 * prefixColSum[i][j]
		 * = sum of elements in column j from row 0 to i-1
		 * Extra row (+1) avoids boundary checks
		 */
		int[][] prefixColSum = new int[rows + 1][cols];

		// generate row wise prefix sum
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// previous sum + current cell value
				prefixRowSum[i][j + 1] = prefixRowSum[i][j] + grid[i][j];
			}
		}

		// generate column-wise prefix sum
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				// previous sum + current cell value
				prefixColSum[i + 1][j] = prefixColSum[i][j] + grid[i][j];
			}
		}

		// Max possible square size
		int maxSize = Math.min(rows, cols);

		/*
		 * first we try squares from largest size to smallest
		 */
		for (int size = maxSize; size >= 2; size--) {

			for (int r = 0; r <= rows - size; r++) {

				for (int c = 0; c <= cols - size; c++) {

					/*
					 * First row sum is taken as target sum
					 */
					int targetSum = prefixRowSum[r][c + size] - prefixRowSum[r][c];

					boolean isMagic = true;

					for (int i = r; i < r + size; i++) {
						int rowSum = prefixRowSum[i][c + size] - prefixRowSum[i][c];

						if (rowSum != targetSum) {
							isMagic = false;
							break;
						}
					}

					if (!isMagic)
						continue;

					// Check all column sums
					for (int j = c; j < c + size; j++) {
						int colSum = prefixColSum[r + size][j] - prefixColSum[r][j];

						if (colSum != targetSum) {
							isMagic = false;
							break;
						}
					}

					if (!isMagic)
						continue;

					// Check both diagonals
					int diag1 = 0, diag2 = 0;

					for (int i = 0; i < size; i++) {
						// main diagonal (top-left → bottom-right)
						diag1 += grid[r + i][c + i];

						// anti diagonal (top-right → bottom-left)
						diag2 += grid[r + i][c + size - 1 - i];
					}

					if (diag1 == targetSum && diag2 == targetSum) {
						return size;
					}
				}
			}
		}

		// If no size > 1 magic square found
		return maxMagicSquareSize;
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
