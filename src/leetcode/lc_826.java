package leetcode;

import java.util.Arrays;

public class lc_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int totalProfit = 0;
        int best = 0, i = 0;
        for (int ability : worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            totalProfit += best;
        }
        return totalProfit;
    }

    //return the max index with difficulty <= target
    public int search(int[][] jobs, int target) {
        int left = 0, right = jobs.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] <= target) {
                res = mid;   //store the max index with difficulty <= target
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res + 1;
    }

    //using binary search
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        int totalProfit = 0;
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] maxProfit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i - 1][1]);
        }
        for (int ability : worker) {
            int max_profit_index = search(jobs, ability);
            totalProfit += maxProfit[max_profit_index];
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        //Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
        int[] difficulty = new int[]{2, 4, 6, 8, 10};
        int[] profit = new int[]{10, 20, 30, 40, 50};
        int[] worker = new int[]{4, 5, 6, 7};
        int res = new lc_826().maxProfitAssignment2(difficulty, profit, worker);
        System.out.println(res);
    }
}
