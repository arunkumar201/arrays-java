package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc_1887 {
    public int reductionOperations(int[] nums) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        int res = 0;


        return 5;
    }


    public static void main(String[] args) {
//   nums = [5,1,3]
        int[] nums = new int[]{5,0, 3};
        int res = new lc_1887().reductionOperations(nums);
        System.out.println(res);
    }
}
