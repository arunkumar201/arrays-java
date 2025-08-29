package leetcode;

public class lc_3021 {
	public static void main(String[] args) {
		//Input: n = 3, m = 2
		int n = 3;
		int m = 2;
		lc_3021 sol = new lc_3021();
		long result = sol.flowerGame_bruteForce(n, m);
		System.out.println("Brute Force Result " + result);
		result = sol.flowerGame_Optimized(n, m);
		System.out.println("Optimized result " + result);
		
		
	}
	
	public long flowerGame_bruteForce(int n, int m) {
		long result = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if ((i + j) % 2 != 0) {
					result++;
				}
			}
		}
		return result;
	}
	
	public long flowerGame_Optimized(int n, int m) {
		long result = 0;
		
		// number of even values in lane 1 (1..n)
		long lane_1_even = n / 2;
		
		// number of odd values in lane 2 (1..m)
		long lane_2_odd = (m + 1) / 2;
		
		// case 1: (even from lane 1, odd from lane 2) => odd sum
		result += lane_1_even * lane_2_odd;
		
		// number of even values in lane 2 (1..m)
		long lane_2_even = m / 2;
		
		// number of odd values in lane 1 (1..n)
		long lane_1_odd = (n + 1) / 2;
		
		// case 2: (odd from lane 1, even from lane 2) => odd sum
		result += lane_2_even * lane_1_odd;
		
		return result;
	}
	
}
