package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc_41 {
	public static void main(String[] args) {
		
		int[] arr = new int[]{100000, 3, 4000, 2, 15, 1, 99999};
		
		lc_41 lc = new lc_41();
		System.out.println("bruteForce");
		int res = lc.firstMissingPositive_bruteForce(arr);
		System.out.println(res);
		System.out.println("Using Sort");
		res = lc.firstMissingPositive_using_sort(arr);
		System.out.println(res);
		System.out.println("Using Set");
		res = lc.firstMissingPositive_using_set(arr);
		System.out.println(res);
		System.out.println("Optimized");
		int[] arr1 = new int[]{0};
		res = lc.smallestMissing_optimized(arr1);
		System.out.println(res);
	}
	
	
	public int firstMissingPositive_bruteForce(int[] arr) {
		int len = arr.length;
		
		for (int i = 0; i < len; i++) {
			int target = i + 1;
			boolean found = false;
			for (int k : arr) {
				if (k > 0 && k == target) {
					found = true;
					break;
				}
			}
			if (!found) {
				return target;
			}
		}
		return len + 1;
	}
	
	//using Sort
	public int firstMissingPositive_using_sort(int[] arr) {
		Arrays.sort(arr);
		int smallestMissing = 1;
		for (int num : arr) {
			if (num <= 0) continue;
			if (num == smallestMissing) {
				smallestMissing++;
			} else if (num > smallestMissing) {
				return smallestMissing;
			}
		}
		
		return smallestMissing;
	}
	
	public int firstMissingPositive_using_set(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int smallestMissing = 1;
		for (int num : arr) {
			if (num >= 0) {
				set.add(num);
			}
		}
		while (set.contains(smallestMissing)) {
			smallestMissing++;
		}
		return smallestMissing;
	}
	
	public int smallestMissing_optimized(int[] nums) {
		int n = nums.length;
		//100000, 3, 4000, 2, 15, 1, 99999
		int len = nums.length;
		
		for (int i = 0; i < len; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]
			) {
				int correctIndex = nums[i] - 1;
				
				//swap the current with the correct index
				int temp = nums[i];
				nums[i] = nums[correctIndex];
				nums[correctIndex] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}
}
	
	

