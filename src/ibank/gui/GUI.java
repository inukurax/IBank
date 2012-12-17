/**
 * 
 */
package ibank.gui;


import ibank.*;
import ibank.accounts.IBankAccount;
import ibank.gui.GUI.BalanceButtonHandler;

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
	private JTextField accountTF;
	public static JComboBox accountsC;
    
    
	public static String title;
    public static String first;


	public GUI() {

		
	       accountL = new JLabel("Account #: ", SwingConstants.LEFT);
	        getBalanceB = new JButton("Get Balance");
	        getBalHandler = new BalanceButtonHandler();
	        getBalanceB.addActionListener(getBalHandler);
	        accountsC = new JComboBox();
	        accountTF = new JTextField(5);
	        

	               
	    		Container pane = getContentPane();
	    		pane.setLayout(new GridLayout(4, 2));
	    		
	    		//Add things to the pane in the order you want them to appear (left to right, top to bottom)
	    		pane.add(accountL);
	    		pane.add(accountTF);
	    		pane.add(getBalanceB);
	    		pane.add(accountsC);

	    		
	       		setTitle("IBank");
	    		setSize(WIDTH, HEIGHT);
	    		setVisible(true);
	    		setDefaultCloseOperation(EXIT_ON_CLOSE);


  
	}
	
	class BalanceButtonHandler implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (accountTF.getText().isEmpty())
				return;
			// TODO Auto-generated method stub
        ArrayList<IBankAccount> accounts = Test.bank.getAccounts(accountTF.getText());
		if (accounts != null &&
				accounts.size() > 0) {
			
			double value = Test.bank.getAccounts(
					accountTF.getText()).get(0).getBalance();
			
				System.out.println(value);
		}
		else if (accounts.size() > 0)
			System.out.println("No customer found with this " 
					+ accountTF.getText()+ " customer #");
		else 
			System.out.println("Customer " 
					+ accountTF.getText()+ "# has no accounts");
			
		}
		
	}

}
