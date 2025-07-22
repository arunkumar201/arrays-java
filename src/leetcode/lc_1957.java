package leetcode;

public class lc_1957 {
	
	
	public static void main(String[] args) {
		String s = "aaabaaaa";
		System.out.println(new lc_1957().makeFancyString(s));
		System.out.println(new lc_1957().makeFancyStringOptimized(s));
		
	}
	
	public String makeFancyString(String s) {
		StringBuffer result = new StringBuffer();
		int n = s.length();
		
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
	
	public String makeFancyStringOptimized(String s) {
		String result = "";
		int n = s.length();
		char[] str = s.toCharArray();
		
		
		int currentCount = 1;
		int k=1;
		
		for (int i = 1; i < n; i++) {
			int currentChar = str[i];
			int prevChar = str[i - 1];
			
			if (currentChar == prevChar) {
				currentCount++;
			} else {
				currentCount--;
			}
			
			if(currentCount>2)continue;;
			
			str[k]=str[i];
			
		}
		return result;
	}
	
}
