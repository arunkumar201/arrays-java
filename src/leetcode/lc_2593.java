package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;


public class lc_2593 {
	
	public static void main(String[] args) {
		
		//Input: nums = [2,1,3,4,5,2]
		//Output:7
		//2,5,6,6,10 - 18
		int[] nums = {2, 5, 6, 6, 10};
		System.out.println(new lc_2593().findScore_bruteForce(nums));
		System.out.println("better solution");
		System.out.println(new lc_2593().findScore_better_solution(nums));
		System.out.println("optimized solution");
		System.out.println(new lc_2593().findScore_optimized(nums));
	}
	
	public long findScore_optimized(int[] nums) {
		int n = nums.length;
		long score = 0;
		int[][] arr = new int[n][2];
		boolean[] marked = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = nums[i];
			arr[i][1] = i;
		}
		Arrays.sort(arr, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
		
		for (int i = 0; i < n; i++) {
			int index = arr[i][1];
			int value = arr[i][0];
			if (!marked[index]) {
				score += value;
				marked[index] = true;
				if (index > 0) marked[index - 1] = true;
				if (index < n - 1) marked[index + 1] = true;
			}
		}
		return score;
		
	}
	
	public long findScore_better_solution(int[] nums) {
		int n = nums.length;
		long score = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(
				(a, b) -> a.value != b.value ? Integer.compare(a.value, b.value) : Integer.compare(a.index, b.index)
		);
		boolean[] marked = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			pq.add(new Pair(nums[i], i));
		}
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int index = p.index;
			int value = p.value;
			if (!marked[index]) {
				score += value;
				marked[index] = true;
				if (index > 0)
					marked[index - 1] = true;
				if (index < n - 1)
					marked[index + 1] = true;
				
			}
			
		}
		return score;
	}
	
	public long findScore_bruteForce(int[] nums) {
		int n = nums.length;
		long score = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(
				(a, b) -> a.value != b.value ? Integer.compare(a.value, b.value) : Integer.compare(a.index, b.index)
		);
		HashSet<Integer> markedSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			pq.add(new Pair(nums[i], i));
		}
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int index = p.index;
			int value = p.value;
			if (!markedSet.contains(index)) {
				score += value;
				markedSet.add(index);
				if (index == 0) markedSet.add(index + 1);
				else if (index == n - 1) markedSet.add(index - 1);
				else {
					markedSet.add(index - 1);
					markedSet.add(index + 1);
				}
				pq.remove(p);
			}
		}
		return score;
	}
	
	static class Pair {
		int value;
		int index;
		
		Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
