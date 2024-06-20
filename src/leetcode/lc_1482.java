package leetcode;

public class lc_1482 {

    public static int minDays_BruteForce(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        //if we have less numb of flowers then require ,return -1;
        if (n < m * k) {
            return -1;
        }

        int maxDay = 0;
        int minDay = Integer.MAX_VALUE;
        //calculate the max Day from the bloomDay
        for (int day : bloomDay) {
            maxDay = Math.max(maxDay, day);
            minDay = Math.min(min, day);
        }
        //start from day 1 to max
        for (int day = minDay; day <= maxDay; day++) {
            int bouquets = 0;
            int flowers = 0;
            for (int i : bloomDay) {
                if (i <= day) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                return day;
            }
        }
        return -1;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        //if we have less numb of flowers then require ,return -1;
        if (n < m * k) {
            return -1;
        }
        int maxDay = 0;
        for (int day : bloomDay) maxDay = Math.max(maxDay, day);
        int left = 1;
        int right = maxDay;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int bouquets = 0;
            int flowers = 0;
            for (int j = 0; j < n; j++) {
                if (bloomDay[j] <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > maxDay) {
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 2;
        System.out.println("Brute Force Solution:- " + minDays_BruteForce(bloomDay, m, k));
        System.out.println("Optimal Solution:- " + minDays(bloomDay, m, k));
    }
}
