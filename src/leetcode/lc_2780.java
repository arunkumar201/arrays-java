package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_2780 {
	
	public static void main(String[] args) {
		//Input: nums = [1,2,2,2]
		List<Integer> nums = Arrays.asList(1, 2, 2, 2);
		System.out.println(new lc_2780().minimumIndex(nums)); // Output: 2
		System.out.println("-------Optimized-------");
		System.out.println(new lc_2780().minimumIndex_optimized(nums)); // Output: 2
	}
	
	public int minimumIndex(List<Integer> nums) {
		int n = nums.size();
		Map<Integer, Integer> firstMap = new HashMap<>();
		Map<Integer, Integer> secondMap = new HashMap<>();
		
		//add all items into secondMap
		for (int i = 0; i < n; i++) {
			secondMap.put(nums.get(i), secondMap.getOrDefault(nums.get(i), 0) + 1);
		}
		
		//start putting items into firstMap
		for (int i = 0; i < n; i++) {
			int current = nums.get(i);
			secondMap.put(current, secondMap.get(current) - 1);
			firstMap.put(current, firstMap.getOrDefault(current, 0) + 1);
			
			//check if the split is valid
			int leftSpiltArrSize = i + 1; //[0,i] - size=i+1
			int rightSpiltArrSize = n - i - 1; //[i+1,n-1] - size=n-i-1
			
			//has bot splits has same dominant item
			int leftDominantItemCount = firstMap.get(current);
			int rightDominantItemCount = secondMap.get(current);
			
			if (leftDominantItemCount * 2 > leftSpiltArrSize && rightDominantItemCount * 2 > rightSpiltArrSize) {
				return i;
			}
			
		}
		// if no split is valid, return -1
		return -1;
	}
	
	public int minimumIndex_optimized(List<Integer> nums) {
		int n = nums.size();
		int dominantItem = -1;
		int count = 0;
		//check which item is dominant in the array
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				dominantItem = nums.get(i);
				count++;
			} else if (nums.get(i) == dominantItem) {
				count++;
			} else {
				count--;
			}
		}
		//get dominant item count in entire array
		int dominantItemCount = count;
		for (int i = 0; i < n; i++) {
			if (nums.get(i) == dominantItem) {
				dominantItemCount++;
			}
		}
		
		//check if the split is valid
		int c = 0;
		for (int i = 0; i < n; i++) {
			int current = nums.get(i);
			if (current == dominantItem) {
				c++;
			}
			if (c * 2 > i + 1 && (dominantItemCount - c) * 2 > n - i - 1) {
				return i;
			}
		}
		// if no split is valid, return -1
		return -1;
	}
}
