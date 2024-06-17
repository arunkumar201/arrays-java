package leetcode;

public class lc_330 {

    public int minPatches(int[] nums, int n) {
        // Initialize the number of patches needed to 0
        int res = 0;

        // Initialize the smallest missing sum in the range [1,n] to 1
        long miss = 1;

        // Initialize the index of the array to 0
        int i = 0;

        // Continue the loop until the smallest missing sum is greater than n
        while (miss <= n) {
            // If the current index is within the array bounds and the current array element is less than or equal to the smallest missing sum,
            // it means we can form the sum 'miss' by using the current element, so add the current element to the smallest missing sum and move to the next element
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                // If the current array element is greater than the smallest missing sum or we have used all elements of the array,
                // we need to patch the array with the number 'miss'. So, double the smallest missing sum and increment the number of patches
                miss += miss;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Input: nums = [1,3], n = 6
        //Output: 1
        int[] nums = new int[]{1};
        int n = 20;
        int res = new lc_330().minPatches(nums, n);
        System.out.println(res);
    }
}
