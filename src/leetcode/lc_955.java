package leetcode;

public class lc_955 {
	
	public static void main(String[] args) {
		// Input: strs = ["ca","bb","ac"]
		String[] str = new String[] { "ca", "bb", "ac" };
		
		lc_955 lc = new lc_955();
		System.out.println(lc.minDeletionSize(str));

	}
	
	public int minDeletionSize(String[] strs) {
		int minDeletionSize = 0;
		int n = strs.length; //num of rows
		int m = strs[0].length(); //nums of columns


		boolean[] alreadySortedRow = new boolean[n - 1];

		for (int col = 0; col < m; col++) {
			boolean needDelete = false;
			for (int row = 0; row < n-1; row++) {
				char currentRowChar = strs[row].charAt(col);
				char nextRowChar = strs[row+1].charAt(col);
				
				if(!alreadySortedRow[row] && currentRowChar > nextRowChar) {
				    needDelete = true;
				    break;
				}
				
				alreadySortedRow[row] = true;
			}
			
			if (needDelete) {
				minDeletionSize++;
			}else{
				// All rows are already sorted for this column, no need to delete
				for (int row = 0; row < n - 1; row++) {
					if(!alreadySortedRow[row] && strs[row].charAt(col) <= strs[row+1].charAt(col)) {
						alreadySortedRow[row] = true;
					}
				}
			}
			
		}

		return minDeletionSize;
	}
}
