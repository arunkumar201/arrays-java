package leetcode;

public class lc_1323 {
	
	public static void main(String[] args) {
//		Input: num = 9669
		//Output: 6996
		int num = 9669;
		lc_1323 lc = new lc_1323();
		int res = lc.maximum69Number(num);
		System.out.println(res);
		
		
	}
	
	public int maximum69Number(int num) {
		
		StringBuilder sb = new StringBuilder(Integer.toString(num));
		int len = sb.length();
		int target_index = 0;
		for (int i = 0; i < len; i++) {
			if (sb.charAt(i) == '6') {
				target_index = i;
				break;
			}
		}
		sb.setCharAt(target_index, '9');
		
		return Integer.parseInt(sb.toString());
	}
	
	public int maximum69Number_better(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		
		int len = digits.length;
		int target_index = 0;
		for (int i = 0; i < len; i++) {
			if (digits[i] == '6') {
				target_index = i;
				break;
			}
		}
		digits[target_index] = '9';
		return Integer.parseInt(new String(digits));
	}
}

