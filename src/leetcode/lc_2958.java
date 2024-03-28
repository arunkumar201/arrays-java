package leetcode;

import java.util.HashMap;

public class lc_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int longSubArray = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;

            }
            longSubArray = Math.max(longSubArray, right - left + 1);
            right++;
        }
        return longSubArray;
    }

    public static void main(String[] args) {
//        Input: nums = [1,2,3,1,2,3,1,2], k = 2
        int[] nums = new int[]{1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        int res = new lc_2958().maxSubarrayLength(nums, k);
        System.out.println(res);

    }
}
