package leetcode;

public class lc_2698 {
	
	public static void main(String[] args) {
		//	Input: n = 10
		int n = 37;
		System.out.println(new lc_2698().punishmentNumber_bruteForce(n));
		
		
	}
	
	public int punishmentNumber_bruteForce(int n) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int square = i * i;
			if (isPartitionValid(square, i)) {
				ans += square;
			}
		}
		return ans;
	}
	
	public boolean isPartitionValid(int num, int i) {
		String numStr = String.valueOf(num);
		return canPartition(numStr, 0, i);
	}
	
	private boolean canPartition(String numStr, int start, int target) {
		if (start == numStr.length()) {
			return target == 0;
		}
		
		int currentNumber = 0;
		for (int end = start; end < numStr.length(); end++) {
			currentNumber = currentNumber * 10 + (numStr.charAt(end) - '0');
			if (currentNumber > target) {
				break;
			}
			if (canPartition(numStr, end + 1, target - currentNumber)) {
				return true;
			}
		}
		return false;
	}
	
}
