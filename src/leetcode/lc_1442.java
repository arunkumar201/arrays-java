package leetcode;

public class lc_1442 {
	
	public static void main(String[] args) {
		int num = 909;
		lc_1442 solution = new lc_1442();
		System.out.println("Result: " + solution.maxDiff(num));
	}
	
	public int maxDiff(int num) {
		String str = Integer.toString(num);
		int n = str.length();
		String maxStr_a = str;
		String minStr_b = str;
		
		//let's build the maxStr
		//we have to replace first non 9's value to 9
		for (int i = 0; i < n; i++) {
			char currentChar = str.charAt(i);
			if (currentChar != '9') {
				maxStr_a = maxStr_a.replace(currentChar, '9');
				break;
			}
			
		}
		System.out.println("maxStr_a: " + maxStr_a);
		
		//let's build the minStr_b
		//we have to replace first  non 1's value to 0
		if (str.charAt(0) != '1') {
			minStr_b = minStr_b.replace(str.charAt(0), '1');
		} else {
			for (int i = 1; i < n; i++) {
				char currentChar = str.charAt(i);
				if (currentChar != '1' && currentChar != '0') {
					minStr_b = minStr_b.replace(currentChar, '0');
					break;
				}
			}
		}
		System.out.println("minStr_b: " + minStr_b);
		
		//let's calculate the max difference
		return Integer.parseInt(maxStr_a) - Integer.parseInt(minStr_b);
	}
	
}
