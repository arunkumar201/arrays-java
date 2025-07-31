package leetcode;

import java.util.HashSet;

public class lc_898 {
	
	public static void main(String[] args) {
		//Input: arr = [1,1,2]
		int[] arr = new int[]{1, 2, 4};
		int result_bruteForce = new lc_898().subarrayBitwiseORs_bruteForce(arr);
		System.out.println("Brute Force : " + result_bruteForce);
		
		
		int result_optimized = new lc_898().subarrayBitwiseORs_optimized(arr);
		System.out.println("Optimized : " + result_optimized);
		
		
	}
	
	public int subarrayBitwiseORs_bruteForce(int[] nums) {
		HashSet<Integer> seen_bitwiseOR = new HashSet<>();
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int bitwiseOR = 0;
			for (int j = i; j < n; j++) {
				bitwiseOR |= nums[j];
				seen_bitwiseOR.add(bitwiseOR);
			}
		}
		return seen_bitwiseOR.size();
	}
	
	//Optimized
	// O(n) time, O(1) space
	//worst case (32*n) time
	public int subarrayBitwiseORs_optimized(int[] nums) {
		HashSet<Integer> result = new HashSet<>();
		HashSet<Integer> prev = new HashSet<>();
		
		for (int currItem : nums) {
			HashSet<Integer> curr = new HashSet<>();
			curr.add(currItem); // make the sub array [currItem]
			
			//extend all subarrays ending with currItem
			for (int x : prev) {
				curr.add(x | currItem);
			}
			
			//collect all unique OR results
			result.addAll(curr);
			prev = curr;
		}
		return result.size();
		
	}
}
	