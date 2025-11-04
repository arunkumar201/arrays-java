package leetcode;

public class lc_1578 {
	
	public static void main(String[] args) {
		//Input: colors = "aabaa", neededTime = [1,2,3,4,1]

		String colors = "aaabbbabbbb";
		int[] neededTime = { 3,5,10,7,5,3,5,5,4,8,1 };  //26
		lc_1578 lc_1578 = new lc_1578();
		int minCost = lc_1578.minCost(colors, neededTime);
		System.out.println("Minimum cost: " + minCost);

	}
	
	public int minCost(String colors, int[] neededTime) {
		int minCost = 0;
		int n = colors.length();


		int i = 0;

		while (i < n) {
			char currColor = colors.charAt(i);
			int maxTime = 0; 
			int sumTime = 0;
			

			while (i < n && colors.charAt(i) == currColor) {
				sumTime += neededTime[i];
				maxTime = Math.max(maxTime, neededTime[i]);
				i++;
			}

			minCost += sumTime - maxTime;	
		}
		return minCost;
        
    }
}
