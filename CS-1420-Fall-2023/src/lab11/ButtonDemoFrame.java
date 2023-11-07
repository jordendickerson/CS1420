package lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonDemoFrame extends JFrame implements ActionListener{
	
	private static final String YELLOW_ICON = "src/lab11/smileys/smileYellow.png";
	private static final String PINK_ICON = "src/lab11/smileys/smilePink.png";
	private static final String YELLOW_PRESSED_ICON = "src/lab11/smileys/smileYellowPressed.png";
	private static final String PINK_PRESSED_ICON = "src/lab11/smileys/smilePinkPressed.png";
	
	private JButton button;
	private int clickCount;
	private boolean isYellow;
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
	
	public ButtonDemoFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Button Demo"); 
		
		clickCount = 0;
		isYellow = true;
		button = new JButton("clicked " + clickCount + " times", new ImageIcon(YELLOW_ICON));
		
		JPanel panel = new JPanel();
		
		button.setPreferredSize(new Dimension(300, 150));
		button.setPressedIcon(new ImageIcon(YELLOW_PRESSED_ICON));
		button.setBackground(Color.red);
		button.setBorderPainted(false);
		button.setOpaque(isYellow);
		button.addActionListener(this);
		panel.add(button);
		
		this.setContentPane(panel);
		this.pack();
	}
	
	public void actionPerformed(ActionEvent event) {
		clickCount++;
		button.setText("clicked " + clickCount + " times");
		
		if (isYellow) {
			isYellow = false;
			button.setIcon(new ImageIcon(PINK_ICON));
			button.setPressedIcon(new ImageIcon(PINK_PRESSED_ICON));
		}
		else {
			isYellow = true;
			button.setIcon(new ImageIcon(YELLOW_ICON));
			button.setPressedIcon(new ImageIcon(YELLOW_PRESSED_ICON));
		}
		button.setOpaque(isYellow);
	}
}
