package leetcode;

public class lc_2918 {
	
	
	public static void main(String[] args) {
		//Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
		int[] nums1 = {3, 2, 0, 1, 0};
		int[] nums2 = {6, 5, 0};
		long res = new lc_2918().minSum(nums1, nums2);
		System.out.println(res);
		
		
	}
	
	public long minSum(int[] nums1, int[] nums2) {
		long sum1 = 0;
		long sum2 = 0;
		int zero1 = 0;
		int zero2 = 0;
		
		for (int num : nums1) {
			sum1 += num;
			zero1 += num == 0 ? 1 : 0;
		}
		
		for (int num : nums2) {
			sum2 += num;
			zero2 += num == 0 ? 1 : 0;
		}
		long minSum1 = sum1 + zero1;
		long minSum2 = sum2 + zero2;
		
		if (minSum1 < minSum2 && zero1 == 0) {
			return -1;
		}
		if (minSum2 < minSum1 && zero2 == 0) {
			return -1;
		}
		return Math.max(sum1 + zero1, sum2 + zero2);
	}
}
