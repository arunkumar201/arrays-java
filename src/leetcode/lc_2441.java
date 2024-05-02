package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_2441 {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        System.out.println(Arrays.toString(nums));

        while (start < end) {
            if (nums[start] + nums[end] == 0) {
                ans = Math.max(ans, Math.abs(nums[start]));
                start++;
                end--;
            } else if (nums[start] < 0 && Math.abs(nums[start]) < nums[end]) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }

    public int findMaxK_Better(int[] nums) {
        int n = nums.length;
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == -nums[i + 1]) return nums[i];
            if (set.contains(-nums[i])) {
                ans = Math.max(ans, Math.abs(nums[i]));
            }
            set.add(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        nums = [-1,2,-3,3

        int[] nums = new int[]{-10, 8, 6, 7, -2, -3};
        int res = new lc_2441().findMaxK(nums);
        System.out.println(res);
    }
}
