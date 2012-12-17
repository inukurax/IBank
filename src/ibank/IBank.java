package ibank;

import ibank.accounts.IBankAccount;

import java.util.ArrayList;
import java.util.Random;

public class IBank {
	
	private ArrayList<IBankCustomer> customers;
	
	public IBank() {
		customers = new ArrayList<IBankCustomer>();
	}
	
	public String randomCustNumber() {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < 8;i++) {
			int rand = random.nextInt(9);
			str = str + Integer.toString(rand);
		}
		if (isNotUsed(new IBankCustomer(str))) {
			return str;	
		}
		else 
			return this.randomCustNumber();
	}
	
	public boolean isNotUsed(IBankCustomer customer) {
		boolean newCustomer = true;
		for (IBankCustomer enties : customers) {
			if (enties.getCustomerNumber().equalsIgnoreCase(
					customer.getCustomerNumber())) {
				newCustomer = false;
				break;
			}
		}
		return newCustomer;
		
	}
	/**
	 * Adds new Customer with random unused customer#
	 * @param customer
	 */
	public void addCustomer() {
		IBankCustomer customer = new IBankCustomer(this.randomCustNumber());
		customers.add(customer);
		System.out.println("Added new customer, with customer# : " 
				+ customer.getCustomerNumber());	
		
	}
	/**
	 * Adds new customer.
	 * Will not add if customer# is already in use.
	 * @param IBankCustomer-
	 */
	public void addCustomer(IBankCustomer customer) {
		if (isNotUsed(customer)) {
		customers.add(customer);
		System.out.println("Added new customer, with customer# : " 
				+ customer.getCustomerNumber());	
		}
		else {
			System.out.println("Allready a customer with customer# : " 
				+ customer.getCustomerNumber());
		}
		
	}
	public ArrayList<IBankAccount> getAccounts(String customer) {
		String str = customer.toLowerCase();
		for (IBankCustomer cust : this.customers) {
			if (cust.getCustomerNumber().toLowerCase().contains(str)
					&& str.length() >= 8)
				return cust.getAccounts();
		}
		return null;
	}
	
	public IBankCustomer getCustomer(String str) {
		String str2 = str.toLowerCase();
		for (IBankCustomer customer : this.getCustomers()) {	
			if (customer.getCustomerNumber().toLowerCase().contains(str2)
					&& str2.length() >= 8)
				return customer;
			
		} 
		return null;
	}
	
	public ArrayList<IBankCustomer> getCustomers() {
		return customers;
	}

}
