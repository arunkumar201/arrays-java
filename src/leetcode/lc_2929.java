package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_2929 {
	
	private static final Map<String, Long> memo = new HashMap<>();
	
	public static void main(String[] args) {
		int n = 5;
		int limit = 2;
		lc_2929 solution = new lc_2929();
		System.out.println("----brute force-----");
		//start time
		long start = System.currentTimeMillis();
		System.out.println("Result: " + solution.distributeCandies_bruteforce(n, limit));
		long end = System.currentTimeMillis();
		//end time
		System.out.println("Time taken: " + (end - start) + " milliseconds");
		
		System.out.println("----using three loops solution-----");
		start = System.currentTimeMillis();
		System.out.println("Result: " + solution.distributeCandies_loops(n, limit));
		System.out.println("Result using 2 loops: " + solution.distributeCandies_loops2(n, limit));
		end = System.currentTimeMillis();
		//end time
		System.out.println("Time taken: " + (end - start) + " milliseconds");
		
		System.out.println("----linear solution-----");
		start = System.currentTimeMillis();
		System.out.println("Result: " + solution.distributeCandies_linear(n, limit));
		end = System.currentTimeMillis();
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
	
	//using three loops
	public long distributeCandies_loops(int n, int limit) {
		int safe_limit = Math.min(n, limit);
		long ways = 0;
		for (int child1 = 0; child1 <= safe_limit; child1++) {
			
			for (int child2 = 0; child2 <= Math.min(n - child1, safe_limit); child2++) {
				
				for (int child3 = 0; child3 <= Math.min(n - child1 - child2, safe_limit); child3++) {
					
					if (child1 + child2 + child3 == n) {
						ways++;
					}
					
					
				}
			}
		}
		return ways;
	}
	
	//using 2 loops
	public long distributeCandies_loops2(int n, int limit) {
		int safe_limit = Math.min(n, limit);
		long ways = 0;
		for (int child1 = 0; child1 <= safe_limit; child1++) {
			for (int child2 = 0; child2 <= Math.min(n - child1, safe_limit); child2++) {
				
				int child3 = Math.min(n - child1 - child2, safe_limit);
				
				if (child1 + child2 + child3 == n) {
					ways++;
				}
			}
		}
		return ways;
	}
	
	//linear solution
	public long distributeCandies_linear(int n, int limit) {
		long ways = 0;
		
		//Minimum number of candies that can be distributed is child 1
		int min_candies_child1 = Math.max(0, n - 2 * limit);
		int max_candies_child1 = Math.min(n, limit);
		
		for (int i = min_candies_child1; i <= max_candies_child1; i++) {
			
			int N = n-i;
			int min_candies_child2 = Math.max(0, N - limit);
			int max_candies_child2 = Math.min(N, limit);
			
			ways += max_candies_child2 - min_candies_child2 + 1;
			
		}
		return ways;
	}
}