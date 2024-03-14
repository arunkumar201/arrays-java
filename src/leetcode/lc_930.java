package leetcode;

public class lc_930 {

    public int numSubarraysWithSum_BruteForce(int[] nums, int goal) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == goal) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int len = nums.length;
        int sum = nums[0];
        int left = 0;
        if (sum == goal) {
            res++;
        }
        for (int right = 1; right < len; right++) {
            sum += nums[right];
            while (sum > goal && left < right) {
                sum -= nums[left];
                left++;
            }
            if (sum == goal) {
                res++;
                int tempLeft = left;
                // Count all subarrays that have zeros between tempLeft and left
                while (tempLeft < right && nums[tempLeft] == 0) {
                    res++;
                    tempLeft++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int res = new lc_930().numSubarraysWithSum(nums, goal);
        System.out.println(res);
    }
}
