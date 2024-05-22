package leetcode;

import java.util.Arrays;

public class lc_3153 {

    public long countDigits(int num) {
        long count = 0;

        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        int n = nums.length;
        long[] prefixDigitSum = new long[nums.length];
        for (int i = n - 1; i >= 0; i--) {
            prefixDigitSum[i] = countDigits(nums[i]);
        }
        System.out.println(Arrays.toString(prefixDigitSum));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                res +=(prefixDigitSum[i] - prefixDigitSum[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//Input: nums = [13,23,12]

        int[] nums = new int[]{50,28,48};
        long res = new lc_3153().sumDigitDifferences(nums);
        System.out.println(res);


    }
}
