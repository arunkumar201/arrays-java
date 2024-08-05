package leetcode;


import java.util.HashMap;

class lc_2053 {
	public String kthDistinct(String[] arr, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// Count the frequency of each character
		for (String str : arr) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		// Find the kth distinct character
		int matchIndex = 0;
		for (String str : arr) {
			if (map.get(str) == 1) {
				matchIndex++;
				if (matchIndex == k) {
					return str;
				}
			}
		}
		
		return "";
	}
	
	
	public static void main(String[] args) {
		//Input: arr = ["d","b","c","b","c","a"], k = 2
		String[] arr = new String[]{"d", "b", "c", "b", "c", "a"};
		int k = 2;
		String res = new lc_2053().kthDistinct(arr, k);
		System.out.println(res);
	}
	
}