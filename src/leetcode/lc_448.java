package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc_448 {
    //    using set dsa
    public List<Integer> findDisappearedNumbers_Set(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        Input: nums = [4,3,2,7,8,2,3,1]

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new lc_448().findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
