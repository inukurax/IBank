/**
 * 
 */
package ibank.gui;

import javax.swing.JFrame;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public abstract class GUI extends JFrame {
    
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	public GUI() {
		setTitle("Sample Title: Area of a Rectangle");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
