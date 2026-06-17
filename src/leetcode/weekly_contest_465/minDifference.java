package leetcode.weekly_contest_465;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minDifference {
	
	public static void main(String[] args) {
		int n = 100, k = 2;
		
		minDifference sol = new minDifference();
		int[] result = sol.minDifference(n, k);
		
		System.out.println("result "+Arrays.toString(result));
	}
	
	// Prime factorization
	public static List<Integer> primeFactors(int n) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) factors.add(n);
		return factors;
	}
	
	public int[] minDifference(int n, int k) {
		List<Integer> factors = primeFactors(n);
		
		
		// Start with k groups initialized to 1
		int[] groups = new int[k];
		Arrays.fill(groups, 1);
		
		factors.sort(Collections.reverseOrder());
		
		for (int f : factors) {
			int minIndex = 0;
			for (int i = 1; i < k; i++) {
				if (groups[i] < groups[minIndex]) {
					minIndex = i;
				}
			}
			groups[minIndex] *= f;
		}
		
		return groups;
	}
}
