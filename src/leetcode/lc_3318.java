package leetcode;

import java.util.Arrays;

public class lc_3318 {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 4, 2, 3 };
		int k = 6, x = 2;
		lc_3318 lc = new lc_3318();
		int[] result = lc.findXSum(nums, k, x);
		System.out.println(Arrays.toString(result));
	}

	public int[] findXSum(int[] nums, int k, int x) {
		int n = nums.length, res[] = new int[n - k + 1];
		for (int i = 0; i <= n - k; i++) {
			int[][] sub = new int[51][2];
			for (int j = i; j < i + k; j++) {
				sub[nums[j]][0] = nums[j];
				sub[nums[j]][1]++;
			}

			Arrays.sort(sub, (a, b) -> b[1] != a[1] ? b[1] - a[1] : b[0] - a[0]);
			int sum = 0, count = 0;
			for (int j = 0; j < 51 && count < x; j++) {
				sum += sub[j][0] * sub[j][1];
				count++;
			}
			res[i] = sum;
		}
		return res;
	}
}
