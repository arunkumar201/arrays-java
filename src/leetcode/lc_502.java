package leetcode;

import java.util.*;

public class lc_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int j = 0;
        // max heap - profits in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // sort by capital
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new int[]{capital[i], profits[i]});
        }

        // sort by capital  - ascending order
        arr.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < k; i++) {
            // add all projects that can be done with current capital w
            // and add them to the max heap  - max heap
            while (j < n && arr.get(j)[0] <= w) {
                pq.add(arr.get(j++)[1]);
            }
            if (pq.isEmpty()) break;
            //take the max Profit project and add it to the capital and remove it from the heap
            w += pq.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        lc_502 lc = new lc_502();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(lc.findMaximizedCapital(k, w, profits, capital));
    }
}