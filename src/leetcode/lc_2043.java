

package leetcode;

public class lc_2043 {

	public static void main(String[] args) {
		//["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
		// [[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]

		Bank bank = new Bank(new long[] { 10, 100, 20, 50, 30 });
		bank.withdraw(3, 10);
		bank.transfer(5, 1, 20);
		bank.deposit(5, 20);
		bank.transfer(3, 4, 15);
		bank.withdraw(10, 50);

	}
}

class Bank {
	private long[] balance;

	public Bank(long[] balance) {
		this.balance = balance;
	}

	public boolean transfer(int account1, int account2, long money) {
		int account1Index = account1 - 1;
		int account2Index = account2 - 1;
		if (account1Index < 0 || account1Index >= balance.length) {
			return false;
		}
		if (account2Index < 0 || account2Index >= balance.length) {
			return false;
		}
		long currBalance = balance[account1Index];
		if (currBalance < money) {
			return false;
		}
		balance[account1Index] -= money;
		balance[account2Index] += money;
		return true;
	}

	public boolean deposit(int account, long money) {
		int accountIndex = account - 1;
		if (accountIndex < 0 || accountIndex >= balance.length) {
			return false;
		}
		balance[accountIndex] += money;
		return true;

	}

	public boolean withdraw(int account, long money) {
		int accountIndex = account - 1;
		if (accountIndex < 0 || accountIndex >= balance.length) {
			return false;
		}
		long currBalance = balance[accountIndex];
		if (currBalance < money) {
			return false;
		}
		balance[accountIndex] -= money;
		return true;

	}
}
