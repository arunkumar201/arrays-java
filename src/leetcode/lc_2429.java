package leetcode;

public class lc_2429 {
	
	public static void main(String[] args) {
		int num1 = 25;
		int num2 = 72;
		int res = new lc_2429().minimizeXor(num1, num2);
		System.out.println(res);
		
	}
	
	public int minimizeXor(int num1, int num2) {
    int ans = 0;
    int setBitsInNum2 = getSetBitCount(num2);
    int bits = 31;
    
    while (bits >= 0 && setBitsInNum2 > 0) {
        if ((num1 & (1 << bits)) != 0) {
            ans = ans | (1 << bits);
            setBitsInNum2--;
        }
        bits--;
    }
    bits = 0;
    
    while (setBitsInNum2 > 0 && bits <= 32) {
        if ((num1 & (1 << bits)) == 0) {
            ans = ans | (1 << bits);
            setBitsInNum2--;
        }
        bits++;
    }
    
    return ans;
}
	
	public int getSetBitCount(int n) {
		int count = 0;
		
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		
		return count;
	}
}
