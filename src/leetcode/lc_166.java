package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_166 {

	public static void main(String[] args) {
		// Input: numerator = 1, denominator = 2
		lc_166 sol = new lc_166();
		System.out.println(sol.fractionToDecimal(1, 2)); // 0.5
		System.out.println(sol.fractionToDecimal(7, 963)); // "0.(00726895119418483904465212876427829698857736240913811)"
		System.out.println(sol.fractionToDecimal(2, 1)); // 2

	}

	public String getRepeatingPart(String fraction) {
		return "";
	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		boolean isNegative = numerator < 0 ? true : false;
		boolean isDenominatorNegative = denominator < 0 ? true : false;
		if (isNegative) {
			numerator *= -1;
		}
		if (isDenominatorNegative) {
			denominator *= -1;
		}
		

		int integerPart = numerator / denominator;
		result.append(integerPart).append('.');

		// Map remainder -> index in decimalPart
		Map<Integer, Integer> remainderMap = new HashMap<>();
		int remainder = numerator % denominator;

		StringBuilder decimalPart = new StringBuilder();
		int index = 0;

		while (remainder != 0 && !remainderMap.containsKey(remainder)) {
			remainderMap.put(remainder, index);

			remainder *= 10;
			int digit = remainder / denominator;
			decimalPart.append(digit);
			remainder = remainder % denominator;
			index++;
		}

		if (remainder == 0) {
			result.append(decimalPart);
		} else {
			int repeatIndex = remainderMap.get(remainder);
			String repeatingPart = decimalPart.substring(repeatIndex);
			String nonRepeatingPart = decimalPart.substring(0, repeatIndex);
			result.append(nonRepeatingPart).append('(').append(repeatingPart).append(')');
		}

		if (remainderMap.size() == 0) {
			result.deleteCharAt(result.length() - 1);
		}

		//if both are negative then make it positive else if anyone is negative then make it negative
		if (isNegative != isDenominatorNegative) {
			result.insert(0, '-');
		}
		

		return result.toString();

	}

}
