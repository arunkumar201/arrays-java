package leetcode;

import java.util.Arrays;

public class lc_3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length;
        int count = 0;
        int i = n - 1;
        Arrays.sort(happiness);
        while (i >= 0 && k > 0) {
            int x=Math.max(happiness[i] - count, 0);
            if (x > 0) {
                ans += x;
                count++;
            }
            k--;
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
//        Input: happiness = [1,2,3], k = 2

        int[] nums = new int[]{1,2,3,5,4,2,1,4,5,7,8};
        int k = 4;
        long res = new lc_3075().maximumHappinessSum(nums, k);
        System.out.println(res);

    }
}
