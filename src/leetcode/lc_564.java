package leetcode;

import java.util.LinkedList;

public class lc_564 {
	
	
	public long getResult(long firstHalf, boolean isEven) {
//		System.out.println(firstHalf);
		long result = firstHalf;
		
		if (!isEven) {
			firstHalf /= 10;
		}
		
		while (firstHalf > 0) {
			int lastDigit = (int) (firstHalf % 10);
			result = (result * 10) + lastDigit;
			firstHalf /= 10;
		}
		return result;
	}
	
	public String nearestPalindromic(String n) {
		//if int(n)<10
		// return int(n)-1;
		//if string length is even
		// - take half - first haft + mirror of second half
		//if string length is odd
		//= take half string - len/2+1 string and   token half+(mirror all half expect last one)
		
		//129 - possible palindrome (take min diff among all)
		//- 121
		// 111
		//131
		//999...
		//10001 ,100001 ,...
		// - 999 = 10^len+1 ans
		//101 - 10^len-1;
		
		if (Long.parseLong(n) < 10) {
			return Integer.parseInt(n) - 1 + "";
		}
		
		int len = n.length();
		
		int mid = len / 2;
		
		long firstHalfLength = len % 2 == 0 ? mid : mid + 1;
		long firstHalf = Long.parseLong(n.substring(0, (int) firstHalfLength));
		
		LinkedList<Long> possibleAns = new LinkedList<>();
		
		possibleAns.add(getResult(firstHalf, len % 2 == 0));
		possibleAns.add(getResult(firstHalf - 1, len % 2 == 0));
		possibleAns.add(getResult(firstHalf + 1, len % 2 == 0));
		//handle case when 999,1001 kind of inputs
		possibleAns.add((long) (Math.pow(10, len) + 1));
		possibleAns.add((long) (Math.pow(10, len - 1) - 1));
//		System.out.println(possibleAns);
		long minDiff = Long.MAX_VALUE;
		long result = Long.MAX_VALUE;
		long original = Long.parseLong(n);
		
		
		for (long num : possibleAns) {
			if (num == original) {
				continue;
			}
			long currDiff = Math.abs(num - original);
			if (currDiff < minDiff) {
				minDiff = currDiff;
				result = num;
			} else if (currDiff == minDiff) { //tie - we go two palindrome
				result = Math.min(result, num);
			}
		}
		return String.valueOf(result);
	}
	
	public static void main(String[] args) {
		//Input: n = "123"
		//Output: "121"
		String n = "10";
		String res = new lc_564().nearestPalindromic(n);
		System.out.println(res);
	}
}
