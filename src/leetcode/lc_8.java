package leetcode;

public class lc_8 {
	
	
	public static void main(String[] args) {
		String s = "2147483646";
		int i = new lc_8().myAtoiOptimal(s);
		System.out.println("final result " + i);
		
	}
	
	public int myAtoi(String s) {
		int i = 0, n = s.length(), sign = 1;
		StringBuilder result = new StringBuilder();
		
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		
		while (i < n && s.charAt(i) == '0') i++;
		
		while (i < n && Character.isDigit(s.charAt(i))) {
			result.append(s.charAt(i));
			i++;
		}
		
		if (result.isEmpty()) return 0;
		
		if (result.length() > 10)
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		
		long num = Long.parseLong(result.toString()) * sign;
		
		if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		return (int) num;
	}
	
	public int myAtoiOptimal(String s) {
		int i = 0, n = s.length(), sign = 1, result = 0;
		
		while (i < n && s.charAt(i) == ' ') i++;
		
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i++) == '-') ? -1 : 1;
		}
		
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i++) - '0';
			
			// Check for overflow
			long nextResult = result * 10L + digit;
			if (nextResult > Integer.MAX_VALUE) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			
			result = result * 10 + digit;
		}
		
		return result * sign;
	}
	
}
