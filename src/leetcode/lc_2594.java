package leetcode;

public class lc_2594 {
	public static void main(String[] args) {
		int[] ranks = {4, 2, 3, 1};
		int cars = 10;
		System.out.println(new lc_2594().repairCars(ranks, cars)); // Output: 16
	}
	
	/*
	 Finds the maximum rank in the given array of mechanics ranks.
	 */
	public long getMaxRank(int[] ranks) {
		int n = ranks.length;
		long maxRank = ranks[0];
		for (int i = 1; i < n; i++) {
			if (ranks[i] > maxRank) {
				maxRank = ranks[i];
			}
		}
		return maxRank;
	}
	
	public boolean isPossible(int[] ranks, int cars, long time) {
		/*
		time=rank&cars^2
		cars=sqrt(time/rank)
		*/
		int n = ranks.length;
		long carFixed = 0;
		for (int rank : ranks) {
			carFixed += (long) Math.sqrt((double) time / rank);
		}
		return carFixed >= cars;
	}
	
	public long repairCars(int[] ranks, int cars) {
		int n = ranks.length;
		long left = 0;
		long maxRank = getMaxRank(ranks);
		long right = (long) maxRank * cars * cars;
		
		long ans = -1;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (isPossible(ranks, cars, mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
}