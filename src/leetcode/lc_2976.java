package leetcode;

public class lc_2976 {
	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		return 1;
		
	}
	
	public static void main(String[] args) {
		//Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"],
		// changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
		String source = "abcd";
		String target = "acbe";
		char[] original = new char[]{'a', 'b', 'c', 'c', 'e', 'd'};
		char[] changed = new char[]{'b', 'c', 'b', 'e', 'b', 'e'};
		int[] cost = new int[]{2, 5, 5, 1, 2, 20};
		long res = new lc_2976().minimumCost(source, target, original, changed, cost);
		System.out.println(res);
	}
}
