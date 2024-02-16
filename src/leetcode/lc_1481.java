package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc_1481 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        // Step 3: Sort the entries of the HashMap based on their frequencies
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        pq.addAll(mp.entrySet());

        int uniqueCount = mp.size();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int frequency = entry.getValue();

            if (k >= frequency) {
                k -= frequency;
                uniqueCount--;
            } else {
                break;
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        int res = findLeastNumOfUniqueInts(arr, k);
        System.out.println(res);
    }
}
