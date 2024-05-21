package leetcode;

import java.util.Arrays;

public class lc_3152 {
    public boolean isArraySpecial1(int[] nums, int from, int to) {
        for (int i = from; i <= to; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }
        return true;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] isSpecialPrefix = new int[n];
        boolean[] res = new boolean[queries.length];
        int value = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                value++;
            }
            isSpecialPrefix[i] = value;
        }
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            res[i] = isSpecialPrefix[to] == isSpecialPrefix[from];
        }
        return res;
    }

    public static void main(String[] args) {
//Input: nums = [3,4,1,2,6], queries = [[0,4]]
//[2,8,10,9]
//[[1,3]] - false
        int[] nums = new int[]{4, 3, 1, 6};
        int[][] queries = new int[][]{{0, 2}, {2, 3}};
        boolean[] res = new lc_3152().isArraySpecial(nums, queries);
        System.out.println(Arrays.toString(res));

    }
}
