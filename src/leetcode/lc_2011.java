package leetcode;

public class lc_2011 {

	public static void main(String[] args) {
		// Input: operations = ["--X","X++","X++"]
		String[] operations = { "--X", "X++", "X++" };
		lc_2011 lc_2011 = new lc_2011();
		System.out.println(lc_2011.finalValueAfterOperations(operations));

	}

	public int finalValueAfterOperations(String[] operations) {
		int x = 0;

		for (String s : operations) {
			if (s.contains("--")) {
				x--;
			} else {
				x++;
			}
		}
		return x;
	}
}
