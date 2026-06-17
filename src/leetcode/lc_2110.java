package leetcode;

public class lc_2110 {
	
	public static void main(String[] args) {

		int[] prices = { 10, 8, 7, 6};
		lc_2110 lc = new lc_2110();
		System.out.println(lc.getDescentPeriods(prices));

	}
	
	public long getDescentPeriods(int[] prices) {
		long total = 0;
        int n=prices.length;
		int left = 0;
		int right = 0;


		while (right < n) {
			if (right == n - 1 || prices[right] - prices[right + 1] != 1) {
				int len = right - left + 1;
				total += (long) ((len * (len + 1)) / 2);
				left = right + 1;
			}
			right++;

		}
		
		return total;

	}
}
