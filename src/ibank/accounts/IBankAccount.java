package ibank.accounts;

public interface IBankAccount {
			
	public void deposit(double amount);
	
	public void withdraw(double amount);
	
	public double getBalance();
	
	public String getType();
	
	public String getName();
	
	public String info();

}
