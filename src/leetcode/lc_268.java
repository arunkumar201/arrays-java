package leetcode;

public class lc_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total_sum = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total_sum - sum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int res = new lc_268().missingNumber(arr);
        System.out.println(res);
    }
}
