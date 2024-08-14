package leetcode;

public class lc_204 {
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
		
	}
	
	public boolean isPrime(int num) {
		//if n <=1 then
		if (num <= 1) {
			return false;
		}
		//if n is 2 then it is a prime number
		else if (num == 2 || num == 3) {
			return true;
		}
		//if n is divisible by 2 or 3 then it is not a prime number
		else if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}
		//check for divisibility for odd numbers up to sqrt(n)
		for (int i = 3; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;  //if it is divisible then not a prime number, return false immediately.
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		int n = 5000000;
		int count = new lc_204().countPrimes(n);
		System.out.println(count);
		
	}
}
