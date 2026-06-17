import java.util.ArrayList;
import java.util.List;

public class lc_1504 {
	
	public static void main(String[] args) {
		//Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
		
		int[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
		lc_1504 lc = new lc_1504();
		int res = lc.numSubmat_bruteForce(mat);
		System.out.println(res);
		
	}
	
	
	private boolean isSubMatrixHasAllOnes(int[][] mat, int[][] subMat) {
		for (int i = 0; i < subMat.length; i++) {
			for (int j = 0; j < subMat[i].length; j++) {
				if (subMat[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
		
		
	}
	
	public int numSubmat_bruteForce(int[][] mat) {
		int count = 0;
		int rows = mat.length;
		int cols = mat[0].length;
		List<int[][]> subMatrices = new ArrayList<>();
		for (int startRow = 0; startRow < rows; startRow++) {
			for (int startCol = 0; startCol < cols; startCol++) {
				
				// Iterate through all possible bottom-right corners (endRow, endCol)
				for (int endRow = startRow; endRow < rows; endRow++) {
					for (int endCol = startCol; endCol < cols; endCol++) {
						
						int submatrixRows = endRow - startRow + 1;
						int submatrixCols = endCol - startCol + 1;
						int[][] currentSubmatrix = new int[submatrixRows][submatrixCols];
						
						for (int i = 0; i < submatrixRows; i++) {
							for (int j = 0; j < submatrixCols; j++) {
								currentSubmatrix[i][j] = mat[startRow + i][startCol + j];
							}
						}
						subMatrices.add(currentSubmatrix);
					}
				}
			}
		}
		
		for (int[][] subMatrix : subMatrices) {
			if (isSubMatrixHasAllOnes(mat, subMatrix)) {
				count++;
			}
		}
		return count;
		
	}
	
}
