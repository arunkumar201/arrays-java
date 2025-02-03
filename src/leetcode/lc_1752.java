package leetcode;

public class lc_1752 {
	
	public static void main(String[] args) {
		//Input: nums = [3,4,5,1,2]
		int[] nums = {3, 4, 5, 1, 2};
		System.out.println(new lc_1752().check_optimized_2(nums));
		
	}
	
	
	public boolean isSorted(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean check_bruteForce(int[] nums) {
		int n = nums.length;
		int[] rotatedArr = new int[n];
		
		//let's rotate the array in all possible points
		for (int i = 0; i < n; i++) {
			int index = 0;
			//copy the curr arr item from i+1 to n-1 into the rotatedArr
			for (int j = i + 1; j < n; j++) {
				rotatedArr[index++] = nums[j];
			}
//			System.out.println("shift the items from " + i + " position " + Arrays.toString(rotatedArr));
			
			//now copy res of the items
			for (int k = 0; k <= i; k++) {
				rotatedArr[index++] = nums[k];
			}
//			System.out.println("after rotation on " + Arrays.toString(rotatedArr));
			
			if (isSorted(rotatedArr)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean check_optimized(int[] nums) {
		int n = nums.length;
		int rotation = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > nums[(i + 1) % n]) {
				rotation++;
			}
			if (rotation > 1) return false;
		}
		return true;
	}
	
	public boolean check(int[] nums) {
		int n = nums.length;
		
		int first_comp = -1;
		for (int i = 0; i < n; i++) {
			if (nums[i] > nums[(i + 1) % n]) {
				first_comp = i;
				break;
			}
			
		}
		
		if (first_comp == -1) {
			return true;
		}
		
		int second_comp = -1;
		for (int i = first_comp; i < n; i++) {
			if (nums[i] < nums[(i + 1) % n]) {
				second_comp = i;
				break;
			}
		}
		
		return second_comp != -1;
		
	}
	
	public boolean check_optimized_2(int[] nums) {
		int n = nums.length;
		int count = 1;
		for (int i = 0; i < n * 2; i++) {
			if (nums[i % n] <= nums[(i + 1) % n]) {
				count++;
			} else {
				count = 1;
			}
			if (count == n) {
				return true;
			}
			
		}
		return n == 1;
	}
}
