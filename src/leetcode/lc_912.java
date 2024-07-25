package leetcode;

import java.util.Arrays;

public class lc_912 {
	public int[] sortArray(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.sort(nums);
		System.arraycopy(nums, 0, res, 0, n);
		return res;
	}
	
	//using counting sort
	public int[] sortArray_countingSort(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		
		int[] counter = new int[100001];
		for (int i : nums) {
			counter[i + 50000]++;
		}
		
		int index = 0;
		for (int i = 0; i < 100001; i++) {
			while (counter[i] > 0) {
				res[index] = i - 50000;
				counter[i]--;
				index++;
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		//Input: nums = [5,2,3,1]
		int[] nums = new int[]{5, 2, 3, 1};
		int[] res = new lc_912().sortArray(nums);
		for (int num : res) {
			System.out.print(num + " ");
		}
		//using count sort
		res = new lc_912().sortArray_countingSort(nums);
		System.out.println("\nCounting Sort: ");
		for (int num : res) {
			System.out.print(num + " ");
		}
		
	}
}
