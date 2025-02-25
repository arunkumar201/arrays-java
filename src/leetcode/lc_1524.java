package leetcode;

public class lc_1524 {
	
	public static void main(String[] args) {
		//Input: arr = [1,4,2,10,23,3,1,0,20]
		int[] arr = {1, 3, 5};
		System.out.println(new lc_1524().numOfSubarrays(arr));
		
	}
	
	
	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		long[] prefixSums = new long[n];
		long res = 0;
		int oddCount = 0;
		int evenCount = 1;
		long mod = 1000000007;
		//1 3 5 - [1,4,9]
		//evens=1
		//odd - 2
		
		
		prefixSums[0] = arr[0];
		for (int i = 1; i < n; i++) {
			long currentSum = prefixSums[i - 1] + arr[i];
			prefixSums[i] = currentSum;
		}
		
		for (long sum : prefixSums) {
			if (sum % 2 != 0) {
				res += evenCount;
				oddCount++;
			} else {
				res += oddCount;
				evenCount++;
			}
		}
        return (int) (res % mod);
	}
	
	public int numOfSubarrays_bruteForce(int[] arr) {
		int n = arr.length;
		int res = 0;
		long sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum % 2 != 0) {
					res += (j - i + 1);
				}
			}
		}
		return res;
		
	}
	
}
