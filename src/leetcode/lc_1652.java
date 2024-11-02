package leetcode;

import java.util.Arrays;

public class lc_1652 {
	
	public int[] decrypt(int[] code, int k) {
		int n = code.length;
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			
			if (k == 0) {
				result[i] = 0;
				continue;
			} else if (k > 0) {
				for (int j = 1; j <= k; j++) {
					sum += code[(i + j) % n];
				}
			} else {
				for (int j = 1; j <= Math.abs(k); j++) {
					sum += code[(i - j + n) % n];
				}
			}
			result[i] = sum;
		}
		
		return result;
		
	}
	
	public int[] decrypt_slidingWindow(int[] code, int k) {
		int n = code.length;
		int[] result = new int[n];
		
		if (k == 0) {
			return result;
		}
		
		int sum = 0;
		int start, end;
		
		if (k > 0) {
			for (int i = 1; i <= k; i++) {
				sum += code[i % n];
			}
			start = 1;
			end = k;
		} else {
			for (int i = 1; i <= Math.abs(k); i++) {
				sum += code[(n - i) % n];
			}
			start = n - Math.abs(k);
			end = n - 1;
		}
		
		for (int i = 0; i < n; i++) {
			result[i] = sum;
			sum -= code[start % n];
			start++;
			end++;
			sum += code[end % n];
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] code = {2, 4, 9, 3};
		int k = -2;
		System.out.println(Arrays.toString(new lc_1652().decrypt(code, k))); // Output: [12,10,16,13]
	}
	
}
