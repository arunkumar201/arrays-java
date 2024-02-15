package leetcode;

import java.util.Arrays;

public class lc_2149 {

    public static int[] rearrangeArray(int[] nums) {

        int[] res = new int[nums.length];
        int positivePtr=0;
        int negativePtr=1;
        for (int num : nums) {
            if (num > 0) {
                res[positivePtr] = num;
                positivePtr += 2;
            } else {
                res[negativePtr] = num;
                negativePtr += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = new int[]{3,1,-2,-5,2,-4};
        int[] res = rearrangeArray(a);
        System.out.println(Arrays.toString(res));

    }
}
