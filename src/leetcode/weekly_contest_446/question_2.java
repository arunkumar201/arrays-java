package leetcode.weekly_contest_446;

public class question_2 {
	
	
	public static void main(String[] args) {
		//Input: nums = [4,2,5,3,5]
		//Output: 3
		int[] nums = {4, 2, 5, 3, 5};
		System.out.println(new question_2().maximumPossibleSize(nums));
		
	}
	
	public int maximumPossibleSize(int[] nums) {
		int n = nums.length;
		int count = 0;
		int right = 1;
		int left = 0;
		
		//sliding window
		while (left < n) {
			int current = nums[left];
			System.out.println(current+"----- "+left+" "+right);
			while (right < n && nums[right] < current) {
				System.out.println("while loop");
				right++;
			}
			count++;
			left = right;
			right++;
			
		}
		return count;
		
	}
}
