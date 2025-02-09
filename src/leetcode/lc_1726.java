package leetcode;

import java.util.HashMap;

public class lc_1726 {
	public static void main(String[] args) {
// Input: nums = [2,3,4,6]
		int[] nums = {1, 2, 4, 5, 10};
		System.out.println(new lc_1726().tupleSameProduct(nums));
	}
	
	public int tupleSameProduct(int[] nums) {
		int n = nums.length;
		HashMap<Integer, Integer> product_count = new HashMap<>(); //n2*n2 -> count
//		HashMap<Integer, Integer> pairs_count = new HashMap<>(); //n*n2-> count of pairs (a,b) and (c,d)
		
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int product = nums[i] * nums[j];
//				pairs_count.put(product, pairs_count.getOrDefault(product, 0) + product_count.getOrDefault(product, 0));
				product_count.put(product, product_count.getOrDefault(product, 0) + 1);
			}
		}
		/*
		1 count -> 0 Pair -> o tuples
		2 count -> 1 Pairs -> 8 tuples (
		3 count -> 3 pairs -> 24 tuples
		4 count -> 6 pairs -> 48 tuples
		5 count -> 10 pairs -> 80 tuples
		 */
		
		
		int res = 0;
		for (int count : product_count.values()) {
			int pairs = count * (count - 1) / 2;
			res += pairs * 8;
		}
		return res;
	}
}
