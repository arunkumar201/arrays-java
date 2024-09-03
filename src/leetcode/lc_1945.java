package leetcode;

public class lc_1945 {
	
	public static int getPosition(char letter) {
		return Character.toLowerCase(letter) - 'a' + 1;
	}
	
	public int getLucky(String s, int k) {
		StringBuffer str = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			str.append(getPosition(s.charAt(i)));
			
		}
		System.out.println(str);
		int sum = 0;
		while (k > 0) {
			sum=0;
			for (int i = 0; i < str.length(); i++) {
				int digit = str.charAt(i) - '0';
				sum += digit;
			}
			System.out.println(sum);
			str = new StringBuffer(String.valueOf(sum));
			k--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		int k = 2;
		System.out.println(new lc_1945().getLucky(s, k));
	}
}
