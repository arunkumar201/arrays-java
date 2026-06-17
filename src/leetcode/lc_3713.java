package leetcode;

public class lc_3713 {


	public static void main(String[] args) {

		String s = "abbac";

		lc_3713 sol = new lc_3713();

		int res = sol.longestBalanced(s);
		System.out.println(res);


	}
	
	public int longestBalanced(String s) {
		int longestBalanced = 0;
		int n = s.length();

	    
		for (int i = 0; i < n; i++) {
			int[] count = new int[26];

			for (int k = 0; k < 26; k++) {
				count[k] = -1;
			}

			for (int j = i; j < n; j++) {
				count[s.charAt(j) - 'a']++;
				int freq = -1;
				//check if balanced 
				boolean isBalanced = true;

				for (int k = 0; k < 26; k++) {
					if (count[k] != -1) {
						if (freq == -1) {
							freq = count[k];
						} else if (count[k] != freq) {
							isBalanced = false;
							break;
						}
					}
				}
				if (isBalanced) {
					longestBalanced = Math.max(longestBalanced, j - i + 1);
				}
			}

		}
		return longestBalanced;

	}
	
}
