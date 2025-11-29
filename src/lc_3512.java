public class lc_3512 {
	
	public static void main(String[] args) {
		// Input: nums = [3,9,7], k = 5
		lc_3512 sol = new lc_3512();
		System.out.println(sol.minOperations(new int[]{3, 9, 7}, 5));
	}
	
		public int minOperations(int[] nums, int k) {
			int total_sum = 0;

			// Calculate the sum of all elements
			for (int num : nums) {
				total_sum += num;
			}

			return total_sum % k;
		}
}
