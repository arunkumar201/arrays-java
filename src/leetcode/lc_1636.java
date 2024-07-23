package leetcode;

import java.util.Arrays;

public class lc_1636 {
	
	public int[] frequencySort(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int[][] count = new int[201][2];
		
		for (int i = 0; i < 201; i++) {
			count[i][0] = i - 100;
		}
		
		for (int num : nums) {
			count[num + 100][1]++;
		}
		
		Arrays.sort(count, (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
		
		int index = 0;
		for (int i = 0; i < 201; i++) {
			for (int j = 0; j < count[i][1]; j++) {
				result[n - 1 - index++] = count[i][0];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//Input: nums = [1,1,2,2,2,3]
		int[] nums = new int[]{1, 1, 2, 2, 2, 3};
		int[] res = new lc_1636().frequencySort(nums);
		for (int num : res) {
			System.out.print(num + " ");
		}
		
	}
}
