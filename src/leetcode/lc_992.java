package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class lc_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int goodSubarrays = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(map.get(nums[right]), 0));
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left] - 1));

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[right]);
                }
                left++;
            }
            goodSubarrays += right - left + 1;
            right++;
        }
        return goodSubarrays;
    }

    public static void main(String[] args) {

//   nums = [1,2,1,2,3], k = 2
        int[] nums = new int[]{1, 2, 1, 3, 4};
        int k = 3;
        int res = new lc_992().subarraysWithKDistinct(nums, k);
        System.out.println("Result:= " + res);
    }
}
