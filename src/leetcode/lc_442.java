package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc_442 {
    public List<Integer> findDuplicates_Set(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                res.add(num);
            }
            set.add(num);
        }
        return res;

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //get the index , the element correspond to it
            int index = Math.abs(nums[i]) - 1;
            //if the element is negative, it is duplicate, or we have seen it before
            //we will add it to our resulting  list
            if (nums[index] < 0) {
                res.add(index + 1);
            } else {
                //mark the element as visited
                //or flip the number at index to negative
                nums[index] = -nums[index];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new lc_442().findDuplicates(arr));
    }
}
