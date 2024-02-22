package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_1 {

    public static int[] twoSum_BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (mp.containsKey(diff)) {
                return new int[]{i, mp.get(diff)};
            }
            mp.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
