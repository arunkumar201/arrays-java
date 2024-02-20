package leetcode;

import java.util.Arrays;

public class lc_1299 {
    public int[] replaceElements_extraSpace(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = max;
            max = Math.max(max, arr[i]);
        }
        return ans;
    }

    public int[] replaceElements(int[] arr) {
//start from the end of the array  or iterate in reverse order
//   maintain the rightMax value
//   replace the current element with the rightMax
//    update the rightMax value
        int n = arr.length;
        int rightMax = arr[n - 1];
        arr[n - 1] = -1;
        for (int j = n - 2; j >= 0; j--) {
            int newMax = arr[j];
            arr[j] = rightMax;
            rightMax = Math.max(rightMax, newMax);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{17, 18, 5, 4, 6, 1};
        int[] res = new lc_1299().replaceElements(a);
        System.out.println(Arrays.toString(res));
    }
}
