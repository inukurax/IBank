

import ibank.*;
import ibank.accounts.*;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBank bank = new IBank();

		String cusN1 = bank.randomCustNumber();
		String cusN2 = "12345678";
		IBankCustomer newCustomer = new IBankCustomer(cusN1);
		IBankCustomer newCustomer2 = new IBankCustomer(cusN2);

		bank.addCustomer(newCustomer);
		bank.addCustomer(newCustomer2);

		IBankAccount newAccount = new CheckingAccount(200);
		bank.getCustomer(cusN1).addAccount(newAccount);
		IBankAccount oldAccount = bank.getAccounts(cusN1).get(0);
		oldAccount.deposit(1000);

		IBankAccount newAccount2 = new CheckingAccount(0);
		bank.getCustomers().get(0).addAccount(newAccount2);
		IBankAccount oldAccount2 = bank.getAccounts(cusN1).get(1);
		oldAccount2.deposit(1000);
		
		
		IBankAccount newAccount3 = new SavingsAccount(10000, 2);
		bank.getCustomers().get(0).addAccount(newAccount3);
		bank.getCustomer(cusN1).addAccount(newAccount3);
		int acc = bank.getCustomer(cusN1).numbersOfAccount();

		bank.getCustomer(cusN1).printAccounts();
		bank.getCustomer(cusN2).printAccounts();		

	
	}
}
