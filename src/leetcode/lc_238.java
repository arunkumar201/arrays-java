package leetcode;

import java.util.Arrays;

public class lc_238 {

    public int[] productExceptSelf_BruteForce(int[] nums) {
        //Time Complexity: O(N^2)
        //Space Complexity: O(1)
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
        //Time Complexity: O(N)
        //Space Complexity: O(1)
        //but this Question is required to not use divisor method
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

    //Without using divisor method
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] postfix_product = new int[n];
        int[] prefix_product = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                postfix_product[i] = nums[i];
            } else {
                postfix_product[i] = postfix_product[i + 1] * nums[i];
            }
        }

        for (int j = 0; j < n; j++) {
            if (j == 0) {
                prefix_product[j] = nums[j];
            } else {
                prefix_product[j] = prefix_product[j - 1] * nums[j];
            }
        }

        for (int k = 0; k < n; k++) {
            if (k == 0) {
                result[k] = postfix_product[k + 1];
            } else if (k == n - 1) {
                result[k] = prefix_product[k - 1];
            } else {
                result[k] = prefix_product[k - 1] * postfix_product[k + 1];
            }
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int total_product_without_zero = 1;
        int zeros_count = 0;
        int[] result = new int[len];

        for (int num : nums) {
            if (num != 0) {
                total_product_without_zero *= num;
            } else {
                zeros_count++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                result[i] = zeros_count > 1 ? 0 : total_product_without_zero;
            } else {
                if (zeros_count > 0) {
                    result[i] = 0;
                } else {
                    result[i] = total_product_without_zero / nums[i];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};

        int[] res = new lc_238().productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
