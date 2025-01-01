package leetcode;

import java.util.HashMap;

public class lc_1422 {
	
	
	public static void main(String[] args) {
		String s = "0100";
		int res = new lc_1422().maxScore_BruteForce(s);
		System.out.println(res);
		
		res = new lc_1422().maxScore(s);
		System.out.println(res);
		
		
	}
	
	public int maxScore(String s) {
    int n = s.length();
    int ones = 0;
    int zeros = 0;
    int maxScore = 0;

    for (char c : s.toCharArray()) {
        if (c == '1') ones++;
    }

    for (int i = 0; i < n - 1; i++) {
        if (s.charAt(i) == '0') {
            zeros++;
        } else {
            ones--;
        }
        maxScore = Math.max(maxScore, zeros + ones);
    }

    return maxScore;
}
	
	public int maxScore_BruteForce(String s) {
		int n = s.length();
		int ans = 0;
		
		for (int i = 1; i < n - 1; i++) {
			int count_1 = 0;
			int count_0 = 0;
			//left
			for (int j = 0; j <= i; j++) {
				if (s.charAt(j) == '0') count_0++;
			}
			//right
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(j) == '1') count_1++;
			}
			ans = Math.max(ans, count_0 + count_1);
		}
		
		return ans;
	}
}
