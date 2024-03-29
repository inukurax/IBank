package ibank.gui;


import javax.swing.JComboBox;

import ibank.*;
import ibank.accounts.*;


public class Test{

	/**
	 * @param args
	 */
	static IBank bank;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI.title = "test";
		GUI newGui = new GUI();
		bank = new IBank();

		String cusN1 = bank.randomCustNumber();
		String cusN2 = "12345678";
		IBankCustomer newCustomer = new IBankCustomer(cusN1);
		IBankCustomer newCustomer2 = new IBankCustomer(cusN2);

		bank.addCustomer(newCustomer);
		bank.addCustomer(newCustomer2);

		IBankAccount newAccount = new CheckingAccount("Knud",200);
		bank.getCustomer(cusN1).addAccount(newAccount);
		IBankAccount oldAccount = bank.getAccounts(cusN1).get(0);
		oldAccount.deposit(1000);

		IBankAccount newAccount2 = new CheckingAccount("Lån");
		bank.getCustomers().get(0).addAccount(newAccount2);
		IBankAccount oldAccount2 = bank.getAccounts(cusN1).get(1);
		oldAccount2.deposit(1000);
		
		
		IBankAccount newAccount3 = new SavingsAccount("Opsparing1",10000, 2);
		bank.getCustomers().get(0).addAccount(newAccount3);
		bank.getCustomer(cusN1).addAccount(newAccount3);
		int acc = bank.getCustomer(cusN1).numbersOfAccount();

		bank.getCustomer(cusN1).printAccounts();
		bank.getCustomer(cusN2).printAccounts();		

	
	}
}
