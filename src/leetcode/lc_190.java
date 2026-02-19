package leetcode;

public class lc_190 {

	public static void main(String[] args) {
		// Input: n = 43261596

		int n = 43261596;
		lc_190 sol = new lc_190();
		System.out.println(sol.reverseBits(n));

	}

	public int reverseBits(int n) {

		if (n == 0)
			return 0;
		
		int res = 0;

		for (int i = 1; i <= 32; i++) {
			int n_lsb = n & 1;

			//result - left shift
			res = res << 1;
			res = res | n_lsb;


			//n - right shift
			n = n >> 1;
		}

		return res;
	}

}
