package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_386 {
	
	public static void dfs(int curr, List<Integer> list, int n) {
		/*
		  [1,23] - dfs solution
		      1
		     1                  2               3 4 5 6 ... 13
		  10,   11, 12, 13     20(out of bound)
		 100(out of bound)
		 
		 */
		
		if (curr > n) return;
		list.add(curr);
		curr = curr * 10;
		
		for (int i = 0; i < 10; i++) {
			int newNum = curr * 10 + i;
			if (newNum > n) {
				return;
			}
			dfs(curr + i, list, n);
		}
	}
	
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		
		for (int i = 1; i < 10; i++) {
			dfs(i, res, n);
		}
//		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		//Input: n = 13
		//Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
		int n = 13;
		List<Integer> res = new lc_386().lexicalOrder(n);
		System.out.println(res);
		
	}
}
