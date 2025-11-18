package leetcode;

public class lc_7171 {

	public static void main(String[] args) {
		// Input: bits = [1,0,0]

		int[] bits = { 1, 0, 0 };
		lc_7171 obj = new lc_7171();
		System.out.println(obj.isOneBitCharacter(bits));
	}

	public boolean isOneBitCharacter(int[] bits) {

		int i = 0;
		int n = bits.length;
		while (i < n-1) {
			int first = bits[i];
			int second = bits[i+1];
			if (((first == 1 && second == 0) || (first == 1 && second == 1))) {
				i+=2;
			}else if((first == 0 || first == 1)){
				i+=1;
			}
		}
		//if i==n-1, then it is a one bit character
		return i==n-1;
	}

}
