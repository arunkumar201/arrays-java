package leetcode;

public class lc_3403 {
	
	public static void main(String[] args) {
		//Input: word = "dbca", numFriends = 2
		String word = "gh";
		int numFriends = 1;
		lc_3403 solution = new lc_3403();
		String result = solution.answerString(word, numFriends);
		System.out.println("Result: " + result);
		
	}
	
	public String answerString(String word, int numFriends) {
		int n = word.length();
		
		if (n < numFriends) {
			return "";
		}
		
		if (numFriends == 1) {
			return word;
		}
		
		int maxPossibleSubstring = n - (numFriends - 1);
		String largestLexicographicalSubstring = "";
		
		for (int i = 0; i < n; i++) {
			
			int canTakeMaxLength = Math.min(maxPossibleSubstring, n - i);
			String subString = word.substring(i, i + canTakeMaxLength);
			
			if (subString.compareTo(largestLexicographicalSubstring) > 0) {
				largestLexicographicalSubstring = subString;
			}
		}
		
		return largestLexicographicalSubstring;
	}
}
