package leetcode;

import java.util.HashMap;

public class lc_1399 {
	public static void main(String[] args) {
		int n = 13;
		System.out.println(new lc_1399().countLargestGroup(n));
	}
	
	public int countLargestGroup(int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			int sumOfDigits = getSumOfDigits(i);
			map.put(sumOfDigits, map.getOrDefault(sumOfDigits, 0) + 1);
		}
		int count = 0;
		int max=Integer.MIN_VALUE;
		for (int i : map.values()) {
			if (i > max) {
				max = i;
				count = 1;
			} else if (i == max) {
				count++;
			}
		}
		return count;
	}
	
	private int getSumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
