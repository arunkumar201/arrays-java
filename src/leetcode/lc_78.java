package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                System.out.println(res.get(i));
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Input: nums = [1,2,3]

        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new lc_78().subsets(nums);
        System.out.println(res);
    }
}
