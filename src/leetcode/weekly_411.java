package leetcode;

import java.util.Arrays;

public class weekly_411 {
	public boolean isValidString(String s, int k) {
		int count_0 = 0;
		int count_1 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				count_0++;
			} else {
				count_1++;
			}
		}
		return count_1 <= k || count_0 <= k;
	}
	
	public int countKConstraintSubstrings(String s, int k) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (isValidString(s.substring(i, j), k)) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
		int n = energyDrinkA.length;
		long ans = 0;
		long[] pre_energyA = new long[n];
		long[] pre_energyB = new long[n];
		
		pre_energyA[n - 1] = energyDrinkA[n - 1];
		pre_energyB[n - 1] = energyDrinkB[n - 1];
		
		for (int i = n - 2; i >= 0; i--) {
			pre_energyA[i] = energyDrinkA[i] + pre_energyA[i + 1];
			pre_energyB[i] = energyDrinkB[i] + pre_energyB[i + 1];
		}
		System.out.println(Arrays.toString(pre_energyA) + "  -- " + Arrays.toString(pre_energyB));
		
		int i = 0;
		int j = 0;
		
		while (i < n && j < n) {
			if (pre_energyB[j] > pre_energyA[i]) {
				ans += energyDrinkB[j];
				j++;
			}
			i++;
			j++;
		}
		
		return ans;
	}
	
	// optimize solution
	public int countKConstraintSubstrings_optimal(String s, int k) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int count_0 = 0;
			int count_1 = 0;
			for (int j = i; j < n; j++) {
				if (s.charAt(j) == '0') {
					count_0++;
				} else {
					count_1++;
				}
				if (count_1 <= k || count_0 <= k) {
					ans++;
				} else {
					break;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		//Input: s = "10101", k = 1
		String s = "1010101";
		int k = 2;
		System.out.println(new weekly_411().countKConstraintSubstrings(s, k)); // Output: 12

//		Input: energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
		int[] energyDrinkA = new int[]{4, 1, 1};
		int[] energyDrinkB = new int[]{1, 1, 3};
		System.out.println();
		long res = new weekly_411().maxEnergyBoost(energyDrinkA, energyDrinkB);
		System.out.println(res); // Output: 5
		
	}
}
