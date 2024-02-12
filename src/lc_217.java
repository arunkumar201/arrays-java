import java.util.Arrays;
import java.util.HashSet;

public class lc_217 {
//below solution use set
    //time complexity O(n)
    //space complexity O(n)
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;

    }

        //we can also solve by sorting the array
    //then we can compare adjacent elements and return true if they are equal
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean res = containsDuplicate(nums);
        System.out.println(res);
    }
}
