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
            minDay = Math.min(minDay, day);
        }
        //start from day 1 to max
        for (int day = minDay; day <= maxDay; day++) {
            int minBouquetsForDaya = PossibleBouquets(day, bloomDay, k);
            System.out.println(minBouquetsForDaya);

            if (minBouquetsForDaya >= m) {
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

    private static int PossibleBouquets(int day, int[] bloomDay, int k) {
        int n = bloomDay.length;
        int ans = 0;
        int count = 0;
        for (int j : bloomDay) {
            if (j <= day) {
                count++;
            } else {
                ans += count / k;
                count = 0;
            }
        }
        ans+=count/k;
        return ans;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println("Brute Force Solution:- " + minDays_BruteForce(bloomDay, m, k));
        System.out.println("Optimal Solution:- " + minDays(bloomDay, m, k));
    }
}
