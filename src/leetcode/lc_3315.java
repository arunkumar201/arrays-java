import java.util.*;

public class lc_3315 {

	public static void main(String[] args) {
		// Input: nums = [11,13,31]
		List<Integer> nums = Arrays.asList(11, 13, 31);
		lc_3315 sol = new lc_3315();
		int[] result = sol.minBitwiseArray(nums);

		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	public int[] minBitwiseArray(List<Integer> nums) {
		int n = nums.size();
		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			int num = nums.get(i);
			if (num % 2 == 0) {
				ans[i] = -1;
			} else {
				int first_zero_bit = ((num + 1) & ~num);
				int result = num ^ (first_zero_bit >> 1);
				ans[i] = result;
			}
		}

		return ans;
	}
}
