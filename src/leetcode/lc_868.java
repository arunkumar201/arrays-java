package leetcode;

public class lc_868 {

	public static void main(String[] args) {
		lc_868 lc_868 = new lc_868();
		int n = 11;
		System.out.println(lc_868.binaryGap(n));
		System.out.println("--- binaryGap_optimized ------");
		System.out.println(lc_868.binaryGap_optimized(n));
	}
	


	public int binaryGap(int n) {
		String binary = Integer.toBinaryString(n);

		int prev = -1;
		int maxGap = 0;

		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				if (prev != -1) {
					maxGap = Math.max(maxGap, i - prev);
				}
				prev = i;
			}
		}

		return maxGap;
	}

	public int binaryGap_optimized(int n) {
		int prev = -1;
		int maxGap = 0;

		for (int i = 0; i < 32; i++) {
			// value of bit at position i
			int bitAtPosition = (n >> i) & 1;

			if (bitAtPosition == 1) {
				if (prev != -1) {
					maxGap = Math.max(maxGap, i - prev);
				}
				prev = i;
			}

		}

		return maxGap;
	}
}
