import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class lc_2707 {
	public int minExtraChar(String s, String[] dictionary) {
		HashSet<String> set = new HashSet<>();
		
		Collections.addAll(set, dictionary);
		
		
		int n = s.length();
	
		
		int extra = 0;
		
		return extra;
		
	}
	
	public static void main(String[] args) {
		//Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
		String s = "leetscode";
		String[] dictionary = {"leet", "code", "leetcode"};
		int res = new lc_2707().minExtraChar(s, dictionary);
		System.out.println(res);
	}
}
