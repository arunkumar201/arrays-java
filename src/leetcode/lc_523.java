package leetcode;

import java.util.HashMap;

public class lc_523 {

    public boolean checkSubarraySum_usingBruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum % k == 0 && j - i + 1 >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if (rem == 0 && i >= 1) {
                return true;
            }
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23, 2, 4, 6, 6};
        int k = 7;
        boolean res = new lc_523().checkSubarraySum(nums, k);
        System.out.println(res);
    }
}