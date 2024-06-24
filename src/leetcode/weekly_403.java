package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class weekly_403 {

    public double minimumAverage(int[] nums) {
        double minAverage = Double.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int right = len - 1;
        int left = 0;
        while (right > left) {
            double average = (nums[right] + nums[left]) / 2.0;
            minAverage = Math.min(minAverage, average);
            right--;
            left++;
        }
        return minAverage;
    }

    public double minMaxAverage_pq(int[] nums) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            minPq.add(num);
            maxPq.add(num);
        }

        double minAverage = Double.MAX_VALUE;
        while (!minPq.isEmpty() && !maxPq.isEmpty()) {
            double average = (minPq.poll() + maxPq.poll()) / 2.0;
            minAverage = Math.min(minAverage, average);
        }

        return minAverage;
    }

    public static void main(String[] args) {
        //Input: nums = [7,8,3,4,15,13,4,1] - 5.5
        //Input: nums = [1,9,8,3,10,5] - 5.5
        //Input: nums = [1,2,3,7,8,9] - 5.0
        //[2,4,4,11,6,4,1,11,13,4,7,1]-4.0
        int[] nums = {2, 4, 4, 11, 6, 4, 1, 11, 13, 4, 7, 1};
        double res = new weekly_403().minMaxAverage_pq(nums);
        System.out.println(res);
    }
}
