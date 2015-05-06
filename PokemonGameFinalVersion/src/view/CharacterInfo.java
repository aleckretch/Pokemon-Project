package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/** 
 * This class is the GUI displayed
 * when "Character Info" is selected
 * from the "Game Info" screen
 *
 */
public class CharacterInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * The constructor constructs the GUI
	 * to be displayed upon the selection of
	 * CharacterInfo
	 */
	public CharacterInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		
		    JLabel l2 = new JLabel("<html>CHARACTER INFORMATION: There are two <BR>characters to choose from");
			l2.setBounds(39, 23, 298, 44);
			frame.setLayout(new BorderLayout());
			frame.add(l2, BorderLayout.NORTH);
			
			ImageIcon icon1 = new ImageIcon("pics/char1.png");
			ImageIcon icon2 = new ImageIcon("pics/char2.png");
			
			JLabel char1 = new JLabel(icon1);
			JLabel char2 = new JLabel(icon2);
			
			frame.add(char1, BorderLayout.WEST);
			frame.add(char2, BorderLayout.EAST);
	}
	
	
	public static void main(String[] args) {
		new CharacterInfo();

	}

}
