package leetcode;

public class lc_440 {
	private int count = 0;
	private int result = 0;
	
	public void dfs(int curr, int k, int n) {
		// Stop recursion if the current number exceeds `n` or we already found the k-th number
		if (curr > n || count >= k) {
			return;
		}
		
		// We've found another valid number
		count++;
		if (count == k) {
			result = curr;
			return;
		}
		
		curr = curr * 10;
		for (int i = 0; i < 10; i++) {
			int newNum = curr + i;
			if (newNum > n) {
				break;
			}
			dfs(newNum, k, n);
			if (count == k) {
				return;
			}
		}
	}
	
	
	public int findKthNumber(int n, int k) {
		for (int i = 1; i <= 9; i++) {  // Start from 1 to 9
			dfs(i, k, n);
			if (count == k) {
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//Input: n = 13, k = 2
		int n = 13;
		int k = 2;
		System.out.println(new lc_440().findKthNumber(n, k)); // Output: 10
		
	}
}
