package leetcode;

import java.util.Arrays;

public class lc_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[n - i - 1] = nums[left] * nums[left];
                left++;
            } else {
                res[n - i - 1] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        int[] res = new lc_977().sortedSquares(arr);
        System.out.println(Arrays.toString(res));
    }
}
