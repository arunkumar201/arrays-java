package leetcode;

public class lc_2185 {
	
	public static void main(String[] args) {
		String[] words = {"leetcode", "et", "code"};
		String pref = "et";
		int res = new lc_2185().prefixCount(words, pref);
		System.out.println(res);
		
	}
	
	public int prefixCount(String[] words, String pref) {
		int count = 0;
		for (String word : words) {
			if (hasPrefix(word,pref)) {
				count++;
			}
		}
		return count;
		
	}
	
	public boolean hasPrefix(String word, String pref) {
		//if word is less than pref
		int len = pref.length();
		if (word.length() < len) {
            return false;
        }
		
        for (int i = 0; i < len; i++) {
            if (word.charAt(i)!= pref.charAt(i)) {
                return false;
            }
        }
        return true;
	}
	
}
