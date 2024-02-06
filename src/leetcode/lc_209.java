package leetcode;

public class lc_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 1;
        int sum = nums[0];

        if (sum >= target) {

            return 1;
        }

        while (j < len) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static int minSubArrayLen_BruteForce(int target, int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    System.out.println(i + " " + j);
                    minLen = Math.min(j - i + 1, minLen);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4};
        int target = 4;

        int res = minSubArrayLen(target, nums);
        System.out.println(res);

    }
}
