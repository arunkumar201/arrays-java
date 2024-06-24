package leetcode;

import java.util.Arrays;

public class lc_1052 {
    public int maxSatisfied_BruteForce(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int count = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        for (int i = 0; i < n - minutes + 1; i++) {
            int temp = 0;
            for (int j = i; j < i + minutes; j++) {
                if (grumpy[j] == 1) {
                    temp += customers[j];
                }
            }
            count = Math.max(count, temp);
        }
        res += count;

        return res;
    }

    public static void main(String[] args) {
        //Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int res_bruteForce = new lc_1052().maxSatisfied_BruteForce(customers, grumpy, minutes);
        System.out.println("Brute Force Solution:- " + res_bruteForce);
    }
}
