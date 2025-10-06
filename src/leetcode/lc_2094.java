package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc_2094 {
	public static void main(String[] args) {
		/// Input: digits = [2,1,3,0]
		// Output: [102,120,130,132,210,230,302,310,312,320]

		int[] digits = { 2, 1, 3, 0 };
		lc_2094 solution = new lc_2094();
		System.out.println(Arrays.toString(solution.findEvenNumbers(digits)));
		System.out.println("Optimal");
		System.out.println(Arrays.toString(solution.findEvenNumbers_optimal(digits)));

	}

	public int[] findEvenNumbers_optimal(int[] digits) {
		int[] counter = new int[10];
		List<Integer> evenDigits = new ArrayList<>();

		// store the count of each digits
		for (int d : digits) {
			counter[d]++;
		}

		// generate all possible numbers
		// will start from 100 to 999
		for (int i = 1; i < 10; i++) {

			if (counter[i] == 0)
				continue;
			counter[i]--;
			for (int j = 0; j < 10; j++) {
				if (counter[j] == 0)
					continue;
				counter[j]--;

				// only include even digits
				for (int k = 0; k < 10; k += 2) {
					if (counter[k] == 0)
						continue;
					// construct the number
					int num = i * 100 + j * 10 + k;
					evenDigits.add(num);
				}
				// restored the digits for next iteration
				counter[j]++;
			}
			counter[i]++;
		}

		int[] ans = new int[evenDigits.size()];
		for (int i = 0; i < evenDigits.size(); i++) {
			ans[i] = evenDigits.get(i);

		}
		return ans;
	}

	public int[] findEvenNumbers(int[] digits) {
		int n = digits.length;
		HashSet<Integer> evenNumbers = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (digits[i] == 0)
				continue;
			for (int j = 0; j < n; j++) {
				if (j == i)
					continue;
				for (int k = 0; k < n; k++) {
					if (k == i || k == j)
						continue;
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
