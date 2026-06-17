package leetcode;

public class lc_2048 {
	public static void main(String[] args) {
		lc_2048 lc_2048 = new lc_2048();
		int n = 1;
		System.out.println(lc_2048.nextBeautifulNumber(n));

	}
	
	public int nextBeautifulNumber(int n) {

		//if n is less than 10 
		if (n < 10) {
			return n == 0 ? 1 : 22;
		}
		

		return n;

	}
}
