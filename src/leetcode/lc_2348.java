
public class lc_2348 {
	
	public static void main(String[] args) {
		
		//Input: nums = [1,3,0,0,2,0,0,4] -6
//		Input: nums = [0,0,0,2,0,0] -9
		
		int[] nums = {0, 0, 0, 2, 0, 0};
		lc_2348 lc = new lc_2348();
		long res = lc.zeroFilledSubarray(nums);
		System.out.println(res);
		System.out.println("Optimized");
		res = lc.zeroFilledSubarray_optimized(nums);
		System.out.println(res);
		System.out.println("Optimized 1");
		res = lc.zeroFilledSubarray_optimized_1(nums);
		System.out.println(res);
		
	}
	
	public long zeroFilledSubarray(int[] nums) {

		int len = nums.length;
		long ans = 0;

		int left = 0;
		int right = 0;
		while (right < len) {
			int currentNum = nums[right];

			if (currentNum != 0) {
				left = right + 1;
			}
			ans += (long) right - left + 1;
			right++;
		}
		return ans;
	}
	
	public long zeroFilledSubarray_optimized_1(int[] nums) {
		long ans = 0;
		long continues_zeros = 0;
		
		for (int num : nums) {
			
			if (num == 0) {
				continues_zeros++;
				ans+=continues_zeros;
				
			} else {
				continues_zeros = 0;
			}
		}
		return ans;
	}
	
	public long zeroFilledSubarray_optimized(int[] nums) {
		long ans = 0;
		long continues_zeros = 0;

		for (int num : nums) {
			if (num == 0) {
				continues_zeros++;
			} else {
				// total sub arrays count = (n*(n+1)/2)
				System.out.println("continues_zeros: " + continues_zeros);
				if (continues_zeros > 0) {
					ans += continues_zeros * (continues_zeros + 1) / 2;
				}
				continues_zeros = 0;
			}
		}
		if (continues_zeros > 0) {
			ans += continues_zeros * (continues_zeros + 1) / 2;
		}
		return ans;
	}
	
}
