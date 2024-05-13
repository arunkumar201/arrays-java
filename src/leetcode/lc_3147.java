package leetcode;

public class lc_3147 {
    public int maximumEnergy(int[] energy, int k) {
        int ans = Integer.MIN_VALUE;
        int n = energy.length;
        int[] prefixEnergy = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            prefixEnergy[i] = (i + k >= n ? 0 : prefixEnergy[i + k]) + energy[i];
            ans = Math.max(ans, prefixEnergy[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //Input:  energy = [5,2,-10,-5,1], k = 3
        int[] nums = new int[]{-2,-3,-1};
        int k = 2;
        int res = new lc_3147().maximumEnergy(nums, k);
        System.out.println(res);

    }
}
