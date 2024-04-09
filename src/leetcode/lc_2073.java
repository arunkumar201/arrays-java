package leetcode;

import java.util.Arrays;

public class lc_2073 {
    public int timeRequiredToBuy_simulation(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        while (tickets[k] > 0) {
            int time = 0;
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                }
                if (tickets[k] == 0) break;
            }
            ans += time;
        }
        return ans;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                ans += Math.min(tickets[k], tickets[i]);
            } else {
                ans += Math.min(tickets[i], tickets[k]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        I/P - tickets = [2,3,2], k = 2
        int[] tickets = new int[]{2, 3, 2};
        int k = 2;
        int res = new lc_2073().timeRequiredToBuy(tickets, k);
        System.out.println(res);
    }
}
