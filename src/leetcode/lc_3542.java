package leetcode;

import java.util.*;

public class lc_3542 {

	public static void main(String[] args) {
		// Input: nums = [3,1,2,1]
		int[] nums = { 1, 2, 1, 2, 1, 2 };
		lc_3542 lc = new lc_3542();
		int result = lc.minOperations_bruteForce(nums);
		System.out.println("Result: " + result);
		System.out.println("Optimized Result: " + lc.minOperations_optimal(nums));
	}

	public int minOperations_bruteForce(int[] nums) {
		int count = 0;

		List<Integer> sortedUniqueNums = new ArrayList<>();

		// create copy of array
		int[] copy = nums.clone();

		// sort the array
		Arrays.sort(copy);

		// add unique elements to the list
		sortedUniqueNums.add(copy[0]);
		for (int i = 1; i < copy.length; i++) {
			if (copy[i] != copy[i - 1]) {
				sortedUniqueNums.add(copy[i]);
			}
		}

		System.out.println("Sorted Unique Array: " + Arrays.toString(sortedUniqueNums.toArray()));
		System.out.println(" Array: " + Arrays.toString(nums));
		// count the operations to make the each item to zero using sliding window
		int j = 0;
		int n = nums.length;
		while (j < sortedUniqueNums.size()) {
			int i = 0;
			int curItem = sortedUniqueNums.get(j);

			while (i < n) {
				while (i < n && nums[i] == 0) {
					i++;
				}
				if (i >= n) {
					break;
				}
				boolean hasFound = false;
				while (i < n && nums[i] != 0 && nums[i] >= curItem) {
					if (nums[i] == curItem) {
						hasFound = true;
						nums[i] = 0;
					}
					i++;
				}
				if (hasFound) {
					count++;
				}
			}
			j++;
		}

		return count;
	}

	public int minOperations_optimal(int[] nums) {
		int count = 0;

		// create priority queue
		Deque<Integer> stack = new ArrayDeque<>();

		for (int x : nums) {

			if (x == 0) {
				stack.clear(); // create for new segment
				continue;
			}

			// maintain non-decreasing stack
			while (!stack.isEmpty() && stack.peekLast() > x) {
				stack.pollLast();
			}

			// if the level is new , then we need to perform one operation
			if (stack.isEmpty() || stack.peekLast() < x) {
				count++;
				stack.addLast(x);
			}
		}
		
		return count;
	}
}
