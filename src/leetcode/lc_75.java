package leetcode;

public class lc_75 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 1};
		new lc_75().sortColors_optimal(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
	}
	
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
	
	public void swap_helper(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	// O(n) time, O(1) space
	public void sortColors_latest(int[] nums) {
		int n = nums.length;
		int low = 0; // Pointer to track the position to place 0s
		int high = n - 1; // Pointer to track the position to place 2s
		int i = 0; // Current index
		
		// The loop runs while 'i' is less than or equal to 'high' because elements at and after 'i' may still be unsorted.
		// Even when i == high, we must check the value at that index, as it might be 0 or 2 and need to be moved.
		// The goal is to ensure:
		// - All 0s are moved to the left (starting from index 0)
		// - All 2s are moved to the right (towards the end of the array)
		// - All 1s remain in the middle (automatically fall into place)
		while (i <= high) {
			
			if (nums[i] == 0) {
				// Case 1: Current element is 0
				// Swap with element at 'low' index and move both 'i' and 'low' forward
				swap_helper(nums, i, low);
				low++;
				i++;
			} else if (nums[i] == 2) {
				// Case 2: Current element is 2
				// Swap with element at 'high' index and move 'high' backward
				// Do not increment 'i' because the new element at 'i' needs to be checked again
				swap_helper(nums, i, high);
				high--;
			} else {
				// Case 3: Current element is 1
				// No action needed; just move to the next element
				i++;
			}
		}
	}
}
