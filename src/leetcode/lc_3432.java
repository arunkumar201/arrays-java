public class lc_3432 {
	
	public static void main(String[] args) {
		//10,10,3,7,6
		int[] nums = new int[] { 10, 10, 3, 7, 6 };
		
		lc_3432 sol = new lc_3432();
		System.out.println("Result: "+sol.countPartitions(nums));
		
	}

	public int countPartitions(int[] nums) {
		int total_sum = 0;
		int n = nums.length;
		int count = 0;
		for (int num : nums) {
			total_sum += num;
		}

		//if total_sum is odd - npt possible to form the valid partition where diff is even 
		if (total_sum % 2 == 1) {
			return 0;
		}
		
		int curr_sum = 0;
		for (int i = 0; i < n-1; i++) {
			curr_sum += nums[i];
			int res_sum = total_sum - curr_sum;

			if((curr_sum-res_sum)%2==0){
				count++;
			}

		}
		return count;
    
    }
}
