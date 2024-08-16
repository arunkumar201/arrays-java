package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_624 {
	//Brute force
	public int maxDistance(List<List<Integer>> arrays) {
		int maxDistance = Integer.MIN_VALUE;
		
		for (int i = 0; i < arrays.size(); i++) {
			for (int j = i + 1; j < arrays.size(); j++) {
				int currentMax1 = Math.abs(arrays.get(i).getFirst() - arrays.get(j).getLast());
				int currentMax2 = Math.abs(arrays.get(i).getLast() - arrays.get(j).getFirst());
				int currentMax = Math.max(currentMax1, currentMax2);
				maxDistance = Math.max(maxDistance, currentMax);
			}
		}
		return maxDistance;
	}
	
	//using greedy approach
	public int maxDistance_Greedy(List<List<Integer>> arrays) {
		int n = arrays.size();
		int maxDistance = Integer.MIN_VALUE;
		
		int maxEnd = arrays.get(0).getLast();
		int minStart = arrays.get(0).getFirst();
		
		
		for (int i = 1; i < n; i++) {
			int curr1 = Math.max(maxDistance, Math.abs(maxEnd - arrays.get(i).getFirst()));
			int curr2 = Math.max(maxDistance, Math.abs(arrays.get(i).getLast() - minStart));
			
			maxDistance = Math.max(maxDistance, Math.max(curr1, curr2));
			
			minStart = Math.min(minStart, arrays.get(i).getFirst());
			maxEnd = Math.max(maxEnd, arrays.get(i).getLast());
		}
		
		return maxDistance;
	}
	
	public static void main(String[] args) {
		//Input: arrays = [[1,2,3],[4,5],[1,2,3]]
		List<List<Integer>> arrays = new ArrayList<>();
		arrays.add(Arrays.asList(1, 2, 3));
		arrays.add(Arrays.asList(4, 5));
		arrays.add(Arrays.asList(1, 2, 3));
		int res = new lc_624().maxDistance(arrays);
		System.out.println(res); // Output: 3
	}
	
}
