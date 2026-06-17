package leetcode;

public class lc_955 {

	public static void main(String[] args) {
		// Input: strs = ["ca","bb","ac"]
		String[] str = new String[] { "ca", "bb", "ac" };

		lc_955 lc = new lc_955();
		System.out.println(lc.minDeletionSize(str));

	}

	/*
	 * Time Complexity: O(rows * cols)
	 * - We scan every column, and for each column we may scan all rows.
	 *
	 * Space Complexity: O(rows)
	 * - We use a boolean array to track whether adjacent rows
	 * are already confirmed to be sorted.
	 */
	public int minDeletionSize(String[] strs) {
		int minDeletionSize = 0;

		int n = strs.length; // number of rows (strings)
		int m = strs[0].length(); // number of columns (characters per string)

		/*
		 * alreadySortedRow[i] indicates whether
		 * strs[i] < strs[i + 1] has already been established
		 * by a previous column.
		 *
		 * If true, we no longer need to compare this row pair
		 * in future columns.
		 */
		boolean[] alreadySortedRow = new boolean[n - 1];

		// Iterate column by column (left to right)
		for (int col = 0; col < m; col++) {
			boolean needDeletion = false;

			// Compare adjacent rows for the current column
			for (int row = 0; row < n - 1; row++) {
				// Skip comparisons that are already confirmed sorted
				if (alreadySortedRow[row]) {
					continue;
				}

				char currentRowChar = strs[row].charAt(col);
				char nextRowChar = strs[row + 1].charAt(col);

				/*
				 * If current row character is greater than the next row character,
				 * lexicographical order is violated.
				 * This column must be deleted.
				 */
				if (currentRowChar > nextRowChar) {
					needDeletion = true;
					break;
				}
			}

			if (needDeletion) {
				// Delete this column and move to the next one
				minDeletionSize++;
			} else {
				/*
				 * This column does not violate ordering.
				 * Mark row pairs that become strictly sorted due to this column,
				 * so they can be skipped in future columns.
				 */
				for (int row = 0; row < n - 1; row++) {
					if (alreadySortedRow[row]) {
						continue;
					}

					char currentRowChar = strs[row].charAt(col);
					char nextRowChar = strs[row + 1].charAt(col);

					if (currentRowChar < nextRowChar) {
						alreadySortedRow[row] = true;
					}
				}
			}
		}

		return minDeletionSize;
	}
}
