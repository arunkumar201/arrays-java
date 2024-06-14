package leetcode;

import java.util.Arrays;

public class lc_945 {
        public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        //Input: [1,2,2]
        int[] arr = new int[]{3,2,1,2,1,7};
        int res = new lc_945().minIncrementForUnique(arr);
        System.out.println(res);
    }
}
