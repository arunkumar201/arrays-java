package leetcode;

import java.util.Arrays;

public class lc_1353 {
	
	
	public static void main(String[] args) {
		//Input: events = [[1,2],[2,3],[3,4]]
		int[][] events = new int[][]{{1, 2}, {2, 3}, {1, 4}, {3, 4}};
		lc_1353 solution = new lc_1353();
		System.out.println("Result: " + solution.maxEvents(events));
		
	}
	
	public int maxEvents(int[][] events) {
		int n = events.length;
		//sort the events based on the start time
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		
		System.out.println("Sorted Events: " + Arrays.deepToString(events));
		int attendedEvents = 0;
		
		
		return attendedEvents;
		
		
	}
}
