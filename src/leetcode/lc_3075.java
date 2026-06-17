package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        long maximumHappinessSum = 0;

        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // for (int num : happiness) {
        // maxHeap.add(num);
        // }

        Arrays.sort(happiness);
        int x = 0;
        int i = happiness.length - 1;
        while (i >= 0 && k > 0) {
            int maxHappiness = happiness[i] - x;
            if (maxHappiness > 0) {
                maximumHappinessSum += maxHappiness;
            }
            k--;
            x++;
            i--;
        }

        return maximumHappinessSum;
    }

    // Using max Priority Queue
    public long maximumHappinessSum_PriorityQueue(int[] happiness, int k) {
        long ans = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int value : happiness) {
            pq.add(value);
        }
        System.out.println(pq);
        while (!pq.isEmpty() && k > 0) {
            int x = Math.max(pq.poll() - count, 0);
            if (x > 0) {
                ans += x;
                count++;
            }
            k--;
        }
        return ans;
    }

    // Using Min Priority Queue
    public long maximumHappinessSum1(int[] happiness, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int happy : happiness) {
            heap.add(happy);
            if (heap.size() > k)
                heap.poll();
        }
        long ans = 0;
        while (k > 0) {
            ans += Math.max(heap.poll() - (k - 1), 0);
            k--;
        }
        return ans;
    }

    public long maximumHappinessSum_2(int[] happiness, int k) {
        long maximumHappinessSum = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : happiness) {
            maxHeap.add(num);
        }

        int x = 0;
        while (k > 0 && maxHeap.size() > 0) {
            int maxHappiness = maxHeap.poll();
            if (maxHappiness - x > 0) {
                maximumHappinessSum += maxHappiness - x;
            }
            k--;
            x++;
        }

        return maximumHappinessSum;
    }

    public static void main(String[] args) {
        // Input: happiness = [1,2,3], k = 2

        int[] nums = new int[] { 2, 3, 4, 5 };
        int k = 1;
        long res = new lc_3075().maximumHappinessSum_PriorityQueue(nums, k);
        System.out.println(res);

    }
}
