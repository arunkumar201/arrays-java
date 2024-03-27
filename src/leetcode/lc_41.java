package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc_41 {
    public int firstMissingPositive_sort(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num == res) {
                res++;
            } else if (num > 0) {
                break;
            }
        }
        return res;
    }

    public int firstMissingPositive_set(int[] nums) {
        //Time Complexity: O(N)
        //Space Complexity: O(N)
        //We know the the smallest positive integer  value ranges
        // from the 1 to len+1 always,
        //so we can convert the array to hashset and iterate the loop
        // from 1 to len+1 and return the first missing number
        int len = nums.length;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= len + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return res;
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //Iterate the nums and replace all negative to zero as -ve never be in the
        // solution set [1,...,len+1] and as we are replacing to zero that also not part of the
        //solution set
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        for(int i=0;i<len;i++){
            int val = Math.abs(nums[i]) ;
            if(val>=1 && val<=len){
              if(nums[val-1]>0){
                  nums[val-1] = -nums[val-1];
              }else if(nums[val-1]==0){
                  nums[val-1]=-1*(len+1);
            }
        }
        }
        System.out.println(Arrays.toString(nums));
        for(int i=1;i<=len;i++){
            if(nums[i-1]>=0){
                return i;
            }

        }

        return len + 1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,0};
        int res = new lc_41().firstMissingPositive(arr);
        System.out.println(res);
    }
}
