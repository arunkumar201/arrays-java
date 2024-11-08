package leetcode;

public class lc_2914 {
	public int minChanges(String s) {
		int n = s.length();
		if (n == 2) {
			return s.charAt(0) == s.charAt(1) ? 0 : 1;
		}
		int result = 0;
		for (int i = 0; i < n - 1; i += 2) {
			if (s.charAt(i)!=s.charAt(i+1)) {
				result++;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		String s = "0000";
		int res = new lc_2914().minChanges(s);
		System.out.println(res); // Output: 2
		
	}
}
