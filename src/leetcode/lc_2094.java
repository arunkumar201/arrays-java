package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_2094 {
	public static void main(String[] args) {
		///Input: digits = [2,1,3,0]
		//Output: [102,120,130,132,210,230,302,310,312,320]
		
		int[] digits = {2, 1, 3, 0};
		lc_2094 solution = new lc_2094();
		System.out.println(Arrays.toString(solution.findEvenNumbers(digits)));
		
	}
	
	public int[] findEvenNumbers(int[] digits) {
		int n = digits.length;
		HashSet<Integer> evenNumbers = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			if (digits[i] == 0) continue;
			for (int j = 0; j < n; j++) {
				if (j == i) continue;
				for (int k = 0; k < n; k++) {
					if (k == i || k == j) continue;
					if (digits[k] % 2 != 0) {
						continue;
					}
					int num = digits[i] * 100 + digits[j] * 10 + digits[k];
					evenNumbers.add(num);
				}
			}
		}
		int[] result = new int[evenNumbers.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = evenNumbers.iterator().next();
			evenNumbers.remove(result[i]);
		}
		Arrays.sort(result);
		return result;
	}
}
