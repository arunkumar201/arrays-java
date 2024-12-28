package leetcode;

public class lc_1014 {
	
	public static void main(String[] args) {
		int[] values = {8, 1, 5, 2, 6};
		int res = new lc_1014().maxScoreSightseeingPair_BruteForce(values);
		System.out.println(res);
		
	}
	
	public int maxScoreSightseeingPair_BruteForce(int[] values) {
		int ans = Integer.MIN_VALUE;
		int n = values.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int diff = j - i;
				int sum = values[i] + values[j];
				ans = Math.max(ans, sum - diff);
			}
		}
		return ans;
		
	}
	
	public int maxScoreSightseeingPair(int[] values) {
		int n = values.length;
	  /*
	     max_sum=value[i]+value[j]+i-j  /i<j
	     //it can be re-arrange
	     max_sum=(value[i]+i)+(value[j]-j);
	     //or
	     max_sum=first_pair+second_pair;
	   */
		int max_sum = 0; //as array items always be positive else we need to take INT_MIN
		
		//first_pair=value[i]+i;
		int first_pair = values[0];
		
		for (int j = 1; j < n; j++) {
			int second_pair = values[j] - j;
			max_sum = Math.max(max_sum, first_pair + second_pair);
			//now we need max the first_pair always
			//now - if value[j]+j >first_pair or last first_pair then it becomes
			//new first pair
			first_pair = Math.max(first_pair, values[j] + j);
		}
		
		return max_sum;
		
	}
	
}
