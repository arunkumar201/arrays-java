



package leetcode;

public class lc_3295 {

	public static void main(String[] args) {
		// Input: nums = [7,1,5,4,3,4,6,0,9,5,8,2]
		int[] nums = { 7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2 };
		lc_3295 lc_3295 = new lc_3295();
		System.out.println(lc_3295.getSneakyNumbers(nums));

	}

	public int[] getSneakyNumbers(int[] nums) {
		int[] ans = new int[2];
		int[] cache = new int[101];
		int x = 0;
		for (int num : nums) {
			if (cache[num] != 0 && x < 2) {
				ans[x++] = num;
			}
			cache[num]++;
		}
		return ans;
	}
}
