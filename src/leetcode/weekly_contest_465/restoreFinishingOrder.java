package leetcode.weekly_contest_465;

import java.util.Arrays;
import java.util.HashMap;

public class restoreFinishingOrder {
	
	public static void main(String[] args) {
		// Example Input
		int[] order = new int[]{3, 1, 2, 5, 4};
		int[] friends = new int[]{1, 3, 4};
		
		restoreFinishingOrder sol = new restoreFinishingOrder();
		int[] result = sol.recoverOrder(order, friends);
		System.out.println(Arrays.toString(result));
		int[] result1 = sol.recoverOrder_optimized(order, friends);
		System.out.println(Arrays.toString(result1));
	}
	
	public int[] recoverOrder(int[] order, int[] friends) {
		HashMap<Integer, Boolean> isFriend = new HashMap<>();
		for (int f : friends) {
			isFriend.put(f, true);
		}
		
		int[] friendsOrder = new int[friends.length];
		int idx = 0;
		
		for (int runner : order) {
			if (isFriend.containsKey(runner)) {
				friendsOrder[idx++] = runner;
			}
		}
		
		return friendsOrder;
	}
	
	public int[] recoverOrder_optimized(int[] order, int[] friends) {
		int[] isFriend = new int[101];
		for (int f : friends) {
			isFriend[f] = 1;
		}
		
		int[] friendsOrder = new int[friends.length];
		int idx = 0;
		
		for (int runner : order) {
			if (isFriend[runner] != 0) {
				friendsOrder[idx++] = runner;
			}
		}
		
		return friendsOrder;
	}
	
}
