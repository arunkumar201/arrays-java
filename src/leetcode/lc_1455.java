package leetcode;

public class lc_1455 {
	
	public static void main(String[] args) {
		String sentence = "i love eating burgers";
		String searchWord = "burg";
		int res = new lc_1455().isPrefixOfWord(sentence, searchWord);
		System.out.println(res);
		int res_1 = new lc_1455().isPrefixOfWord_1(sentence, searchWord);
		System.out.println(res_1);
		
	}
	
	public int isPrefixOfWord(String sentence, String searchWord) {
		
		int ans = -1;
		String[] words = sentence.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].startsWith(searchWord)) {
				ans = i + 1;
				break;
			}
		}
		return ans;
		
	}
	
	//without startsWith
	public int isPrefixOfWord_1(String sentence, String searchWord) {
		int ans = -1;
		String[] words = sentence.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			boolean isPrefix = true;
			
			for (int j = 0; j < searchWord.length(); j++) {
				if (j >= word.length() || word.charAt(j) != searchWord.charAt(j)) {
					isPrefix = false;
					break;
				}
			}
			
			if (isPrefix) {
				ans = i + 1;
				break;
			}
		}
		return ans;
	}
	
	
}

