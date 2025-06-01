package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_2929 {
	
	private static final Map<String, Long> memo = new HashMap<>();
	
	public static void main(String[] args) {
		int n = 10001;
		int limit = 20001;
		lc_2929 solution = new lc_2929();
		System.out.println("----brute force-----");
		//start time
		long start = System.currentTimeMillis();
		System.out.println("Result: " + solution.distributeCandies_bruteforce(n, limit));
		long end = System.currentTimeMillis();
		//end time
		System.out.println("Time taken: " + (end - start) + " milliseconds");
		
		
	}
	
	public static long calculate_num_of_ways(int childCount, int n, int limit) {
		if (childCount == 3) {
			if (n == 0) return 1;
			return 0;
		}
		
		String key = childCount + "," + n;
		
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		long ways = 0;
		for (int assigned = 0; assigned <= limit; assigned++) {
			if (assigned > n) continue;
			ways += calculate_num_of_ways(childCount + 1, n - assigned, limit);
		}
		memo.put(key, ways);
		return ways;
	}
	
	//O(childCount * n) ~ O(n)
	//space complexity O(childCount * n)
	public long distributeCandies_bruteforce(int n, int limit) {
		
		int safe_limit = Math.min(n, limit);
		
		return calculate_num_of_ways(0, n, safe_limit);
		
	}
}