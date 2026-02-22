package leetcode;

public class lc_696 {

	public static void main(String[] args) {
		// Input: s = "00110011"

		String s = "";
		lc_696 sol = new lc_696();

		System.out.println("My Result + " + sol.countBinarySubstrings(s));
	}

	public int countBinarySubstrings(String s) {
		int count = 0;
		int n = s.length();
		int[] groups = new int[n];
		int j = 0;
		groups[0] = 1;

		for (int i = 1; i < n; i++) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				groups[++j] = 1;
			} else {
				groups[j]++;
			}
		}

		for (int i = 1; i <= j; i++) {
			count += Math.min(groups[i - 1], groups[i]);
		}

		return count;
	}
	
	public int countBinarySubstrings_optimized(String s) {
		int count = 0;
		int prev = 0;
		int curr = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				curr++;
			} else {
				count += Math.min(prev, curr);
				prev = curr;
				curr = 1;
			}
		}

		return count + Math.min(prev, curr);
	}

}
