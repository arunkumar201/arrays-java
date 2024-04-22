import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc_448 {
    public List<Integer> findDisappearedNumbers_usingExtraSpace(int[] nums) {
        List<Integer> res = new java.util.ArrayList<>();
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new java.util.ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new lc_448().findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
