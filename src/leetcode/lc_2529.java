package leetcode;

public class lc_2529 {

    public int maximumCount(int[] nums) {
        int res = 0;
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        res = Math.max(pos, neg);
        return res;
    }

    public static void main(String[] args) {
//        nums = [-2,-1,-1,1,2,3]

        int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
        int res = new lc_2529().maximumCount(nums);
        System.out.println(res);
    }
}
