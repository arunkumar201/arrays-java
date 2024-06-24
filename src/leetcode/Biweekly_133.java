package leetcode;

import java.util.Stack;

public class Biweekly_133 {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int ones = 0, twos = 0;
        for (int i = 0; i < n; i++) {

            int remainder = nums[i] % 3;
            if (remainder == 1) {
                ones++;
            } else if (remainder == 2) {
                twos++;
            }
        }
        ans = ones + twos;
        return ans;
    }

    public int minOperations_Medium_1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i + 2 < n) {
                    nums[i] = 1;
                    nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                    nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                    ans++;
                } else {
                    return -1;
                }
            }
        }

        return ans;
    }

    public int minOperations_BruteForce(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int x = n - 1;
        //want to combine all consecutive 0's and 1's
        while (x >= 0) {
            while (x > 0 && nums[x] == nums[x - 1]) {
                x--;
            }
            stack.push(x);
            x--;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = nums[stack.pop()];
        }
        n = arr.length;
        for (i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = i; j < n; j++) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
                ans++;
            }
        }
        return ans;
    }

    int minOperations(int[] nums) {
        int flag = 1;
        int count = 0, n = nums.length;
        for (int num : nums) {
            if (num != flag) {
                count++;
                flag = flag == 0 ? 1 : 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //Input: nums = [1,2,3,4]
        //Output: 3
        int[] nums = new int[]{3, 6, 9, 17, 41, 51};
        int res = new Biweekly_133().minimumOperations(nums);
        System.out.println(res);

        int[] arr = new int[]{0, 1, 1, 0, 1};
        //[1,0,1,1,1,0,1,0,0,0] ans =5
        int res1 = new Biweekly_133().minOperations(arr);
        System.out.println("res1 :- " + res1);
    }

}
