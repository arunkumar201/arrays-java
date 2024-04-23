package leetcode;

import java.util.*;

public class lc_1887 {
    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            pq.add(num);
            set.add(num);
        }
        System.out.println(pq);
        return count;
    }

    public int reductionOperations_sorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        System.out.println(Arrays.toString(nums));
        int count = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] == nums[i - 1]) continue;
            System.out.println(n - i);
            count += n - i;
        }
        return count;
    }

    public int reductionOperations2(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];
        for (int num : nums) {
            freq[num]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
            }
        }
        return res;
    }

    public static voi¡d main(String[] args) {
//   nums = [5,1,3]
        int[] nums = new int[]{5, 1, 3};
//        int res = new lc_1887().reductionOperations(nums);
//        System.out.println(res);
        int res1 = new lc_1887().reductionOperations2(nums);
        System.out.println(res1);
    }
}
