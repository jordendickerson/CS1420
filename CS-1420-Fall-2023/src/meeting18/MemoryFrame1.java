package meeting18;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class implements a Memory Game GUI.
 * This is also a program for creating and launching the GUI
 * (see the main method).
 * 
 * This is the first version of the GUI built in class, 
 * just an "empty" JFrame.
 * 
 * @author Prof. Parker
 * @version November 6, 2023
 */
public class MemoryFrame1 extends JFrame {

	/**
	 * Creates a Memory Game GUI.
	 */
	public MemoryFrame1() {
		
		// Exit on close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create a container to hold and organize the 16 buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		// Set up the JFrame.
		this.setTitle("Memory");
		this.setContentPane(panel);
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
}