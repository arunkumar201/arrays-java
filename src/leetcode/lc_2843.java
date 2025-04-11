package leetcode;

public class lc_2843 {
	
	
	public static void main(String[] args) {
		//low=1 and high=100
		int low = 1;
		int high = 100;
		System.out.println(new lc_2843().countSymmetricIntegers(low, high));
		
	}
	
	public int countSymmetricIntegers_BruteForce(int low, int high) {
		int count = 0;
		for (int i = low; i <= high; i++) {
			String current = Integer.toString(i);
			int len = current.length();
			if (len % 2 == 0) {
				int half = len / 2;
				String left = current.substring(0, half);
				String right = current.substring(half);
				int sumOfFirstHalfSum = 0;
				int sumOfSecondHalfSum = 0;
				for (int j = 0; j < half; j++) {
					sumOfFirstHalfSum += Integer.parseInt(left.charAt(j) + "");
					sumOfSecondHalfSum += Integer.parseInt(right.charAt(j) + "");
				}
				if (sumOfFirstHalfSum == sumOfSecondHalfSum) {
					count++;
				}
			}
		}
		return count;
	}
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public int countSymmetricIntegers(int low, int high) {
		int count = 0;
		for (int i = low; i <= high; i++) {
			int len = String.valueOf(i).length();
			int currentNum = i;
			int mid = len / 2;
			int leftSum = 0;
			int rightSum = 0;
			if (len % 2 != 0) continue;
			
			// Sum first half digits
			for (int j = 0; j < mid; j++) {
				leftSum += currentNum % 10;
				currentNum /= 10;
			}
			
			// Sum second half digits
			for (int j = 0; j < mid; j++) {
				rightSum += currentNum % 10;
				currentNum /= 10;
			}
			
			if (leftSum == rightSum) {
				count++;
			}
		}
		return count;
	}
}
