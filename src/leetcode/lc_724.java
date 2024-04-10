package leetcode;

public class lc_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) sum += num;
        int curr_sum = 0;
        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];
            if ((curr_sum - nums[i]) == (sum - curr_sum)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] height = new int[]{2,1,-1};
        int res = new lc_724().pivotIndex(height);
        System.out.println(res);
    }
}