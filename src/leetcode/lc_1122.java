package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int n1 = arr1.length;
        int[] ans = new int[n1];

        for (int j : arr1) {
            count[j]++;
        }

        int k = 0;
        for (int num : arr2) {
            if (count[num] > 0) {
                while (count[num] > 0) {
                    ans[k++] = num;
                    count[num]--;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ans[k++] = i;
                count[i]--;
            }
        }
        return ans;
    }

    public int[] relativeSortArray_Map(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n1 = arr1.length;
        int[] ans = new int[n1];
        for (int j : arr1) {
            mp.put(j, mp.getOrDefault(j, 0) + 1);
        }
        int k = 0;
        for (int num : arr2) {
            int count = mp.get(num);
            while (count > 0) {
                ans[k++] = num;
                count--;
            }
            mp.remove(num);
        }

        int[] rest = new int[n1 - k];
        int i = 0;
        for (int key : mp.keySet()) {
            int count = mp.get(key);
            while (count > 0) {
                rest[i++] = key;
                count--;
            }
        }
        Arrays.sort(rest);
        for (int j : rest) {
            ans[k++] = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = new lc_1122().relativeSortArray(arr1, arr2);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] res2 = new lc_1122().relativeSortArray_Map(arr1, arr2);
        for (int i : res2) {
            System.out.print(i + " ");
        }
    }
}
