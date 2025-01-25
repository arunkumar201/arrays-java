package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class lc_2948 {
	public static void main(String[] args) {
		//Input: nums = [1,5,3,9,8], limit = 2
		int[] nums = {1, 5, 3, 9, 8};
		int limit = 2;
		int[] res = new lc_2948().lexicographicallySmallestArray_optimized(nums, limit);
		System.out.println(Arrays.toString(res));
		
	}
	
public int[] lexicographicallySmallestArray_optimized(int[] nums, int limit) {
    int n = nums.length;
    int[] sorted_nums = nums.clone();
    Arrays.sort(sorted_nums);
    
    HashMap<Integer, Integer> numToGroup = new HashMap<>();
    HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
    
    int groupNum = 0;
    for (int i = 0; i < n; i++) {
        if (i > 0 && sorted_nums[i] - sorted_nums[i - 1] > limit) {
            groupNum++;
        }
        
        numToGroup.put(sorted_nums[i], groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(sorted_nums[i]);
    }
    
//    System.out.println("\t" + Arrays.toString(nums) + "  " + numToGroup + "    " + groupToList);
    
    for (int i = 0; i < n; i++) {
        int num = nums[i];
        int numGroup = numToGroup.get(num);
        nums[i] = groupToList.get(numGroup).removeFirst();
    }
    
//    System.out.println("----");
    
    return nums;
}
	
	public int[] lexicographicallySmallestArray_bruteForce(int[] nums, int limit) {
		int n = nums.length;
		int i = 0;
		
		while (i < n) {
			int j = i + 1;
			while (j < n) {
				int absDiff = Math.abs(nums[i] - nums[j]);
				if (absDiff <= limit && nums[i] > nums[j]) {
					swap(nums, i, j);
					j = i + 1;
				} else {
					j++;
				}
			}
			i++;
		}
		return nums;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
