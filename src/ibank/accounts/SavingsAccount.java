package ibank.accounts;

/**
 * Class for SavingsAccount
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class SavingsAccount implements IBankAccount {
	
	private double balance;
	private double rate;
	private final double DEFAULT_RATE = 1.02;
	
	/**
	 * Creates new SavingsAccount with balance = 0
	 * and default rate of 2%
	 */
	public SavingsAccount () {
		this.balance = 0;
		this.rate = DEFAULT_RATE ;
	}
	
	/**
	 * Creates a SavingsAccount with set balance and rate
	 * @param initialBalance integer > 0
	 * @param rate
	 */
	public SavingsAccount (final double initialBalance, final double rate) {
		if (initialBalance >= 0)  
			this.balance = initialBalance;		
		this.rate = rate;
	}
	
	void addInterest() {
		if (balance > 0)
		balance = balance + (balance * rate);
	}
	
	/**
	 * Adds amount to account
	 */
	@Override
	public void deposit(final double amount) {
			balance = balance + amount;
	}
	/**
	 * Withdraws amount from account if
	 * amount greater than balance
	 */
	@Override
	public void withdraw(final double amount) {
		if (balance > amount)
			balance = balance - amount;
	}
	
	/**
	 * Accessor method for getting balance
	 */
	@Override
	public double getBalance() {
		return balance;
	}
	/**
	 * Accessor method for getting rate
	 */
	public double getRate() {
		return rate;
	}
	
	/**
	 * Accessor method for getting type of account
	 */
	@Override
	public String type() {
		return "SavingsAccount:";
	}

}
