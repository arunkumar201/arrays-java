public class lc_1523 {
	

	public static void main(String[] args) {
		// Input: low = 3, high = 7
		lc_1523 lc = new lc_1523();
		System.out.println(lc.countOdds(3, 7));
	}
	
	public int countOdds_optimal(int low, int high) {
		boolean isLowOdd = low % 2 == 1;
		boolean isHighOdd = high % 2 == 1;

		int bet_count = (high - low) / 2;

		if (isLowOdd || isHighOdd) {
			return bet_count + 1;
		}

		return bet_count;
	}
	
	public int countOdds(int low, int high) {
		int odd_count = 0;

		boolean isOdd = false;
		while (low <= high) {
			isOdd = low % 2 == 0 ? false : true;
			odd_count += isOdd ? 1 : 0;
			if (isOdd) {
				low += 2;
			} else {
				low++;
			}
		}
		return odd_count;
	}
}
