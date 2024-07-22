package leetcode;

import java.util.*;

public class lc_2418 {
	
	public String[] sortPeople(String[] names, int[] heights) {
		int n = names.length;
		
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = heights[i];
			arr[i][1] = i;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr, int[] arr1) {
				return Integer.compare(arr1[0], arr[0]);
			}
		});
		
		String[] res = new String[n];
		
		for (int i = 0; i < n; i++) {
			res[i] = names[arr[i][1]];
		}
		return res;
	}
	
	
	public String[] sortPeople_using_map(String[] names, int[] heights) {
		Map<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < names.length; i++) {
			map.put(heights[i], names[i]);
		}
		
		Arrays.sort(heights);
		
		String[] res = new String[names.length];
		for (int i = heights.length - 1; i >= 0; i--) {
			res[heights.length - i - 1] = map.get(heights[i]);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		//Input: names = ["Mary","John","Emma"], heights = [180,165,170]
		String[] names = new String[]{"Mary", "John", "Emma"};
		int[] heights = new int[]{180, 165, 170};
		String[] res = new lc_2418().sortPeople(names, heights);
		for (String s : res)
			System.out.println(s);
		System.out.println("-------");
		String[] res_map = new lc_2418().sortPeople_using_map(names, heights);
		for (String s : res_map)
			System.out.println(s);
		System.out.println("--------");
		String[] res_pq = new lc_2418().sortPeople_priority_queue(names, heights);
		for (String s : res_pq)
			System.out.println(s);
	}
}
