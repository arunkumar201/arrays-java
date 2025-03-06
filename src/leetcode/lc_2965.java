package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_2965 {
	
	public static void main(String[] args) {
		//Input: grid = [[1,3],[2,2]]
		//Output: [2,4]
		int[][] grid = {{1, 3}, {2, 2}};
		System.out.println(Arrays.toString(new lc_2965().findMissingAndRepeatedValues(grid)));
		
	}
	
	
	public int[] findMissingAndRepeatedValues(int[][] grid) {
		int n = grid.length;
		int max_element = n * n;
		int total_sum = max_element * (max_element + 1) / 2;
		HashSet<Integer> hs = new HashSet<>();
		int sum = 0;
		int duplicate = 0;
		for (int[] arr : grid) {
			for (int num : arr) {
				if (hs.contains(num)) {
					duplicate = num;
				} else {
					hs.add(num);
					sum += num;
				}
			}
		}
		int missing = total_sum - sum;
		return new int[]{duplicate, missing};
	}
	
	public int[] findMissingAndRepeatedValues_optimized(int[][] grid) {
		int n = grid.length;
		int maxElement = n * n;
		
		long expectedSum = (long) maxElement * (maxElement + 1) / 2;
		long expectedSquareSum = (maxElement * (maxElement + 1) * (2L * maxElement + 1)) / 6;
		
		long actualSum = 0, actualSquareSum = 0;
		
		for (int[] row : grid) {
			for (int num : row) {
				actualSum += num;
				actualSquareSum += (long) num * num;
			}
		}
		
		int sumDiff = (int) (actualSum - expectedSum);
		int squareSumDiff = (int) (actualSquareSum - expectedSquareSum);
		
		int sumXY = squareSumDiff / sumDiff;
		
		int missing = (sumXY - sumDiff) / 2;
		int duplicateValue = missing + sumDiff;
		
		return new int[]{duplicateValue, missing};
	}
	
	
}
