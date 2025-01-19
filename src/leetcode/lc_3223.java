package leetcode;

public class lc_3223 {
	public static void main(String[] args) {
		String s = "abaacbcbb";
		System.out.println(new lc_3223().minimumLength_BruteForce(s));
		System.out.println("optimize solution " + new lc_3223().minimumLength(s));
	}
	
	public int minimumLength(String s) {
		int n = s.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}
		int ans = 0;
		
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0) continue;
			ans += count[i] % 2 == 0 ? 2 : 1;
		}
		return ans;
	}
	
	public int minimumLength_BruteForce(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		char DEFAULT_CHAR = '#';
		
		for (int i = 1; i < n; i++) {
			char currentChar = arr[i];
			if (currentChar == DEFAULT_CHAR) continue;
			int leftStart = i - 1;
			int rightStart = i == n - 1 ? n : i + 1;
			//iterate from left to 0
			while (leftStart >= 0 && arr[leftStart] != currentChar) {
				leftStart--;
			}
			
			//iterate from right to n-1
			while (rightStart < n && arr[rightStart] != currentChar) {
				rightStart++;
			}
			
			//if leftStart and rightStart
			if ((leftStart == -1 || rightStart == n)) {
				continue;
			} else {
				arr[leftStart] = DEFAULT_CHAR;
				arr[rightStart] = DEFAULT_CHAR;
				
			}
			
			
		}
		int ans = 0;
		
		for (char c : arr) {
			if (c != DEFAULT_CHAR) ans++;
		}

//		System.out.println(Arrays.toString(arr));
		
		return ans;
		
	}
}
