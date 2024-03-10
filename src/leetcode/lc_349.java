package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums2) {
            set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int j : nums1) {
            if (set.contains(j)) {
                set2.add(j);
            }
        }

        int[] result = new int[set2.size()];
        int index = 0;
        for (int num : set2) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] res = new lc_349().intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
