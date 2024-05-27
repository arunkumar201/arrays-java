package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_100321 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        long goodPairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            System.out.println(num + "  "+ num % k);
            if (num % k == 0) {
                map.put(num/k, map.getOrDefault(num/k, 0) + 1);
            }
        }
        System.out.println(map);
        for (int num : nums2) {
            if (num % k == 0) {
                goodPairs += map.getOrDefault(num/k, 0);
            }   
        }

        return goodPairs;
    }

    public static void main(String[] args) {
//Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

        int[] nums1 = new int[]{1, 3, 4};
        int[] nums2 = new int[]{1, 3, 4};
        int k = 1;
//        ans=2
        long res = new lc_100321().numberOfPairs(nums1, nums2, k);
        System.out.println(res);


    }
}
