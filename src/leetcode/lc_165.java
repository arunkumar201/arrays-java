package leetcode;

import java.util.*;

public class lc_165 {

	public static void main(String[] args) {
		lc_165 lc = new lc_165();
		System.out.println(lc.compareVersion("1.1", "1.0.0.01"));
		System.out.println(lc.compareVersion_optimized("1.1", "1.0.0.01"));
	}

	public int compareVersion(String version1, String version2) {
		List<Integer> v1 = parse(version1);
		System.out.println("----second v2--");
		List<Integer> v2 = parse(version2);

		int n = Math.max(v1.size(), v2.size());

		for (int i = 0; i < n; i++) {
			int num1 = i < v1.size() ? v1.get(i) : 0;
			int num2 = i < v2.size() ? v2.get(i) : 0;

			if (num1 < num2)
				return -1;
			if (num1 > num2)
				return 1;
		}

		return 0;
	}

	private List<Integer> parse(String version) {
		List<Integer> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < version.length(); i++) {
			char c = version.charAt(i);
			if (c == '.') {
				result.add(Integer.parseInt(sb.toString()));
				sb.setLength(0);
			} else {
				sb.append(c);
			}
		}
		if (sb.length() > 0) {
			result.add(Integer.parseInt(sb.toString()));
		}

		return result;
	}

	public int compareVersion_optimized(String version1, String version2) {

		int m = version1.length();
		int n = version2.length();

		int i = 0;
		int j = 0;

		while (i < m || j < n) {
			int num1 = 0;
			int num2 = 0;

			while (i < m && version1.charAt(i) != '.') {
				num1 = num1 * 10 + (version1.charAt(i) - '0');
				i++;
			}

			while (j < n && version2.charAt(j) != '.') {
				num2 = num2 * 10 + (version2.charAt(j) - '0');
				j++;
			}

			if (num1 < num2)
				return -1;
			if (num1 > num2)
				return 1;

			// skip the '.' for next round
			if (i < m && version1.charAt(i) == '.')
				i++;
			if (j < n && version2.charAt(j) == '.')
				j++;
		}
		return 0;
	}

}
