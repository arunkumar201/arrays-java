package leetcode;

public class lc_1790 {
	public static void main(String[] args) {
		//Input: s1 = "bank", s2 = "kanb"
		String s1 = "yhy";
		String s2 = "hyc";
		System.out.println(new lc_1790().areAlmostEqual(s1, s2));
	}
	
	public boolean areAlmostEqual_unoptimized(String s1, String s2) {
		int count = 0;
		int n = s1.length();
		StringBuilder first_unmatched = new StringBuilder();
		StringBuilder second_unmatched = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				String str = s1.charAt(i) + "" + s2.charAt(i);
				System.out.println(str);
				if (count == 0) {
					first_unmatched.append(str);
				} else if (count == 1) {
					second_unmatched.append(str);
				}
				
				count++;
			}
			
		}
		System.out.println("count: " + count);
		if (count == 0) {
			return true;
		}
		if (count > 2) {
			return false;
		}
		
		System.out.println("first unmatched: " + first_unmatched);
		System.out.println("second unmatched: " + second_unmatched);
		
		return (first_unmatched.charAt(0) == second_unmatched.charAt(1)
				&& first_unmatched.charAt(1) == second_unmatched.charAt(0));
	}
	
	public boolean areAlmostEqual(String s1, String s2) {
		int n = s1.length();
		int count = 0;
		char c1 = 0, c2 = 0;
		char c3 = 0, c4 = 0;
		
		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (count == 0) {
					c1 = s1.charAt(i);
					c2 = s2.charAt(i);
				} else if (count == 1) {
					c3 = s1.charAt(i);
					c4 = s2.charAt(i);
				}
				count++;
			}
			
			if (count > 2) {
				return false;
			}
		}
		
		if (count == 0) {
			return true;
		}
		return (c1 == c4 && c2 == c3);
	}
}
