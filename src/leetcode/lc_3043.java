package leetcode;

import java.util.HashSet;

public class lc_3043 {
	public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // Add all prefixes of arr1 to the set
        for (int item1 : arr1) {
            while (item1 != 0) {
                set.add(item1);
                item1 = item1 / 10;
            }
        }

        int res = 0;

        for (int item2 : arr2) {
            while (item2 != 0) {
                if (set.contains(item2)) {
                    int len = String.valueOf(item2).length();
                    res = Math.max(res, len);
                }
                item2 = item2 / 10;
            }
        }

        return res;
    }
	
	public static void main(String[] args) {
		//Input: arr1 = [1,10,100], arr2 = [1000]
		int[] arr1 = new int[]{1, 10, 100};
		int[] arr2 = new int[]{1000};
		int res = new lc_3043().longestCommonPrefix(arr1, arr2);
		System.out.println(res);
		
	}
}
