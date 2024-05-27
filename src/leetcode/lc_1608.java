package leetcode;

import java.util.Arrays;

public class lc_1608 {
    public int specialArray_BruteForce(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int j : nums) {
            max = Math.max(j, max);
        }
        for (int i = 0; i <= max; i++) {
            int count = 0;
            for (int num : nums)
                if (num >= i) count++;
            if (count == i) {
                return i;
            }
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            if (i > nums[n - i - 1] && i <= nums[i]) {
                return i;
            }
        }
        if (n <= nums[0]) return n;
        return -1;
    }


    public static void main(String[] args) {
//          Input: nums = [3,5]

        int[] nums = new int[]{0, 4, 3, 0, 4};
        int res = new lc_1608().specialArray(nums);
        System.out.println(res);

    }
}
