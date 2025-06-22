package leetcode;

import java.util.Arrays;

public class lc_2138 {
	
	public static void main(String[] args) {
		//Input: s = "abcdefghi", k = 3, fill = "x"
		String s = "abcdefghi";
		int k = 3;
		char fill = 'x';
		lc_2138 solution = new lc_2138();
		String[] result = solution.divideString(s, k, fill);
		System.out.println("Result: " + Arrays.toString(result));
		
		
	}
	
	public String[] divideString(String s, int k, char fill) {
		int n = s.length();
		int i = 0;
		int j = 0;
		int numGroups = n / k;
		int lastRemainingElementLen = n % k;
		int fillCount = k - lastRemainingElementLen;
		String[] result = new String[numGroups + (lastRemainingElementLen > 0 ? 1 : 0)];
		while (numGroups > 0) {
			result[j++] = s.substring(i, i + k);
			i += k;
			numGroups--;
		}
//		System.out.println("exact group that can formed" + Arrays.toString(result));
		
		//remaining part of the string, if any
		//lets fill it with the fill character
		if (lastRemainingElementLen > 0) {
			StringBuilder lastGroup = new StringBuilder(s.substring(i, n));
			System.out.println("lastGroup: " + lastGroup);
			lastGroup.append(String.valueOf(fill).repeat(Math.max(0, fillCount)));
			result[j++] = lastGroup.toString();
		}
		return result;
	}
	
	public String[] divideString_optimized(String s, int k, char fill) {
		int n = s.length();
		int j = 0;
		int totalGroups = (n + k - 1) / k;
		String[] result = new String[totalGroups];
		
		int index = 0;
		while (totalGroups > 0) {
			StringBuilder currentGroup = new StringBuilder();
			
			for (int x = 0; x < k; x++) {
				if (index < n) {
					currentGroup.append(s.charAt(index++));
				} else {
					currentGroup.append(fill);
				}
			}
			result[j++] = currentGroup.toString();
			totalGroups--;
		}
		
		return result;
	}
	
}
