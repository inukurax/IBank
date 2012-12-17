package ibank;
import ibank.accounts.IBankAccount;

import java.util.ArrayList;

public class IBankCustomer {
	
	private String number;
	ArrayList<IBankAccount> account;
	
	/**
	 * Adds a customer without any accounts
	 * with a customer# of 8 digits between 0-9
	 * Saved as a string because of pre zeros.
	 * @param customerNumber
	 */
	public IBankCustomer(String customerNumber) {
		this.number = "IBank#" + customerNumber;
		this.account = new ArrayList<IBankAccount>();
	}
	
	/**
	 * Adds a IBankAccount to IBankCustomer 
	 * with unique account name.
	 * @param acc non null IBankAccount
	 */
	public void addAccount(IBankAccount acc) {
		for (IBankAccount act : account) {
			if (act.getName().equals(acc.getName())) {
				System.out.println("Account name is already in use!");
				return;
			}
		}
		account.add(acc);
	}
	
	public void removeAccount(IBankAccount acc) {
		int index = -1;
		for (int i = 0; i < account.size();i ++) {
			if (account.get(i).equals(acc)) {
				index = i;
				break;
			}
		}
		account.remove(index);
	}
	
	public String getCustomerNumber() {
		return number;
	}
	
	public ArrayList<IBankAccount> getAccounts() {
		return account;
	}
	
	public int numbersOfAccount() {
		return account.size();
	}
	
	public void printAccounts() {

		System.out.println(this.getCustomerNumber());
		if (account.isEmpty())
			System.out.println("No accounts");
		else {
			System.out.println("You have: " + numbersOfAccount() + " accounts");
	
			for  (IBankAccount acc : account) {
				System.out.println(acc.info());
			}
		}

	}
}
