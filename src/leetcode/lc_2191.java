package leetcode;

import java.util.Arrays;

public class lc_2191 {
	public int[] sortJumbled(int[] mapping, int[] nums) {
		int[][] sortedNums = new int[nums.length][2];
		
		for (int i = 0; i < nums.length; i++) {
			String s = Integer.toString(nums[i]);
			int num = 0;
			for (int j : s.toCharArray()) {
				num = num * 10 + mapping[j - '0'];
			}
			sortedNums[i][0] = num;
			sortedNums[i][1] = i;
		}
		System.out.println(Arrays.deepToString(sortedNums));
		
		//sort them
		Arrays.sort(sortedNums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
		
		int[] result = new int[nums.length];
		
		for (int i = 0; i < sortedNums.length; i++) {
			result[i] = nums[sortedNums[i][1]];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
		int[] nums = {338, 991, 38};
		int[] res = new lc_2191().sortJumbled(mapping, nums);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}
