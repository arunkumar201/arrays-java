package leetcode;

import java.util.HashMap;

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
		HashMap<Integer, Integer> mp = new HashMap<>();
		int[] result = new int[2];
		for (int num : nums) {
			mp.put(num, mp.getOrDefault(num, 0) + 1);
		}
		System.out.println(mp);
		int i = 0;
		for (int num : nums) {
			if (mp.get(num) == 1) {
				result[i++] = num;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber2(nums);
		System.out.println("The two unique numbers are: " + result[0] + " and " + result[1]);
	}
}
