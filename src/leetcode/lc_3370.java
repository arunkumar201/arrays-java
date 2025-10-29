package leetcode;

public class lc_3370 {
	
	public static void main(String[] args) {
		lc_3370 lc_3370 = new lc_3370();
		int n = 10; //ans=15
		System.out.println(lc_3370.smallestNumber(n));

	}

	public String getBinaryString(int n) {
		String binString = "";

		while (n > 0) {
			binString = n % 2 + binString;
			n /= 2;
		}

		return binString;
	}
	
	public int smallestNumber_1(int n) {
		int ans = 0;

		String binary_number = getBinaryString(n);
		int binary_length = binary_number.length();

		for (int i = 0; i < binary_length; i++) {
			ans += Math.pow(2, i);
		}

		return ans;
	}
	
	public int smallestNumber(int n) {
		if (n == 1)
			return 1;

		//3 ,7,15,31,63,127,255,511,1023
		if(n<=3)
			return 3;
	    else if (n<=7)
			return 7;
	    else if (n<=15)
			return 15;
	    else if (n<=31)
			return 31;
	    else if (n<=63)
			return 63;
	    else if (n<=127)
			return 127;
	    else if (n<=255)
			return 255;
	    else if (n<=511)
			return 511;
	    else if (n<=1023)
			return 1023;
	    else
			return 2047;
	}
}
