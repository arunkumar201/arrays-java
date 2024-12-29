package leetcode;

public class lc_338 {
	
	public static void main(String[] args) {
		int n = 5;
		int[] res = new lc_338().countBits_dp(n);
		for (int num : res) {
			System.out.print(num + " ");
		}
		
	}
	
	//using dp
	
	public int[] countBits_dp(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = dp[i / 2] + (i & 1);
		}
		return dp;
	}
	
	public int getSetBits(int n) {
		if (n <= 1) return n;
		int count = 0;
		
		while (n != 0) {
			count += (n & 1);
			n = n / 2; //n=n>>1 (left shift by 1 eq to n=n/2;
		}
		return count;
		
	}
	
	public int getSetBits_1(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}
	
	public int[] countBits_countSetBits(int n) {
		int[] result = new int[n + 1];
		
		//    0 0 1 0 0
		//    0 0 0 1 1
		// &=>0 0 1 0 0
		
		//so we can n & (n-1)
		for (int i = 0; i <= n; i++) {
//			result[i] = getSetBits(i);
			result[i] = Integer.bitCount(i);
		}
		return result;
		
	}
}
