package leetcode;

public class lc_1534 {
	
	public static void main(String[] args) {
		//Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
		//Output: 4
		int[] arr = {3, 0, 1, 1, 9, 7};
		int a = 7;
		int b = 2;
		int c = 3;
		System.out.println(new lc_1534().countGoodTriplets_bruteForce(arr, a, b, c));
		
	}
	
	public int countGoodTriplets_bruteForce(int[] arr, int a, int b, int c) {
		int count = 0;
		int n = arr.length;
		if (n < 3) return 0;
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int x = Math.abs(arr[i] - arr[j]);
				if (x > a) continue;
				for (int k = j + 1; k < n; k++) {
					int y = Math.abs(arr[j] - arr[k]);
					int z = Math.abs(arr[i] - arr[k]);
					
					if (x <= a && y <= b && z <= c) {
						count++;
					}
				}
				
			}
		}
		return count;
	}
}
