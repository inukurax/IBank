package ibank.accounts;

/**
 * Class for SavingsAccount
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class SavingsAccount implements IBankAccount {
	
	private double balance;
	private double rate;
	private final double DEFAULT_RATE = 2;
	private String name;
	
	/**
	 * Creates new SavingsAccount with balance = 0
	 * and default rate of 2%
	 * @param Name of Savings Account
	 */
	public SavingsAccount (final String name) {
		this.name = name;
		this.balance = 0;
		this.rate = DEFAULT_RATE ;
	}
	
	/**
	 * Creates a SavingsAccount with set balance and rate
	 * @param initialBalance integer > 0
	 * @param rate
	 */
	public SavingsAccount (final String name ,
			final double initialBalance, final double rate) {
		this.name = name;
		if (initialBalance >= 0)  
			this.balance = initialBalance;		
		this.rate = rate;
	}
	
	void addInterest() {
		double interest = (balance * rate) / 100;
		if (balance > 0)
		balance = balance + (balance + interest);
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
	public String getType() {
		return "Savings account:";
	}
	
	/**
	 * Accessor method for getting name of account
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * Accessor method for getting all info on an account
	 */
	@Override
	public String info() {
		return String.format(getType() + " Balance = %.2f , Rate = %.1f%%", 
				getBalance() ,getRate());
		
	}

}
