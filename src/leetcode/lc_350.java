package leetcode;

import java.util.Arrays;

public class lc_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int k = 0;
        for (int j : nums2) {
            freq[j]++;
        }
        for (int j : nums1) {
            if (freq[j] > 0) {
                nums2[k++] = j;
                freq[j]--;
            }
        }
        int[] result = new int[k];
        System.arraycopy(nums2, 0, result, 0, k);
        return result;
    }

    public int[] intersect_sorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        lc_350 obj = new lc_350();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = obj.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
