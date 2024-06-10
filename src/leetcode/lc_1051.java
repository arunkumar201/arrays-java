package leetcode;

import java.util.Arrays;

public class lc_1051 {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                res++;
            }
        }
        return res;
    }

    //better solution with constant space
    public int heightChecker_optimal(int[] heights) {
        int[] sortedCount = new int[101];
        int n = heights.length;
        int ans = 0;
        for (int height : heights) {
            sortedCount[height]++;
        }
        int j = 0;
        for (int i = 1; i < sortedCount.length; i++) {
            while (sortedCount[i] > 0) {
                if (heights[j] != i) {
                    ans++;
                }
                j++;
                sortedCount[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        int res = new lc_1051().heightChecker_optimal(arr);
        System.out.println(res);
    }

}
