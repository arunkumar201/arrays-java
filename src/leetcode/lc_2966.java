package leetcode;

import java.util.Arrays;

public class lc_2966 {


    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        Arrays.sort(nums);
        int x = 0;
        for (int i = 0; i <= n - 3; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                res[x][0] = nums[i];
                res[x][1] = nums[i + 1];
                res[x][2] = nums[i + 2];
                x++;
            } else {
                return new int[][]{};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc_2966 lc = new lc_2966();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        int[][] res = lc.divideArray(nums, k);
        System.out.println(Arrays.deepToString(res));
    }
}
