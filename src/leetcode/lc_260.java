package leetcode;

import java.util.HashSet;

public class lc_260 {
	public static int[] singleNumber(int[] nums) {
		int[] result = new int[2];
		int xorResult = 0;
		for (int num : nums) {
			xorResult ^= num;
		}
		int rightmostBit = xorResult & (~xorResult + 1);
		for (int num : nums) {
			if ((num & rightmostBit) == 0) {
				result[0] ^= num;
			} else {
				result[1] ^= num;
			}
		}
		return result;
		
	}
	
	public static int[] singleNumber2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int[] result = new int[2];
		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
			} else {
				set.remove(num);
			}
		}
		int i = 0;
		for (int num : set) {
			result[i++] = num;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber2(nums);
		System.out.println("The two unique numbers are: " + result[0] + " and " + result[1]);
	}
}
