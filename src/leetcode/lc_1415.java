package leetcode;

import java.util.Arrays;

public class lc_1415 {
	
	public static void main(String[] args) {
//		Input: n = 1, k = 3
		int n = 1;
		int k = 3;
		System.out.println(new lc_1415().getHappyString_bruteForce(n, k));
	}
	
	public String getHappyString_bruteForce(int n, int k) {
		String[] strings = generateStringsOfSizeN(n, k, "abc");
		System.out.println(Arrays.toString(strings));
		Arrays.sort(strings);
		return strings[0];
		
	}
	
	public String[] generateStringsOfSizeN(int n, int k, String srcString) {
		String[] result = new String[n];
		
		if (n == 0) {
			return result;
		}
		for (int i = 0; i < n; i++) {
//			result[i] = generateStringOfSizeN(n,k,srcString);
		}
		
		return result;
	}
}
