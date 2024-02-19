package leetcode;

import java.util.HashMap;

public class lc_1658 {
    public static int minOperations(int[] nums, int x) {

        int minOperations = 0;
        HashMap<Integer, Integer> mp_l = new HashMap<>();
        HashMap<Integer, Integer> mp_r = new HashMap<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right && x > 0) {
            int num_l = nums[left];
            int num_r = nums[right];
            if (x - nums[left] > 0) {
                x -= num_l;
                if (mp_r.containsKey(num_r)) {
                    mp_r.put(num_r, mp_r.get(num_r) - 1);
                }
                mp_l.put(x, mp_l.getOrDefault(0, 0) + 1);
                left++;
            }
            if (x - nums[right] > 0) {
                x -= num_r;
                mp_r.put(x, mp_r.getOrDefault(0, 0) + 1);
                right--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int res = minOperations(a, 4);
        System.out.println(res);
    }
}
