package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_2197 {

	public static void main(String[] args) {
		// Input: nums = [6,4,3,2,7,6,2]
		// int[] nums = { 287, 41, 49, 287, 899, 23, 23, 20677, 5, 825}; // [2009,
		// 20677, 825]
		int[] nums = { 287, 41, 49, 287, 899, 23, 23, 20677, 5, 825 };
		List<Integer> res = new lc_2197().replaceNonCoprimes_bruteForce(nums);
		System.out.println("Brute Force " + res);

	}

	/**
	 * NOTE: Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is
	 * the Greatest Common Divisor of x and y.
	 * 
	 * @param nums
	 * @return
	 */

	private int getGCD(int a, int b) {
		return b == 0 ? a : getGCD(b, a % b);
	}


	public List<Integer> replaceNonCoprimes_bruteForce(int[] nums) {

		List<Integer> list = new ArrayList<>();

		for (int num : nums) {
			list.add(num);
		}

		int i = 0;
		while (i < list.size() - 1) {
			int a = list.get(i);
			int b = list.get(i + 1);
			int gcd = getGCD(a, b);
			if (gcd > 1) {
				list.set(i, (a / gcd) * b);
				list.remove(i + 1);
				if (i > 0) {
					i--;
				}
			} else {
				i++;
			}

		}
		System.out.println("list " + list);

		return list;
	}
}
