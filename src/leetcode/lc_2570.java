package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_2570 {
	
	public static void main(String[] args) {
		//Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
		//Output: [[1,6],[2,3],[3,2],[4,6]]
		int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
		int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] res = new lc_2570().mergeArrays(nums1, nums2);
		System.out.println(Arrays.deepToString(res));
		
	}
	
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		int i = 0, j = 0;
		int m = nums1.length;
		int n = nums2.length;
		List<int[]> res = new ArrayList<>();
		
		while (i < m && j < n) {
			if (nums1[i][0] == nums2[j][0]) {
				res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
				i++;
				j++;
			} else if (nums1[i][0] < nums2[j][0]) {
				res.add(new int[]{nums1[i][0], nums1[i][1]});
				i++;
			} else {
				res.add(new int[]{nums2[j][0], nums2[j][1]});
				j++;
				
			}
		}
		while (i < m) {
			res.add(new int[]{nums1[i][0], nums1[i][1]});
			i++;
		}
		while (j < n) {
			res.add(new int[]{nums2[j][0], nums2[j][1]});
			j++;
		}
		int[][] resArr = new int[res.size()][];
		for (int k = 0; k < res.size(); k++) {
			resArr[k] = res.get(k);
		}
		return resArr;
	}
}
