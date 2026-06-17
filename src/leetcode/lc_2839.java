package leetcode;

import java.util.Arrays;

public class lc_2839 {

	public static void main(String[] args) {
		String s1 = "bnxw";
		String s2 = "bwxn";

		lc_2839 sol = new lc_2839();
		System.out.println("Result: " + sol.canBeEqual(s1, s2));
	}

	public boolean canBeEqual(String s1, String s2) {

		// s1=bnxw
		// s2=bwxn

		// even indexes - (s1[0]===s2[0] && s1[2]==s2[2]) || (s1[0]==s2[2] ||
		// s1[2]==s2[0])
		// && odd indexes -(s1[1]==s2[1] && s1[3]==s2[3]) || (s1[1]==s2[3] ||
		// s1[3]==s2[1])

		return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2))
				|| (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0)))
				&& ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3))
						|| (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
	}

	public boolean canBeEqualSorting(String s1, String s2) {

		char[] even1 = new char[] { s1.charAt(0), s1.charAt(2) };
		char[] odd1 = new char[] { s1.charAt(1), s1.charAt(3) };

		char[] even2 = new char[] { s2.charAt(0), s2.charAt(2) };
		char[] odd2 = new char[] { s2.charAt(1), s2.charAt(3) };

		// sort them
		Arrays.sort(even1);
		Arrays.sort(even2);

		Arrays.sort(odd1);
		Arrays.sort(odd2);

		return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
	}
}
