package leetcode;

public class lc_2962 {

    public int getMaxValue(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = getMaxValue(nums);
        int left = 0;
        int right = 1;
        int res = 0;
        int count = 0;
        while (right < n && left < n) {
            if (nums[left] == max) count++;

            while (right < n && count >= k) {
                if (nums[right] == max) {
                    count--;
                }
                right++;
            }
            if (count >= k) {

                res += right - left + 1;
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,3};
        int k = 2;
        long res = new lc_2962().countSubarrays(nums, k);
        System.out.println("result=: " + res);
    }
}
