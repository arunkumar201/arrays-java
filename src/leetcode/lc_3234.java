package leetcode;

public class lc_3234 {

	public static void main(String[] args) {
		lc_3234 obj = new lc_3234();
		// Input: s = "00011"
		// Output: 5
		System.out.println(obj.numberOfSubstrings("101101")); //16
		System.out.println(obj.numberOfSubstrings("00011")); // 5

	}

	public int numberOfSubstrings(String s) {
		int n = s.length();
		int dominant_ones = 0;

		int i = 0;
		int j = 0;

		int zeros = 0;
		int ones = 0;
		while (i < n) {

			//expand the window 
			while (j < n && ones < (long) zeros * zeros) {
				if (s.charAt(j) == '1') {
					ones++;
				} else {
					zeros++;
				}
				j++;

			}
			
			// When the loop broke, window [i, j-1] was valid.
			if (ones >= (long) zeros * zeros) {
				dominant_ones += j - i + 1;
			}
			
			//shrink the window
			if (s.charAt(i) == '1') {
				ones--;
			} else {
				zeros--;
			}
			i++;
		}

		return dominant_ones;
	}

}
