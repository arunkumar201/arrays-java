package leetcode;

public class lc_713 {
    public int numSubarrayProductLessThanK_BruteForce(int[] nums, int k) {
        int totalSubarray = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = i; j < len; j++) {
                product *= nums[j];
                if (product < k) {
                    totalSubarray++;
                } else {
                    break;
                }
            }
        }
        return totalSubarray;
    }

    //    using sliding window technique
    public int numSubarrayProductLessThanK_SlidingWindow(int[] nums, int k) {
        int totalSubarray = 0;
        int len = nums.length;
        int left = 0;
        int right = 0;


        return totalSubarray;
    }

    public static void main(String[] args) {
//        nums = [10,5,2,6], k = 100
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        int res = new lc_713().numSubarrayProductLessThanK_SlidingWindow(nums, k);
        System.out.println(res);
    }
}
