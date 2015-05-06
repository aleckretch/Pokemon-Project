package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * This class is the JFrame for 
 * the screen where the user 
 * selects the character
 */
public class SelectCharacter extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	//instance variables
	private JFrame frame;
	private JPanel panel;  // Display on Frame
	private JButton button1;  // component
	private JButton button2;
	private JLabel label;  // component
	
	
	//declare the constructor
	public SelectCharacter(){
		gui();
	}
	
	/**
	 * constructs GUI for the "Select
	 * Character" screen
	 */
	public void gui(){
		//Frame
		frame = new JFrame("Select Character");
		frame.setVisible(true);  // set to Visible
		frame.setSize(599,399); //Refress it
		frame.setSize(600,400);  // Declare the size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		// When you press the close buton then it close otherwise it don't close.
		
		// pannel button
		panel = new JPanel();
		
		//color panel
		panel.setBackground(Color.gray);
		
		//Declare Button
		button1 = new JButton("Mr A");
		button1.setIcon(new ImageIcon("pics/char1.png"));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button1)
		        {
					MusicPlayer.playOnce("audio/Footstep01.wav");
		            SelectMap button1=new SelectMap(1);
		            button1.setVisible(false);
			        frame.setVisible(false);
			        dispose();
		            
		              
		        }
			}
		});
		
		
		button2 = new JButton("Mr B  ");
		button2.setIcon(new ImageIcon("pics/char2.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2)
		        {
					MusicPlayer.playOnce("audio/Footstep01.wav");
		            SelectMap button2=new SelectMap(2);
		            button2.setVisible(false);
		            frame.setVisible(false);
			           dispose();
		            
		            
		              
		        }
				
			}
		});
		
		
		
		//Declare Label
		//label = new JLabel("");
		label = new JLabel("SELECT THE CHARACTER");
		label.setForeground (Color.BLUE);
		

		//Add button and Label on panel
		panel.add(button1);
		panel.add(button2);
	
		panel.add(label); // Add label
		
		
		
		
		// add panel into frame
		frame.add(panel, BorderLayout.CENTER);
		validate(); // validate the image when run it.
	
		
		
	}



	
	public static void main (String[] args){
		// create someting in main so then only it display GUI

	
		new SelectCharacter();
		
	}
	


	
   }
