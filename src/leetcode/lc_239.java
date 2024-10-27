package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class lc_239 {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		LinkedList<Integer> result = new LinkedList<>();
		int n = nums.length;
		for (int i = 0; i < n - k + 1; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> (b - a));
			for (int j = i; j < i + k && j < n; j++) {
				pq.add(nums[j]);
			}
			result.add(pq.peek());
			pq.clear();
		}
		int[] resultArray = new int[result.size()];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = result.remove();
		}
		return resultArray;
		
	}
	
	public int[] maxSlidingWindowOptimized(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			// Remove indices that are out of the bounds of the current window
			if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}
			
			// Remove elements from deque that are smaller than the current element
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			
			// Add the current index to the deque
			deque.offerLast(i);
			
			// Add the maximum for the current window to the result
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		int[] res = new lc_239().maxSlidingWindowOptimized(nums, k);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}
