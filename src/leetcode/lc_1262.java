package leetcode;

import java.util.*;

public class lc_1262 {
	public static void main(String[] args) {
		// Input: nums = [3,6,5,1,8]

		lc_1262 obj = new lc_1262();
		System.out.println("Approach 1");
		System.out.println(obj.maxSumDivThree_approach_1(new int[] { 3, 6, 5, 1, 8 }));

	}

	/**
	 * 
	 * @param nums
	 * @return
	 *         any number which is divisible by 3 always has a remainder of 0
	 *         any number which is not divisible by 3 always has a remainder of 1 or
	 *         2
	 * 
	 *         step - we will calculate the sum of all the numbers in the array
	 *         if sum%3==0 then ans will be sum;
	 * 
	 *         if sum%3==1 then
	 *         - we need to rm the a number or minimum number which has the
	 *         remainder of 1 if we are able find directly
	 *         - else we need to rm the two numbers or minimum numbers which has the
	 *         remainder of 2
	 *         as if we sum those num , their sum will be given the remainder of 1
	 *         eg. (3x+1)%3 = 1
	 *         if we have two number with remainder of 2 then
	 *         eg (3x+2)+(3y+2) = (3(x+y+1)+1)%3 = 1
	 *         if sum%3==2 then
	 *         - we need to rm the a number or minimum number which has the
	 *         remainder of 2 if we are able find directly
	 *         - else we need to rm the two numbers or minimum numbers which has the
	 *         remainder of 1
	 *         as if we sum those num , their sum will be given the remainder of 2
	 *         eg. (3x+2)%3 = 2
	 *         if we have two number with remainder of 1 then
	 *         eg (3x+1)+(3y+1) = (3(x+y)+2)%3 = 2
	 */
	public int maxSumDivThree_approach_1(int[] nums) {
		int total_sum = 0;

		// we need two arrays to store the numbers with remainder of 1 and 2
		List<Integer> remainder_1 = new ArrayList<>();
		List<Integer> remainder_2 = new ArrayList<>();

		// now lets store the numbers with remainder of 1 and 2 in the arrays
		for (int i = 0; i < nums.length; i++) {
			total_sum += nums[i];
			if (nums[i] % 3 == 1) {
				remainder_1.add(nums[i]);
			} else if (nums[i] % 3 == 2) {
				remainder_2.add(nums[i]);
			}
		}

		// if total_sum is divisible by 3 then return total_sum
		if (total_sum % 3 == 0) {
			return total_sum;
		}

		// as we are interested in maximum sum , we will sort the arrays as ascending
		// order
		remainder_1.sort((a, b) -> a - b);
		remainder_2.sort((a, b) -> a - b);

		// System.out.println("remainder_1 = " + remainder_1);
		// System.out.println("remainder_2 = " + remainder_2);

		int result = 0;
		if (total_sum % 3 == 1) {
			int num_with_remainder_1 = remainder_1.size() >= 1 ? remainder_1.get(0) : Integer.MAX_VALUE;
			int num_with_remainder_2 = remainder_2.size() >= 2 ? remainder_2.get(0) + remainder_2.get(1)
					: Integer.MAX_VALUE;
			result = Math.max(result, total_sum - Math.min(num_with_remainder_1, num_with_remainder_2));
		} else {
			int num_with_remainder_2 = remainder_2.size() >= 1 ? remainder_2.get(0) : Integer.MAX_VALUE;
			int num_with_remainder_1 = remainder_1.size() >= 2 ? remainder_1.get(0) + remainder_1.get(1)
					: Integer.MAX_VALUE;
			result = Math.max(result, total_sum - Math.min(num_with_remainder_2, num_with_remainder_1));
		}
		return result;
	}

	public int maxSumDivThree_approach_2(int[] nums) {
		int total_sum = 0;

		// as we only need minimum 2 minimal numbers with remainder of 1 and 2

		// we will track the minimal numbers with remainder of 1
		int min1_rem_1 = Integer.MAX_VALUE;
		int min2_rem_1 = Integer.MAX_VALUE;
		// we will track the minimal numbers with remainder of 2
		int min1_rem_2 = Integer.MAX_VALUE;
		int min2_rem_2 = Integer.MAX_VALUE;

		// in the final we need to make the total max sum has be to divisible by 3
		// so we will track the minimal numbers with remainder of 1 and 2

		for (int i = 0; i < nums.length; i++) {
			total_sum += nums[i];

			if (nums[i] % 3 == 1) {
				if (nums[i] < min1_rem_1) {
					min2_rem_1 = min1_rem_1;
					min1_rem_1 = nums[i];
				} else if (nums[i] < min2_rem_1) {
					min2_rem_1 = nums[i];
				}
			} else if (nums[i] % 3 == 2) {
				if (nums[i] < min1_rem_2) {
					min2_rem_2 = min1_rem_2;
					min1_rem_2 = nums[i];
				} else if (nums[i] < min2_rem_2) {
					min2_rem_2 = nums[i];
				}
			}
		}

		// if total_sum is divisible by 3 then return total_sum
		if (total_sum % 3 == 0) {
			return total_sum;
		}

		int result = 0;
		// now we will check the remainder of total_sum
		if (total_sum % 3 == 1) {
			int num_with_remainder_1 = min1_rem_1;

			int num_with_remainder_2 = (min1_rem_2 < Integer.MAX_VALUE && min2_rem_2 < Integer.MAX_VALUE)
					? min1_rem_2 + min2_rem_2
					: Integer.MAX_VALUE;
			
			result = total_sum - Math.min(num_with_remainder_1, num_with_remainder_2);
		} else {
			int num_with_remainder_2 = min1_rem_2;

			int num_with_remainder_1 = (min1_rem_1 < Integer.MAX_VALUE && min2_rem_1 < Integer.MAX_VALUE)
					? min1_rem_1 + min2_rem_1
					: Integer.MAX_VALUE;
			
			result = total_sum - Math.min(num_with_remainder_1, num_with_remainder_2);
		}
		return result;
	}
}
