package leetcode;

import java.util.*;

public class lc_506 {
    public String[] findRelativeRanks_BruteForce(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        int n = score.length;
        for (int i = 0; i < n; i++) {
            int num = score[i];
            map.put(num, i);
            pq.add(num);
        }
        String[] res = new String[n];
        int i = 0;
        while (!pq.isEmpty()) {
            int value = map.get(pq.peek());
            System.out.println(value);
            if (i == 0) {
                res[value] = "Gold Medal";
            } else if (i == 1) {
                res[value] = "Silver Medal";

            } else if (i == 2) {
                res[value] = "Bronze Medal";
            } else {
                res[value] = Integer.toString(i + 1);
            }
            pq.poll();
            i++;
        }
        return res;
    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
            arr[i] = score[i];
        }

        Arrays.sort(arr);
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            int index = map.get(arr[i]);
            System.out.println(index);
            if (j == 0) {
                res[index] = "Gold Medal";
            } else if (j == 1) {
                res[index] = "Silver Medal";
            } else if (j == 2) {
                res[index] = "Bronze Medal";
            } else {
                res[index] = Integer.toString(j + 1);
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] score = new int[]{10, 3, 8, 9, 4};
        String[] res = new lc_506().findRelativeRanks(score);
        System.out.println(Arrays.toString(res));

    }
}
