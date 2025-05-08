public class lc_408 {
	
	
	public static void main(String[] args) {
		//Input: word = "internationalization", abbr = "i12iz4n"
		String word = "appppple";
		String abbr = "a2p02le";
		boolean res = new lc_408().validWordAbbreviation_bruteForce(word, abbr);
		System.out.println(res);
		
	}
	
	public boolean validWordAbbreviation_bruteForce(String word, String abbr) {
		int n = word.length();
		int m = abbr.length();
		
		//two pointers approach
		int j = 0; //pointing to abbreviation
		int i = 0; //pointing to word
		
		while (j < m && i < n) {
			//if both are same
			if (word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
			}
			//abbreviation is a digit, and it is start with zero
			//as we are not allowing leading zero in abbreviation
			else if (Character.isDigit(abbr.charAt(j)) && abbr.charAt(j) == '0') {
				return false;
			}
			//now we have the  valid digit in the abbreviation
			else {
				//now we will build the number from abbreviation
				int num = 0;
				while (j < m && Character.isDigit(abbr.charAt(j))) {
					num = num * 10 + abbr.charAt(j) - '0';
					j++;
				}
				i += num;
			}
		}
		return i == n && j == m;
		
		
	}
}
