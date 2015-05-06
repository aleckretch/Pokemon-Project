package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the JFrame for
 * the "Items Info" screen
 * 
 *
 */
public class ItemsInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * constructs GUI to be displayed
	 * upon selection of "Items Info"
	 * on the "Game Info" screen
	 */
	public ItemsInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		/*
		JLabel l1 = new JLabel("ITEMS INFORMATION");
		l1.setBounds(39, 23, 298, 44);
		frame.getContentPane().add(l1);
		 l1.setFont(new Font("Baoli SC Regular", 3, 16));
		    l1.setForeground (Color.RED); */
		
		JLabel l1 = new JLabel("<html>ITEMS INFORMATION: Items can<BR>be found int the form of<BR>a pokeball. The item will provide<BR>one of three advantages.");
		l1.setBounds(39, 23, 298, 44);
		
		JLabel item1 = new JLabel("<html>1. Additional Steps: increases <BR> maximum number of steps");
		JLabel item2 = new JLabel("<html>2. Safari Balls: changes pokeballs<BR>to safari balls. Which increases<BR> catch probability");
		JLabel item3 = new JLabel("<html>3. HP Show: displays the pokemons HP in battle");
		
		JPanel panel = new JPanel(new GridLayout(1,3));
		panel.add(item1);
		panel.add(item2);
		panel.add(item3);
		
		frame.setLayout(new BorderLayout());
		frame.add(l1, BorderLayout.NORTH);
		frame.add(panel,BorderLayout.CENTER);
	
	}
	
	
	public static void main(String[] args) {
		new ItemsInfo();

	}

}