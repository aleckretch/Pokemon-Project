package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is the JFrame for the 
 * "Battle Info" screen
 */
public class BattleInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * constructs GUI to be displayed 
	 * upon selection of "Battle Info"
	 * in the "Game Info" Screen
	 */
	public BattleInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("BATTLE INFORMATION");
		l1.setBounds(39, 23, 298, 44);
		frame.getContentPane().add(l1);
		 l1.setFont(new Font("Baoli SC Regular", 3, 16));
		    l1.setForeground (Color.RED);
		
		JLabel l2 = new JLabel("<html>In battle the player has the option <BR> to either throw a rock, throw bait, <BR> throw a pokeball, or run. Throwing a rock <BR> will decrease the pokemon's HP and increase <BR> the players probability of catching the pokemon. <BR> Throwing bait will decrease the probability <BR> of the pokemon running. Throwing a ball<BR> will attempt to catch the pokemon. <BR>Running will exit the battle screen");
		l2.setBounds(49, 79, 481, 260);
		frame.getContentPane().add(l2);
	}
	
	
	public static void main(String[] args) {
		new BattleInfo();

	}

}
