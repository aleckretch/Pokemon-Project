
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * This class is the JFrame 
 * for the "Maps Info" screen
 *
 */
public class MapsInfo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * constructs GUI to be displayed
	 * upon selection of "Maps Info"
	 * on the "Game Info" screen
	 */
	public MapsInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("MAPS INFORMATION");
		l1.setBounds(39, 23, 298, 44);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(l1, BorderLayout.NORTH);
		l1.setFont(new Font("Baoli SC Regular", 3, 16));
	    l1.setForeground (Color.RED); 

		
		JLabel l2 = new JLabel("<html> There are three map to <br>choose from");
		l2.setBounds(39, 23, 298, 44);
		frame.getContentPane().add(l2);
		 
		
				
		ImageIcon icon1 = new ImageIcon("pics/map1.png");
		ImageIcon icon2 = new ImageIcon("pics/map2.png");
		ImageIcon icon3 = new ImageIcon("pics/map3.png");
			
		JLabel map1 = new JLabel(icon1);
		JLabel map2 = new JLabel(icon2);
		JLabel map3 = new JLabel(icon3);
		
		frame.getContentPane().add(map1,BorderLayout.WEST);
		frame.getContentPane().add(map2,BorderLayout.CENTER);
		frame.getContentPane().add(map3,BorderLayout.EAST);
		
		
	}
	
	
	public static void main(String[] args) {
		new MapsInfo();

	}

}
