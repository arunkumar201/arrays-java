package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_2161 {
	public static void main(String[] args) {
		
		int[] nums = {9, 12, 5, 10, 14, 3, 10};
		int pivot = 10;
		int[] res = new lc_2161().pivotArray(nums, pivot);
		System.out.println(Arrays.toString(res)); //Output: [9,5,3,10,10,12,14]
	}
	
	public int[] pivotArray(int[] nums, int pivot) {
		int n = nums.length;
		int[] res = new int[n];
		int lessThanPivotCount = 0;
		int equalToPivotCount = 0;
		
		for (int num : nums) {
			if (num < pivot) {
				lessThanPivotCount++;
			} else if (num == pivot) {
				equalToPivotCount++;
				
			}
		}
		
		int lessThanPivotIndex = 0;
		int equalToPivotIndex = lessThanPivotCount;
		int greaterThanPivotIndex = lessThanPivotCount + equalToPivotCount;
		for (int num : nums) {
			if (num < pivot) {
				res[lessThanPivotIndex++] = num;
			} else if (num == pivot) {
				res[equalToPivotIndex++] = num;
			} else {
				res[greaterThanPivotIndex++] = num;
			}
		}
		return res;
	}
	
	public int[] pivotArray_bruteForce(int[] nums, int pivot) {
		int n = nums.length;
		List<Integer> lessThanPivot = new ArrayList<>();
		List<Integer> equalToPivot = new ArrayList<>();
		List<Integer> greaterThanPivot = new ArrayList<>();
		
		for (int num : nums) {
			if (num < pivot) {
				lessThanPivot.add(num);
			} else if (num == pivot) {
				equalToPivot.add(num);
			} else {
				greaterThanPivot.add(num);
			}
		}
		
		int[] res = new int[n];
		int k = 0;
		for (int value : lessThanPivot) {
			res[k++] = value;
		}
		for (int value : equalToPivot) {
			res[k++] = value;
		}
		for (int value : greaterThanPivot) {
			res[k++] = value;
		}
		return res;
	}
}
