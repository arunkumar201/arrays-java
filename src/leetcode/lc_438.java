package leetcode;

import java.util.*;

public class lc_438 {
    public int[] nextGreaterElement_BruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        boolean foundGreaterElement = false;
        for (int i = 0; i < n1; i++) {
            int currentValue = nums1[i];
            for (int j = 0; j < n2; j++) {
                if (nums2[j] == currentValue) {
                    for (int k = j; k < n2; k++) {
                        foundGreaterElement = false;
                        if (nums2[k] > currentValue) {
                            ans[i] = nums2[k];
                            foundGreaterElement = true;
                            break;

                        }
                    }

                }
            }
            if (!foundGreaterElement) {
                ans[i] = -1;
            }

        }
        return ans;

    }

    //using hashMap method

    public int[] nextGreaterElement_HashMap(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int num : nums2) {
            nextGreater.put(num, -1);
        }

        for (int i = 0; i < n2 - 1; i++) {
            for (int j = i + 1; j < n2; j++) {
                if (nums2[j] > nums2[i]) {
                    nextGreater.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < n1; i++) {
            ans[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return ans;
    }

    public int[] nextGreaterElement_Stack(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> st = new Stack<>();
        for (int j : nums2) {
            while (!st.isEmpty() && st.peek() < j) {
                map.put(st.pop(), j);
            }
            st.push(j);
        }

        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] res = new lc_438().nextGreaterElement_Stack(nums1, nums2);
//        System.out.println(Arrays.toString(res));
    }
}
