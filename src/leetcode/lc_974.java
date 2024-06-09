package leetcode;

import java.util.HashMap;

public class lc_974 {


    public int subarraysDivByK_BruteForce(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    //optimize sol add comments
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            int remainder = currSum % k;
            if (remainder == 0) {
                res++;
            }
            if (remainder < 0) {
                remainder += k;
            }
            if (map.containsKey(remainder)) {
                res += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }

    public int subarraysDivByK_Optimized(int[] nums, int k) {
        int count = 0, sum = 0;
        int[] freq = new int[k];

        for (int num : nums) {
            sum += num;
            int mod = sum % k;
            if (mod == 0) count++;
            if (mod < 0) mod += k; // if mod is negative, make it positive

            count += freq[mod]; // add the frequency of mod to count
            freq[mod]++; // increment the frequency of mod
        }
        return count;
    }

    public static void main(String[] args) {
//        Input: nums = [4,5,0,-2,-3,1], k = 5

        int[] nums = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        int res = new lc_974().subarraysDivByK_Optimized(nums, k);
        System.out.println(res);
    }
}
