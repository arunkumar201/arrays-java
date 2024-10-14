package leetcode;

import java.util.PriorityQueue;

public class lc_2530 {
	   public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long result = 0;
        for (int i : nums) {
            pq.add(i);
        }
      	while (k > 0 && !pq.isEmpty()) {
			int max = pq.poll();
			result += max;
			pq.add((max + 2) / 3);
			k--;
		}
        return result;
    }
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 10, 3, 3, 3};
		int k = 3;
		System.out.println(new lc_2530().maxKelements(arr, k));
	}
}
