package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc_1913 {

    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }

    //    using Priority Queue
    public int maxProductDifference_PriorityQueue(int[] nums) {
        int n = nums.length;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }

        return firstMax * secondMax - secondMin * firstMin;
    }

    public static void main(String[] args) {
        //Input: nums = [5,6,2,7,4]
        int[] nums = new int[]{5, 6, 2, 7, 4};
        int res = new lc_1913().maxProductDifference(nums);
        int resPq = new lc_1913().maxProductDifference_PriorityQueue(nums);
        System.out.println(resPq);
        System.out.println(res);
    }
}
