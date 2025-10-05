package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc_3362 {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		int[][] queries = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		int res = new lc_3362().maxRemoval(nums, queries);
		System.out.println(res);

	}

	public int maxRemoval(int[] nums, int[][] queries) {
		int n = nums.length;
		int m = queries.length;

		// sort the queries based on the start element
		Arrays.sort(queries, (a, b) -> a[0] - b[0]);

		// availableQueries: max heap (largest end first)
		PriorityQueue<Integer> availableQueries = new PriorityQueue<>((a, b) -> b - a);

		// usedQueries: min heap (smallest end first)
		PriorityQueue<Integer> usedQueries = new PriorityQueue<>((a, b) -> a - b);

		int appliedQueries = 0;
		int queriesIndex = 0;

		for (int i = 0; i < n; i++) {

			// Remove expired queries (those whose end < current i)
			while (!usedQueries.isEmpty() && usedQueries.peek() < i) {
				usedQueries.poll();
			}

			// Add new queries starting at i
			while (queriesIndex < m && queries[queriesIndex][0] == i) {
				availableQueries.add(queries[queriesIndex][1]);
				queriesIndex++;
			}

			// Apply queries if needed
			while (nums[i] > usedQueries.size() && !availableQueries.isEmpty() && availableQueries.peek() >= i) {
				usedQueries.add(availableQueries.poll());
				appliedQueries++;
			}

			// If we still need more coverage, it's impossible
			if (nums[i] > usedQueries.size()) {
				return -1;
			}

		}
		return m - appliedQueries;

	}
}
