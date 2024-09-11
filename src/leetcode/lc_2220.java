package leetcode;

public class lc_2220 {
	
	
	// Function that count set bits
	public static int numberSetBits(int n) {
		// Count the number of 1's in the binary representation of n.
		int count = 0;
		while (n != 0) {
			count += n & 1; // Increment count if the least significant bit is 1;
			n >>= 1; // Right shift C to check the next bit
		}
		return count;
	}
	
	//another way to count num of setBits
	public static int numberSetBits_1(int n) {
		int count = 0;
		
		while (n != 0) {
			int rem = n % 2;
			n = n / 2;
			count += rem == 1 ? 1 : 0;
		}
		return count;
	}
	
	public int minBitFlips(int start, int goal) {
		// XOR the two numbers to get the unmatched bits (number of setBits or 1's is going
		//to be un-matched bits
		int diff = start ^ goal;
		return numberSetBits_1(diff);
		
	}
	
	public static void main(String[] args) {
//		Input: start = 10, goal = 7
		int start = 10, goal = 7;
		int res = new lc_2220().minBitFlips(start, goal);
		System.out.println(res);
		
	}
}
