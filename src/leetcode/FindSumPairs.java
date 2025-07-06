package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
	
	private final ArrayList<Integer> nums1;
	private final ArrayList<Integer> nums2;
	private final Map<Integer, Integer> freqNums2;
	
	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = new ArrayList<>();
		this.nums2 = new ArrayList<>();
		this.freqNums2 = new HashMap<>();
		for (int num : nums1) {
			this.nums1.add(num);
		}
		for (int num : nums2) {
			this.nums2.add(num);
			this.freqNums2.put(num, this.freqNums2.getOrDefault(num, 0) + 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 1, 2, 2, 2, 3};
		int[] nums2 = {1, 4, 5, 2, 5, 4};
		
		FindSumPairs obj = new FindSumPairs(nums1, nums2);
		
		System.out.println("Count for sum 6: " + obj.count(7));
		obj.add(3,2);
	}
	
	public void add(int index, int val) {
		if (index < nums2.size()) {
			int old_val = nums2.get(index);
			int updated_val = old_val + val;
			
			nums2.set(index, updated_val);
			
			freqNums2.put(old_val, freqNums2.get(old_val) - 1);
			if (freqNums2.get(old_val) == 0) {
				freqNums2.remove(old_val);
			}
			
			freqNums2.put(updated_val, freqNums2.getOrDefault(updated_val, 0) + 1);
		}
	}
	
	public int count(int tot) {
		int result = 0;
		for (Integer num1 : nums1) {
			int complement = tot - num1;
			result += freqNums2.getOrDefault(complement, 0);
		}
		return result;
	}
}
