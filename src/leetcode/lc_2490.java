package leetcode;

public class lc_2490 {
	public boolean isCircularSentence(String sentence) {
		boolean isCircular = true;
		int n = sentence.length();
		
		if (sentence.charAt(n - 1) != sentence.charAt(0)) {
			return false;
		}
		
		for (int i = 0; i < n; i++) {
			if (sentence.charAt(i) == ' ') {
				if (i > 0 && sentence.charAt(i - 1) != sentence.charAt((i + 1) % n)) {
					return false;
				}
			}
		}
		return isCircular;
	}
	
	public static void main(String[] args) {
		String sentence = "Leetcode is cool";
		boolean res = new lc_2490().isCircularSentence(sentence);
		System.out.println(res);
		
	}
}
