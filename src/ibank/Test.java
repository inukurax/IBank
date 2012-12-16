package ibank;

import ibank.accounts.CheckingAccount;
import ibank.accounts.IBankAccount;
import ibank.accounts.SavingsAccount;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBank bank = new IBank();

		String cusN1 = bank.randomCustNumber();
		IBankCustomer newCustomer = new IBankCustomer(cusN1);
		bank.addCustomer(newCustomer);
		System.out.println("Is " + cusN1 + " not in use? " 
				+ bank.isNotUsed(newCustomer));
		IBankAccount newAccount = new CheckingAccount(200);
		bank.customers.get(0).addAccount(newAccount);
		IBankAccount oldAccount = bank.getAccounts(newCustomer).get(0);
		oldAccount.deposit(1000);
		System.out.println("Balance on " + newCustomer.getCustomerNumber() +": " 
				+ oldAccount.getBalance());
		System.out.println("Number of account: " + newCustomer.numbersOfAccount());
		
		IBankAccount newAccount2 = new CheckingAccount(0);
		bank.customers.get(0).addAccount(newAccount2);
		IBankAccount oldAccount2 = bank.getAccounts(newCustomer).get(1);
		oldAccount2.deposit(1000);
		System.out.println("Balance on " + newCustomer.getCustomerNumber() +": " 
				+ oldAccount2.getBalance());
		System.out.println("Number of account: " + newCustomer.numbersOfAccount());
		
		IBankAccount newAccount3 = new SavingsAccount(1000, 0.5);
		bank.customers.get(0).addAccount(newAccount3);

		bank.customers.get(0).printAccounts();		
	
	}
}
