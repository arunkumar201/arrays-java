package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class lc_862 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k = 3;
		int res = new lc_862().shortestSubarray_1(nums, k);
		System.out.println(res);
	}
	
	//Time Complexity - O(n^3)
	//Space Complexity - O(1)
	public int shortestSubarray_bruteForce(int[] nums, int k) {
		int n = nums.length;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int l = i; l <= j; l++) {
					sum += nums[l];
				}
				if (sum >= k) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				}
			}
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
		
	}
	
	public int shortestSubarray_1(int[] nums, int k) {
		int n = nums.length;
		int[] prefixSum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
//		System.out.println(Arrays.toString(prefixSum));
		
		int minLength = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				int sum = prefixSum[j] - prefixSum[i - 1];
				if (sum >= k) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				}
			}
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
	
	//optimized solution
	public int shortestSubarray_optimized(int[] nums, int k) {
		int n = nums.length;
		long[] prefixSum = new long[n + 1];
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}
		
		int minLength = Integer.MAX_VALUE;
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i <= n; i++) {
			while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
				minLength = Math.min(minLength, i - deque.pollFirst());
			}
			while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
}
