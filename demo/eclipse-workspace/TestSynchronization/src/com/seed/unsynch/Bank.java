package com.seed.unsynch;

public class Bank {
	private AccountHolder accounts[] = new AccountHolder[5];

	public Bank() {
		for (int id = 0; id < accounts.length; id++) {
			accounts[id] = new AccountHolder(id, 5000);
		}
	}

	void transferAmount(int toAcc, int fromAcc, double amt)
			throws InterruptedException {
		System.out.println("\nTransferring from " + fromAcc + " into " + toAcc);

		synchronized(accounts[fromAcc]){
			synchronized(accounts[toAcc]){
				accounts[fromAcc].withdraw(amt);
				accounts[toAcc].deposit(amt);
			}
		}
	}

	void showTotalBalance() {
		double totalBalance = 0;

		for (AccountHolder account : accounts) {
			totalBalance += account.getBalance();
		}

		System.out.println("Total Balance in bank: " + totalBalance);
	}
}
