package leetcode;

public class lc_509 {
	
	
	public static void main(String[] args) {
		int n = 5;
		int res = new lc_509().fib(n);
		System.out.println(res);
//        int res_1 = new lc_509().fib_1(n);
//        System.out.println(res_1);
		
	}
	
	/**
	 * LEETCODE - 509
	 * Calculates the nth Fibonacci number using an iterative approach.
	 * This method uses constant space and linear time complexity.
	 * <p>
	 * The Fibonacci sequence is defined as:
	 * fib(0) = 0
	 * fib(1) = 1
	 * fib(n) = fib(n-1) + fib(n-2) for n >= 1
	 *
	 * @param n The position in the Fibonacci sequence to calculate.
	 *          Must be a non-negative integer.
	 * @return The nth Fibonacci number.
	 * Returns n itself if n is 0 or 1.
	 * <p>
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 */
	public int fib(int n) {
		int ans = 0;
		if (n <= 1) return n;
		int a = 0;
		int b = 1;
		
		for (int i = 2; i <= n; i++) {
			ans = a + b;
			a = b;
			b = ans;
		}
		
		return ans;
	}
	
	/**
 * Calculates the nth Fibonacci number using a bottom-up dynamic programming approach.
 * <p>
 * This method implements the bottom-up DP approach, which:
 * 1. Starts from the base cases (fib(0) and fib(1))
 * 2. Builds up the solution iteratively
 * 3. Stores intermediate results in an array to avoid redundant calculations
 * <p>
 * Bottom-up vs Top-down:
 * - Bottom-up: Iterative, builds solution from smaller sub-problems to larger ones
 * - Top-down: Recursive, starts from the final problem and breaks it down, often using memoization
 * <p>
 *
 * @param n The position in the Fibonacci sequence to calculate.
 *          Must be a non-negative integer.
 * @return The nth Fibonacci number.
 *         Returns n itself if n is 0 or 1.
 *
 * Time complexity: O(n) - We iterate from 2 to n once
 * Space complexity: O(n) - We use an array of size n+1 to store all Fibonacci numbers up to n
 */
public int fib_bottom_up(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
	// Time Complexity = O(2^n)
	// Space Complexity = O(n)
    /*
    Time Complexity Explanation:
    - The time complexity is O(2^n) because for each n, we make two recursive calls.
    - This creates a binary tree of recursive calls, where the number of calls doubles at each level.
    - The height of this tree is n, so we have approximately 2^n nodes (function calls) in total.

    Space Complexity Explanation:
    - The space complexity is O(n) due to the recursive call stack.
    - In the worst case, when we reach the deepest level of recursion, there will be n function calls on the stack.
    - Each call uses a constant amount of memory, so the total space used is proportional to n.
    */
	public int fib_recursion(int n) {
		// Base case: if n is 0 or 1, return n itself
		if (n <= 1) return n;
		
		// Recursive case: sum of the two preceding numbers
		return fib_recursion(n - 1) + fib_recursion(n - 2);
	}
	
	
	// Time Complexity: O(n)
// Space Complexity: O(n)
	
	/*
	Time Complexity Explanation:
	- O(n) because each Fibonacci number is calculated only once and then stored in the memo array.
	- Subsequent calls for the same number return the memoized result in constant time.
	
	Space Complexity Explanation: O(n+n) = O(2N)~ O(N) 😀
	- O(n) due to the memo array of size n+1 to store all Fibonacci numbers up to n.
	- The recursive call stack also goes up to depth n in the worst case.
	*/
	public int fib_recursion_memo(int n, int[] memo) {
		if (n <= 1) {
			memo[n] = n;
			return n;
		}
		
		if (memo[n] != 0) return memo[n];
		
		memo[n] = fib_recursion_memo(n - 1, memo) + fib_recursion_memo(n - 2, memo);
		return memo[n];
	}
	
}
