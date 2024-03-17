package leetcode;

import java.util.Arrays;

public class lc_238 {

    public int[] productExceptSelf_BruteForce(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        int total = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    total *= nums[j];
                }
            }
            result[i] = total;
            total = 1;
        }
        return result;
    }

    public int[] productExceptSelf_usingDivisor(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int total_product_without_zero = 1;
        int count = 0;
        for (int num : nums) {
            if (num != 0) {
                total_product_without_zero *= num;
            } else {
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (count > 0) {
                    result[i] = 0;
                } else {
                    result[i] = total_product_without_zero / nums[i];
                }
            } else {
                if (count > 1) {
                    result[i] = 0;
                } else {
                    result[i] = total_product_without_zero;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

        int[] res = new lc_238().productExceptSelf_usingDivisor(nums);
        System.out.println(Arrays.toString(res));
    }
}
