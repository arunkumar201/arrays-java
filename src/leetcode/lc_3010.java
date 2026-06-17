public class lc_3010 {


	public static void main(String[] args) {
		// Input: nums = [1,2,3,12]
		int[] nums = new int[] { 1, 2, 3, 12 };
		lc_3010 sol = new lc_3010();

		System.out.println("result"+sol.minimumCost(nums));



	}
	
	public int minimumCost(int[] nums) {
		int score = nums[0];

		int first_min = Integer.MAX_VALUE;
		int second_min = Integer.MAX_VALUE;
		int n = nums.length;


		for (int i = 1; i < n; i++) {
			if (nums[i] < first_min) {
				second_min = first_min;
				first_min = nums[i];
			} else if (nums[i] < second_min) {
				second_min = nums[i];
			}
		}
		return score + first_min + second_min;
	}
	
}
