package leetcode;

import java.util.Arrays;

public class lc_1509 {

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            System.out.println(nums[n - 4 + i] + " " + nums[i]);
            min = Math.min(min, nums[n - 4 + i] - nums[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        lc_1509 obj = new lc_1509();
        int[] nums = {1, 5, 0, 10, 14};
        System.out.println(obj.minDifference(nums));
    }
}
