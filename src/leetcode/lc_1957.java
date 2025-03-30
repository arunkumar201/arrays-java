package leetcode;

public class lc_1957 {
	
	
	public static void main(String[] args) {
		String s = "aaabaaaa";
		System.out.println(new lc_1957().makeFancyString(s));
		
	}
	
	public String makeFancyString(String s) {
		StringBuffer result = new StringBuffer();
		int n = s.length();
		System.out.println(n);
		
		if (n < 3) {
			return s;
		}
		int i = 0;
		for (i = 0; i < n; i++) {
			if (i < n - 2 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
				continue;
			} else {
				result.append(s.charAt(i));
			}
			
		}
		return result.toString();
		
	}
}
