package leetcode;

import java.util.HashMap;

public class lc_560 {
    public int subarraySum_BruteForce(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] prefix = new int[len];

        prefix[0] = nums[0];

        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int x : prefix) {
            if (map.containsKey(x - k)) {
                count = count + map.get(x - k);
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        if (map.containsKey(k)) {
            count = count + map.get(k);
        }
        return count;
    }

    public int subarraySum_optimal(int[] nums, int k) {
        int total_subarray = 0;
        int prefix_sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefix_sum += num;

            if (map.containsKey(prefix_sum - k)) {
                total_subarray += map.get(prefix_sum - k);
            }
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return total_subarray;
    }

    public static void main(String[] args) {
        // Input: nums = [1,1,1], k = 2
        int[] nums = new int[] { 1, 1, 1 };
        int k = 2;
        int res = new lc_560().subarraySum(nums, k);
        System.out.println(res);

    }
}
