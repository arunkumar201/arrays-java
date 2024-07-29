package leetcode;

public class weekly_408 {
	public boolean canAliceWin(int[] nums) {
		int aliceSingleDigitSum = 0;
		int aliceDoubleDigitSum = 0;
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
			if (num < 10) {
				aliceSingleDigitSum += num;
			} else {
				aliceDoubleDigitSum += num;
			}
		}
		int maxSumAliceCan = Math.max(aliceSingleDigitSum, aliceDoubleDigitSum);
		
		int remaining = totalSum - maxSumAliceCan;
		return maxSumAliceCan > remaining;
	}
	
	public boolean isSpecial(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			int divisor = num % i;
			if (divisor == 0) {
				if (i != num) {
					count++;
				}
			}
		}
		return count == 2;
	}
	
	
	public int nonSpecialCount(int l, int r) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (!isSpecial(i)) {
				count++;
			}
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		//Input: nums = [1,2,3,4,10]
		int[] nums = new int[]{1, 2, 3, 4, 10};
		System.out.println(new weekly_408().canAliceWin(nums)); //Output: true
		
		//Input: l = 5, r = 7
		int l = 4;
		int r = 16;
		int res1 = new weekly_408().nonSpecialCount(l, r); //3
		System.out.println("count of nonSpecialCount " + res1);
		
		
	}
}
