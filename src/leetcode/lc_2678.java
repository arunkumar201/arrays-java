package leetcode;

public class lc_2678 {
	public int countSeniors(String[] details) {
		int count = 0;
		for (String detail : details) {
//			String ageStr=detail.substring(11,13);
			int age = (detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0');
			if (age > 60) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		//Input: details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
		String[] details = new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"};
		System.out.println(new lc_2678().countSeniors(details)); // Output: 2
	}
}
