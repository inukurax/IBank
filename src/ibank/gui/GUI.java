/**
 * 
 */
package ibank.gui;


import ibank.*;
import ibank.accounts.IBankAccount;
import ibank.gui.GUI.BalanceButtonHandler;
import ibank.gui.GUI.CostumerTextHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class GUI extends JFrame {
    
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	JButton areaL;
	private JButton getBalanceB;
	private BalanceButtonHandler getBalHandler;
	private JLabel accountL;
	private JTextField customerTF;
	private CostumerTextHandler customerTextHandler;
	private JButton depositeB;
	private JTextField amountTF;
	private JButton withdrawB;
	private JLabel amountL;
	public static JComboBox accountsC;
    
    
	public static String title;


	public GUI() {

		
	       accountL = new JLabel("Account #: ", SwingConstants.LEFT);
	       amountL = new JLabel("Enter amount: ", SwingConstants.LEFT);


	       	//
	        customerTF = new JTextField(5);
	        customerTextHandler = new CostumerTextHandler();
	        customerTF.addActionListener(customerTextHandler);
	        
	        amountTF = new JTextField(5);

	        
	        accountsC = new JComboBox();

	        // Buttons
	        getBalanceB = new JButton("Get Balance");
	        getBalHandler = new BalanceButtonHandler();
	        getBalanceB.addActionListener(getBalHandler);
	        
	        depositeB = new JButton("Deposite");
	       // depositeHandler = new DepositeButtonHandler();
	       // depositeB.addActionListener(depositeHandler);
	        withdrawB = new JButton("Withdraw");

	        

	               
	    		Container pane = getContentPane();
	    		pane.setLayout(new GridLayout(4, 2));
	    		
	    		//Add things to the pane in the order you want them to appear (left to right, top to bottom)
	    		pane.add(accountL);
	    		
	    		pane.add(customerTF);
	    		pane.add(accountsC);
	    		accountsC.setEnabled(false);
	    		pane.add(getBalanceB);
	    		getBalanceB.setEnabled(false);
	    		
	    		pane.add(amountL);
	    		pane.add(amountTF);
	    		pane.add(depositeB);
	    		pane.add(withdrawB);
	    		
	    		setTitle("IBank");
	    		setSize(WIDTH, HEIGHT);
	    		setVisible(true);
	    		setDefaultCloseOperation(EXIT_ON_CLOSE);


			
				}


  
	class CostumerTextHandler implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
    		if (accountsC.getItemCount() > 0) {
    			getBalanceB.setEnabled(true);
    			accountsC.setEnabled(true);
    		}
    		else {
    			getBalanceB.setEnabled(false);
    			accountsC.setEnabled(false);
    		}

				
        ArrayList<IBankAccount> accounts = Test.bank.getAccounts(customerTF.getText());
		if (accounts != null && accounts.size() > 0 &&
				accountsC.getItemCount() == 0) {
			for (IBankAccount acc : accounts) {
				accountsC.addItem(acc.getType() + acc.getName());
			}
		}
		if (accounts == null)
			accountsC.removeAllItems();
				
			
		
		}
	}
		
	

	
	class BalanceButtonHandler implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (customerTF.getText().isEmpty())
				return;
			// TODO Auto-generated method stub
		if (Test.bank.getAccounts(customerTF.getText()) != null) {
        ArrayList<IBankAccount> accounts = Test.bank.getAccounts(customerTF.getText());
		if (accounts != null &&
				accounts.size() > 0) {
			
			int accNumb = accountsC.getSelectedIndex();
			double value = Test.bank.getAccounts(
					customerTF.getText()).get(accNumb).getBalance();
			
				System.out.println(value);
		}
		else if (accounts.size() > 0)
			System.out.println("No customer found with this " 
					+ customerTF.getText()+ " customer #");
		else 
			System.out.println("Customer " 
					+ customerTF.getText()+ "# has no accounts");
			
		}
		}
		
	}

}
