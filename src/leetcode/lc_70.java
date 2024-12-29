package leetcode;

public class lc_70 {
	
	
	public static void main(String[] args) {
		int n = 3;
		int res = new lc_70().climbStairs(n);
		System.out.println(res);
		
		
	}
	
	/**
	 * Calculates the number of distinct ways to climb to the top of a staircase.
	 * <p>
	 * This method uses dynamic programming to solve the problem efficiently.
	 * It's based on the observation that to reach the nth step, you can either:
	 * 1. Take one step from the (n-1)th step, or
	 * 2. Take two steps from the (n-2)th step
	 * <p>
	 * Therefore, the total number of ways to reach the nth step is the sum of the
	 * ways to reach the (n-1)th step and the (n-2)th step.
	 *
	 * @param n The total number of steps in the staircase. Must be a positive integer.
	 * @return The number of distinct ways to climb to the top of the staircase.
	 * <p>
	 * //base case :
	 * if(n<2) {
	 * return n;
	 * }
	 */
	//time Complexity= O(2^n)
	//Space Complexity= O(n)
	public int climbStairs(int n) {
		//base case
		if (n <= 2) {
			return n;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
	public  int climbStairs_optimized(int n) {
		//base case
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
		
        dp[1] = 1;
        dp[2] = 2;
		
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
		
        return dp[n];
	}
	//it is similar to fib problem
	//time Complexity= O(n)
	//Space Complexity= O(1)
	public int climbStairs_optimized_space_efficient(int n) {
		//base case
        if (n <= 2) {
            return n;
        }
        int prev = 1;
        int current = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = current;
            current = prev + current;
            prev = temp;
        }
        return current;
	}
	
}
