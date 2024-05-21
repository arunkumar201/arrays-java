package leetcode;

public class lc_3151 {

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Input: nums = [1]
        int[] nums = new int[]{3, 4, 1, 2};
        boolean res = new lc_3151().isArraySpecial(nums);
        System.out.println(res);
    }
}
