package leetcode;

import java.util.PriorityQueue;

public class lc_3066 {
	
	
	public static void main(String[] args) {
		int[] nums = {1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999};
		int k = 1000000000;
		System.out.println(new lc_3066().minOperations_optimized(nums, k));
		
	}
	
	public int minOperations(int[] nums, int k) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int j : nums) {
			pq.add((long) j);
		}
		
		int count = 0;
		while (pq.size() >= 2 && pq.peek() < k) {
			
			long x = pq.poll();
			long y = pq.poll();
			System.out.println(x + " " + y);
			//min(x, y) * 2 + max(x, y)
			long value = Math.min(x, y) * 2 + Math.max(x, y);
			pq.add(value);
			
			System.out.println(pq);
			count++;
		}
		
		return count;
	}
	
	public int minOperations_optimized(int[] nums, int k) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int num : nums) {
			if (num < k)
				pq.add((long) num);
		}
		
		int count = 0;
		while (!pq.isEmpty()) {
			long x = pq.poll();
			
			if (pq.isEmpty()) return count + 1;
			long y = pq.poll();
			
			long value = Math.min(x, y) * 2 + Math.max(x, y);
			if (value < k)
				pq.add(value);
			count++;
		}
		
		return count;
	}
	
}
