package leetcode;

import java.util.Arrays;

public class lc_100325 {
    public int numberOfChild(int n, int k) {
        int position = 0;
        int direction = 1;

        for (int i = 0; i < k; i++) {
            if (position == 0) {
                direction = 1;
            } else if (position == n - 1) {
                direction = -1;
            }

            position += direction;
        }

        return position;
    }

    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        while (k > 0) {
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i] + arr[i - 1]) % 1_000_000_007;
            }
            k--;
        }
        System.out.println(Arrays.toString(arr));
        return arr[n - 1] % 1_000_000_007;
    }

    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int totalReward = 0;
//        pending
        return totalReward;
    }

    public static void main(String[] args) {

        //Input: n = 3, k = 5
        //Output: 1
        int n = 5, k = 1000;
//        int l = new lc_100325().valueAfterKSeconds(n, k);
//        System.out.println(l);

//        rewardValues = [1, 6, 4, 3, 2]

//Input: rewardValues = [1,6,4,3,2]
        int[] rewardValues = new int[]{1, 6, 4, 3, 2};
        int res = maxTotalReward(rewardValues);
        System.out.println(res);


    }
}
