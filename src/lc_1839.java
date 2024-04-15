import java.util.Arrays;
import java.util.HashMap;

public class lc_1839 {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int max_count = 0;

        for (int right = 0; right < n; right++) {
            total += nums[right];
            while ((long) nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }
            max_count = Math.max(max_count, right - left + 1);
        }
        return max_count;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 4};
        int k = 5;
        System.out.println(new lc_1839().maxFrequency(arr, k));
    }
}
