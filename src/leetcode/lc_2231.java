package leetcode;

import java.util.PriorityQueue;

public class lc_2231 {
	/*
Given a number num, two adjacent digits can be swapped if their parity is the same, that is,
both are odd or both are even.
 For example. (5, 9) have the same parity, but (6,9) do not.
Find the largest number that can be created. The swap operation can be applied any number of times.
Example
Let num = "7596801".
• Swap 5 and 9-> -7951401"
• Swap 7 and 9 > "9756801"
• Swap 6 and 8 - 9758601".
The largest value possible is 9758601".
Function Description
Complete the function getLargestNumber in the editor below.
getLargestNumber has the following parameter:
String num: a string of digits
Returns
string: the largest number that can be created
Constraints
• 1s length of num $ 105
num consists of digits 0-9 only.
	 */
	
	public static void main(String[] args) {
		
		int num = 7596801;
		System.out.println(new lc_2231().largestInteger(num));
		
	}
	
	public int largestInteger(int n) {
		String num = Integer.toString(n);
		//create the priority queue for storing even and odd num
		PriorityQueue<Integer> pqEven = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> pqOdd = new PriorityQueue<>((a, b) -> b - a);
		
		char[] numCharArray = num.toCharArray();
		
		for (char ch : numCharArray) {
			int digit = ch - '0';
			if (digit % 2 == 0) {
				pqEven.add(digit);
			} else {
				pqOdd.add(digit);
			}
		}
		int result = 0;
		
		for (char ch : numCharArray) {
			int digit = ch - '0';
			if (digit % 2 == 0 && !pqEven.isEmpty()) {
				result = result * 10 + pqEven.remove();
			} else {
				result = result * 10 + pqOdd.remove();
			}
			
		}
		
		return result;
	}
}
