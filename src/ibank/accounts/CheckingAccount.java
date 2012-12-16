package ibank.accounts;

public class CheckingAccount implements IBankAccount {
	
	private double balance;
	private int transaction = 0;
	/**
	 * Creates a new CheckingAccount with a balance = 0
	 */
	public CheckingAccount () {
		this.balance = 0;
	}
	/**
	 * Creates a new CheckingAccount with a start balance
	 * @param double > 0
	 */
	public CheckingAccount (final double initialBalance) {
		if (initialBalance > 0)
			this.balance = initialBalance;
		else
			this.balance = 0;
	}
	
	/**
	 * Should only be called once each month.
	 * And only if transaction is larger than 5.
	 */
	@SuppressWarnings("unused")
	private void deductFees() {
		balance = balance + (7.0 * (transaction - 5));
		transaction = 0;
	}
	
	/**
	 * Adds money to a CheckingAccount
	 */
	@Override
	public void deposit(final double amount) {
		balance = balance + amount;
		transaction++;
	}

	/**
	 * Withdraws amount from CheckingAccount
	 * if balance is greater than amount
	 */
	@Override
	public void withdraw(final double amount) {
		if (balance > amount) {
			balance = balance - amount;
			transaction++;
		}
	}
	/**
	 * Accessor method for getting balance
	 */
	@Override
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Accessor method for getting type of account
	 */
	@Override
	public String type() {
		return "Checking account:";
	}
	
	/**
	 * Accessor method for getting all info on account
	 */
	@Override
	public String info() {
		return String.format(type() + " Balance = %.2f", getBalance());
	}


}
