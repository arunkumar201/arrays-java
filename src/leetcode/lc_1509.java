package leetcode;

import java.util.Arrays;

public class lc_1509 {

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        min = Math.min(min, nums[n - 2] - nums[2]); // case:1 - 2 smallest and 1 largest
        min = Math.min(min, nums[n - 3] - nums[1]); // case:2- 2 largest and 1 smallest
        min = Math.min(min, nums[n - 4] - nums[0]);// case 3: - 0 smallest and 3 largest
        min = Math.min(min, nums[n - 1] - nums[3]);// case 4: - 3 smallest and 0 largest

        return min;
    }


    public static void main(String[] args) {
        lc_1509 obj = new lc_1509();
        int[] nums = {1, 5, 0, 10, 14};
        System.out.println(obj.minDifference(nums));
    }
}
