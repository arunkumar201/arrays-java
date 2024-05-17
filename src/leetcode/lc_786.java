package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] res = new int[2];
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] arr1, double[] arr2) {
                if (arr1[0] <= arr2[0]) {
                    return -1;
                } else {
                    return 1; //swap
                }
            }
        });

        for (int i = 0; i < n - 1; i++) {
//            new Double[]{fractionRation,numerator,denominator}
            double fractionRation = (double) arr[i] / arr[n - 1];
            pq.offer(new double[]{fractionRation, i, n - 1});
        }
        while (k > 0) {
            double[] currVal = pq.poll();
            int numeratorIndex = (int) currVal[1];
            int denominatorIndex = (int) currVal[2]-1;
            if (numeratorIndex < denominatorIndex) {
                double primeFraction = (double) arr[numeratorIndex] / arr[denominatorIndex];
                pq.offer(new double[]{primeFraction, numeratorIndex, denominatorIndex});
            }
            k--;
            if (k == 0) {
                res[0] = arr[numeratorIndex];
                res[1] = arr[denominatorIndex+1];
                break;
            }
        }
    return res;
    }

    public static void main(String[] args) {
//        Input: arr = [1,2,3,5], k = 3

        int[] arr = new int[]{1,2,3,5};
        int k = 3;
        int[] res = new lc_786().kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
