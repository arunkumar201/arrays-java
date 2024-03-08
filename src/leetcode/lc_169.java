package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class lc_169 {

    public int majorityElement_sorting(int[] nums) {
        //Time Complexity: O(NLogN)
        //Space Complexity: O(1)
        //Middle elements always exists in the middle of the array once it got sorted in ascending order or descending order
        //return nums[nums.length / 2];

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement_hashmap(int[] nums) {
        //Time Complexity: O(N)
        //Space Complexity: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = n / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) >= max) {
                return num;
            }
        }
        return -1;
    }

    //using Moore Voting Algorithm
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new lc_169().majorityElement(nums));
    }
}