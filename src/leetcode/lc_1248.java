package leetcode;

public class lc_1248 {
    public int numberOfSubarrays_BruteForce(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 1) {
                    oddCount++;
                }
                if (oddCount == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        int left = 0;
        int right = 0;

        int count = 0;
        while (right < n) {
            if (nums[right] % 2 == 1) {
                k--;
                count = 0;
            }
            while (k == 0) {
                if (nums[left] % 2 == 1) {
                    k++;
                }
                left++;
                count++;
            }
            ans += count;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //Input: nums = [1,1,2,1,1], k = 3
        int[] nums = new int[]{2, 4, 6};
        int k = 1;
        int res = new lc_1248().numberOfSubarrays_BruteForce(nums, k);
        System.out.println("Num of Subarrays: numberOfSubarrays_BruteForce- " + res);
    }
}

