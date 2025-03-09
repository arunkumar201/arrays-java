package leetcode;

public class lc_2379 {
	
	public static void main(String[] args) {
	/*
	Input: blocks = "WBBWWBBWBW", k = 7
    Output: 3
	 */
		String blocks = "WBWBBBW";
		int k = 2;
		System.out.println(new lc_2379().minimumRecolors(blocks, k));
		System.out.println(new lc_2379().minimumRecolors_bruteForce(blocks, k));
		
	}
	
	public int minimumRecolors(String blocks, int k) {
		int n = blocks.length();
		int left = 0;
		int right = 0;
		
		int recolors = 0;
		
		int ans = Integer.MAX_VALUE;
		
		while (left < n && right < n) {
			if (blocks.charAt(right) == 'W') {
				recolors++;
			}
			if (right - left + 1 == k) {
				ans = Math.min(ans, recolors);
				if (blocks.charAt(left) == 'W') {
					recolors--;
				}
				left++;
			}
			right++;
		}
		return ans;
	}
	
	public int minimumRecolors_bruteForce(String blocks, int k) {
		int n = blocks.length();
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		
		while (left + k <= n) {
			
			int recolors = 0;
			
			while (right - left + 1 <= k) {
				if (blocks.charAt(right) == 'W') {
					recolors++;
				}
				right++;
			}
			
			ans = Math.min(ans, recolors);
			left++;
			right = left;
		}
		return ans;
	}
}