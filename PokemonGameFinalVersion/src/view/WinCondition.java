package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * This class is the JFrame for the 
 * "Win Condition" selection screen
 */
public class WinCondition extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel l1;
	private JButton b1;
	private JButton b2;
	
	/**
	 * constructs GUI for the screen 
	 * where the user selects a win condition
	 * 	
	 * @param mapNumber determines which map is used
	 * @param playerNumber determines which player is used
	 */
	public WinCondition(final int mapNumber, final int playerNumber) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		l1 = new JLabel("WIN CONDITION");
		l1.setBounds(73, 6, 332, 63);
		frame.getContentPane().add(l1);
		l1.setFont(new Font("Baoli SC Regular", 3, 26));
	    l1.setForeground (Color.RED);
	    
		
		
		b1 = new JButton("Catching 5 Pokemon");
		b1.setBounds(43, 107, 184, 175);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
		        {	
		            FrogRunner b1=new FrogRunner(mapNumber,playerNumber, 1); // map 1 and character 1
		            b1.setVisible(false);
		            frame.setVisible(false);
			        frame.dispose();
		           
		              
		        }
				
			}
		});
		
		b2 = new JButton("MewTwo");
		b2.setBounds(242, 107, 184, 175);
		frame.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b2)
		        {
		            FrogRunner b2=new FrogRunner(mapNumber,playerNumber,2);  // map2 and character 2 
		            b2.setVisible(false);
		            frame.setVisible(false);
			        frame.dispose();
		           
		              
		        }
				
			}
		});
		
	
	}
	

	
}
