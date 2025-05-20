package leetcode;

public class lc_3355 {
	
	public static void main(String[] args) {
		//Input: nums = [1,0,1], queries = [[0,2]]
		//Output: true
		
		lc_3355 solution = new lc_3355();
		boolean result = solution.isZeroArray_bruteForce(new int[]{1, 0, 1}, new int[][]{{0, 2}});
		System.out.println("Result: " + result);
		System.out.println("----optimization----");
		result = solution.isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}});
		System.out.println("Result: " + result);
		
	}
	
	
	public boolean isZeroArray(int[] nums, int[][] queries) {
		int n = nums.length;
		int[] count = new int[n];
		/*
		  if we have arr =[1,2,3,4,5,6,7,8,9,10]
		  and we have queries = [[0,2,1],[3,5,4],[6,9,8],[7,10,9]]
		  [start,end,affected(value)]
		  we have to update the arr based on the queries
		  //Introduction | What | How | Difference Array Technique: Concepts
		  //we use array diff technique to solve this problem
		  int[] diff = new int[n];
		  for each query we have to update the arr
		      int start = query[0];
		      int end = query[1];
		      int affected = query[2];
		      diff[start]++;
		      //then we have update the just after end element
		      if (end + 1 < n) {
		        diff[end + 1]-=affected(item);
		      }
		      }
		        //commutative sum
		        for (int i = 1; i < n; i++) {
		          diff[i] += diff[i - 1];
		        }
		        //now diff array contains the effects or operations that we have to do in the array
		        
		        //check if possible to make all elements zero
		        for (int i = 0; i < n; i++) {
		          if (diff[i] < nums[i]) {
		            return false;
		          }
		        }
		    return true;
		
		 */
		
		for (int[] query : queries) {
			int start = query[0];
			int end = query[1];
			count[start]++;
			if (end + 1 < n) {
				count[end + 1]--;
			}
		}
		
		//commutative sum
		for (int i = 1; i < n; i++) {
			count[i] += count[i - 1];
		}
		//check if possible to make all elements zero
		for (int i = 0; i < n; i++) {
			if (count[i] < nums[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isZeroArray_bruteForce(int[] nums, int[][] queries) {
		int n = nums.length;
		for (int[] query : queries) {
			int start = query[0];
			int end = query[1];
			
			for (int j = start; j <= end && j < n; j++) {
				nums[j] = nums[j] == 0 ? 0 : nums[j] - 1;
			}
		}
		//Check if all elements are zero
		for (int num : nums) {
			if (num != 0) {
				return false;
			}
		}
		return true;
		
		
	}
}
