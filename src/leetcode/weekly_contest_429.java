package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class weekly_contest_429 {
	
	public static void main(String[] args) {
		
		int[] a = new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7};
		System.out.println(new weekly_contest_429().minimumOperations(a));
		
		int[] b = new int[]{1, 2, 2, 3, 3, 4};
		int k = 2;
		System.out.println("max Distinct elements " + new weekly_contest_429().maxDistinctElements(b, k));
	}
	
	public int minimumOperations_bruteForce(int[] nums) {
		int res = 0;
		
		for (int i = 0; i < nums.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			int count = 0;
			for (int j = i; j < nums.length; j++) {
				if (set.contains(nums[j])) {
					count++;
				} else {
					set.add(nums[j]);
				}
			}
			set.clear();
			if (count >= 1) {
				i += 2;
				res++;
				
			}
		}
		
		return res;
	}
	
	public int minimumOperations(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int n = nums.length;
		int first_non_duplicate_index_from_last = -1;
		
		for (int i = n - 1; i >= 0; i--) {
			if (set.contains(nums[i])) {
				first_non_duplicate_index_from_last = i;
				break;
			}
			set.add(nums[i]);
		}
		if (first_non_duplicate_index_from_last == -1) {
			return 0;
		}
		first_non_duplicate_index_from_last++;
		int rem = first_non_duplicate_index_from_last % 3;
//		System.out.println("rem " + rem + "  fist_non_duplicate_index_from_last " + first_non_duplicate_index_from_last);
		
		return (rem == 0) ? first_non_duplicate_index_from_last / 3 : (first_non_duplicate_index_from_last / 3) + 1;
	}
	
	
	public int maxDistinctElements(int[] nums, int k) {
		int count = 0;
		int prevMax = Integer.MIN_VALUE;
		Arrays.sort(nums);
		
		for (int num : nums) {
			//calculate the range [num-k,num+k]
			
			/*below case
			  k=2;
			 as we have already sorted the array
			 - initially we have prevMax=-INT
			 1, 2, 2, 3, 3, 4
			 1 - [-1,3]
			 2-[0,4]
			 2-[0,4]
			 3 - [1,5]
			 4- [2,6]
			 
			 for each element
			    lb=num-k
			    ub=num+k
			    then checking
			    if lb<prevMax
			      prev=lb;
			      count++; //distinct count
			     else if prevMax<ub
			         prevMax++;
			         count++; //distinct count
			
			return count;
			 */
			int lowerBound = num - k;
			int upperBound = num + k;
			if (prevMax < lowerBound) {
				prevMax = lowerBound;
				count++;
			} else if (prevMax < upperBound) {
				prevMax++;
				count++;
			}
			
		}
		
		return count;
	}
}