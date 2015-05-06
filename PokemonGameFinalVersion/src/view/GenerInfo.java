package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is the JFrame for
 * the "General Information" screen
 */
public class GenerInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Constructs GUI that displays
	 * upon selection of the "General Info"
	 * button on the "Game Info" screen
	 */
	public GenerInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("GENERAL INFORMATION");
		l1.setBounds(39, 23, 298, 44);
		frame.getContentPane().add(l1);
		 l1.setFont(new Font("Baoli SC Regular", 3, 16));
		    l1.setForeground (Color.RED);
		
		JLabel l2 = new JLabel("<html>The game can be won by catching 5 pokemon <BR> or by catching Mew-Two. To find pokemon <BR>walk around in the dark grass. There are <BR>two characters and three maps to choose from. <BR>The game will end after the player has exhausted the maximum <BR> number of steps. Items can be found on the map that will be advantageous");
		l2.setBounds(49, 79, 481, 260);
		frame.getContentPane().add(l2);
	}
	
	
	public static void main(String[] args) {
		new GenerInfo();

	}

}
