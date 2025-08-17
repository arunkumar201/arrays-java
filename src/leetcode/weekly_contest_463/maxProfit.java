package leetcode.weekly_contest_463;

public class maxProfit {
	
	public static void main(String[] args) {
		int[] prices1 = {4, 2, 8};
		int[] strategy1 = {-1, 0, 1};
		int k1 = 2;
		System.out.println(new maxProfit().maxProfit(prices1, strategy1, k1)); // 10
		
		int[] prices2 = {5, 4, 3};
		int[] strategy2 = {1, 1, 0};
		int k2 = 2;
		System.out.println(new maxProfit().maxProfit(prices2, strategy2, k2)); // 9
	}
	
	public long maxProfit(int[] prices, int[] strategy, int k) {
		int n = prices.length;
		long initialProfit = 0;
		
		for (int i = 0; i < n; i++) {
			initialProfit += (long) strategy[i] * prices[i];
		}
		
		// Step 2: prefix sum of old contributions (strategy[i] * prices[i])
		long[] prefixOld = new long[n + 1];
		for (int i = 0; i < n; i++) {
			prefixOld[i + 1] = prefixOld[i] + (long) strategy[i] * prices[i];
		}
		
		// Step 3: prefix sum of prices (to compute newContribution fast)
		long[] prefixPrices = new long[n + 1];
		for (int i = 0; i < n; i++) {
			prefixPrices[i + 1] = prefixPrices[i] + prices[i];
		}
		
		long bestGain = 0;
		int half = k / 2;
		for (int start = 0; start + k <= n; start++) {
			int mid = start + half;
			int end = start + k;
			
			long oldContribution = prefixOld[end] - prefixOld[start];
			
			long newContribution = prefixPrices[end] - prefixPrices[mid];
			
			long gain = newContribution - oldContribution;
			bestGain = Math.max(bestGain, gain);
		}
		
		return initialProfit + bestGain;
	}
	
	
}
