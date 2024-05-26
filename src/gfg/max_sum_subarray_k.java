package gfg;

import java.util.ArrayList;
import java.util.List;

public class max_sum_subarray_k {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long max = 0;
        return max;
    }

    public static void main(String[] args) {
//Arr = [100, 200, 300, 400]
//Output: 700
        int N = 4, K = 2;
        ArrayList<Integer> Arr = new ArrayList<Integer>(List.of(100, 200, 300, 400));
        long ans = maximumSumSubarray(K, Arr, N);
        System.out.println(ans);


    }
}
