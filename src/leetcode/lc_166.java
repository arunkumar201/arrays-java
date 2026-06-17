package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc_166 {

	public static void main(String[] args) {
		// Input: numerator = 1, denominator = 2
		lc_166 sol = new lc_166();
		System.out.println(sol.fractionToDecimal_optimal(1, 2)); // 0.5
		System.out.println(sol.fractionToDecimal_optimal(7, 963)); // "0.(00726895119418483904465212876427829698857736240913811)"
		System.out.println(sol.fractionToDecimal_optimal(1, 6)); // 2

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

		// if both are negative then make it positive else if anyone is negative then
		// make it negative
		if (isNegative != isDenominatorNegative) {
			result.insert(0, '-');
		}

		return result.toString();

	}

	public String fractionToDecimal_optimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();

		boolean wasNegative = false;

		boolean numerator_was_negative = false;
		boolean denominator_was_negative = false;

		if (numerator < 0) {
			numerator_was_negative = true;
		}
		if (denominator < 0) {
			denominator_was_negative = true;

		}

		if (denominator_was_negative != numerator_was_negative) {
			wasNegative = true;
		}
		// now we will append the '-' in start if one of them were negative
		if (wasNegative && numerator != 0) {
			result.append("-");
		}

		// dividend and reminder
		long l_numerator = Math.abs((long) numerator);
		long l_denominator = Math.abs((long) denominator);

		long decimalPart = l_numerator / l_denominator;

		if (numerator % denominator == 0) {
			return result.append(l_numerator / l_denominator).toString();
		}
		// add it into the result
		result.append(Long.toString(decimalPart));
		// get the reminder
		long reminder = (l_numerator % l_denominator);

		// append the remainder
		// before that we should put the "."
		result.append(".");

		Map<Long, Integer> hasRemainderSeen = new HashMap<>();

		while (reminder != 0) {
			if (hasRemainderSeen.containsKey(reminder)) {
				// we found the repeating remainder
				int repeatingStartIndex = hasRemainderSeen.get(reminder);

				result.insert(repeatingStartIndex, "(");
				result.insert(result.length(), ")");
				break;
			}

			hasRemainderSeen.put(reminder, result.length());

			reminder *= 10;
			result.append(reminder / l_denominator);
			reminder = (reminder % l_denominator);
		}

		return result.toString();
	}

}
