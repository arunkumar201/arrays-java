package leetcode;

import java.util.Arrays;

public class lc_3169 {
	
	public static void main(String[] args) {
		
		//Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
		//Output: 2
		
		int days = 5;
		int[][] meetings = {{2, 4}, {1, 3}};
		System.out.println(new lc_3169().countDays(days, meetings)); // Output: 2
	}
	
	public int countDays(int days, int[][] meetings) {
//		sort the meetings by start time
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		
		int totalBusy = 0;
		int prevEnd = 0;
		
		for (int i = 0; i < meetings.length; i++) {
			int start = meetings[i][0];
			int end = meetings[i][1];
			
			if (start > prevEnd + 1) {
				totalBusy += (start - prevEnd - 1);
			}
			prevEnd = Math.max(prevEnd, end);
		}
		if (prevEnd < days) {
			totalBusy += (days - prevEnd);
		}
		return totalBusy;
	}
}
