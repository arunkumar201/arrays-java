package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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

        if(map.containsKey(k)) {
            count = count + map.get(k);
        }
        return count;
    }

    public static int findSubarray(int[] arr, int n) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;

        int[] prefix = new int[len];
//        calculate prefix sum
        prefix[0] = arr[0];

        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int x : prefix) {
            if (map.containsKey(x) || x == 0) {
                count = count + map.get(x);
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        Input: nums = [1,1,1], k = 2
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        int res = new lc_560().subarraySum(nums, k);
        System.out.println(res);

        int[] nums1 = new int[]{6, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int res1 = findSubarray(nums1, k);
        System.out.println(res1);
    }
}
