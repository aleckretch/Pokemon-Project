package creatures;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * creates the pokemon for the Pokedex
 */
public class Pidgey extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Pidgey() {

		frame = new JFrame("PIDGEY");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("");
		l1.setBounds(6, 6, 239, 237);
		frame.getContentPane().add(l1);
		l1.setIcon(new ImageIcon("pics/pidgeyLarge.png"));


		
		JLabel l2 = new JLabel("HEIGHT");
		l2.setForeground(Color.RED);
		l2.setBounds(262, 34, 101, 32);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("CATEGORY");
		l3.setForeground(Color.RED);
		l3.setBounds(416, 34, 101, 32);
		frame.getContentPane().add(l3);
		
		JLabel l4 = new JLabel("WEIGHT");
		l4.setForeground(Color.RED);
		l4.setBounds(262, 119, 101, 32);
		frame.getContentPane().add(l4);
		
		JLabel l5 = new JLabel("ABILITIES");
		l5.setForeground(Color.RED);
		l5.setBounds(416, 119, 101, 32);
		frame.getContentPane().add(l5);
		
		JLabel l6 = new JLabel("TYPES");
		l6.setForeground(Color.RED);
		l6.setBounds(35, 255, 101, 32);
		frame.getContentPane().add(l6);
		
		JLabel l7 = new JLabel("WEAKNESS");
		l7.setForeground(Color.RED);
		l7.setBounds(207, 255, 101, 32);
		frame.getContentPane().add(l7);
		
		JLabel l8 = new JLabel("Tiny Birds");
		l8.setBounds(416, 78, 90, 16);
		frame.getContentPane().add(l8);
		
		JLabel l9 = new JLabel("1.5'");
		l9.setBounds(272, 78, 90, 16);
		frame.getContentPane().add(l9);
		
		JLabel l10 = new JLabel("Tangled Feet");
		l10.setBounds(427, 163, 90, 16);
		frame.getContentPane().add(l10);
		
		JLabel l11 = new JLabel("Keen eye");
		l11.setBounds(427, 202, 90, 16);
		frame.getContentPane().add(l11);
		
		JLabel l12 = new JLabel("1.0lb");
		l12.setBounds(273, 163, 90, 16);
		frame.getContentPane().add(l12);
		
		JLabel l13 = new JLabel("Normal");
		l13.setBounds(45, 301, 90, 16);
		frame.getContentPane().add(l13);
		
		JLabel l14 = new JLabel("Rock");
		l14.setBounds(232, 299, 90, 16);
		frame.getContentPane().add(l14);
		
		JLabel l15 = new JLabel("Flying");
		l15.setBounds(46, 330, 90, 16);
		frame.getContentPane().add(l15);
		
		JLabel l16 = new JLabel("BASE STATS");
		l16.setForeground(Color.RED);
		l16.setBounds(405, 255, 101, 32);
		frame.getContentPane().add(l16);
		
		JLabel l17 = new JLabel("HP:  100");
		l17.setBounds(416, 299, 90, 16);
		frame.getContentPane().add(l17);
	}
	
	public static void main(String[] args) {
		
		new Pidgey();
	}
}
	
