package leetcode;

public class lc_75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[k++] = i;
                count[i]--;
            }
        }
    }

    //optimal solution
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors_optimal(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 1};
        new lc_75().sortColors_optimal(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}
