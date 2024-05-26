package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_100323 {
    public int numberOfPairs1(int[] nums1, int[] nums2, int k) {
        int goodPairs = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % ((nums2[j]) * k) == 0) {
                    goodPairs++;
                }
            }
        }
        return goodPairs;
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int goodPairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            int product = num * k;
            map.put(product, map.getOrDefault(product, 0) + 1);
        }

        for (int num : nums1) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (num % entry.getKey() == 0) {
                    goodPairs += entry.getValue();
                }
            }
        }

        return goodPairs;
    }

    public static void main(String[] args) {
//Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

        int[] nums1 = new int[]{1, 2, 4, 12};
        int[] nums2 = new int[]{2, 4};
        int k = 3;
        int res = new lc_100323().numberOfPairs(nums1, nums2, k);
        System.out.println(res);


    }
}
