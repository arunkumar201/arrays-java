package leetcode;

public class lc_3042 {
	public static void main(String[] args) {
		String[] words = {"a", "aba", "ababa", "aa"};
		
		int res = new lc_3042().countPrefixSuffixPairs(words);
		System.out.println(res);
		
	}
	
	public int countPrefixSuffixPairs(String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String prefix = words[i];
			for (int j = i + 1; j < words.length; j++) {
				if (isPrefixAndSuffix(words[j], prefix)) {
					count++;
				}
			}
		}
		
		return count;
		
	}
	
	public boolean isPrefixAndSuffix(String word, String prefix) {
//		return word.startsWith(prefix) && word.endsWith(prefix);
		return hasSuffix(word, prefix) && hasPrefix(word, prefix);
	}
	
	public boolean hasPrefix(String word, String prefix) {
		int n = prefix.length();
		if (word.length() < n) return false;
		for (int i = 0; i < n; i++) {
			if (word.charAt(i) != prefix.charAt(i)) return false;
		}
		return true;
	}
	
	    public boolean hasSuffix(String word, String suffix) {
        int n = suffix.length();
        int len = word.length();
        if (len < n) return false;
        for (int i = 0; i < n; i++) {
            if (word.charAt(len - 1 - i) != suffix.charAt(n - 1 - i)) return false;
        }
        return true;
    }
	
}
