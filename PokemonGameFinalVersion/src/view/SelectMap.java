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
 * This class is  the JFrame 
 * for the screen where the 
 * users selects the Map
 * 
 *
 */
public class SelectMap extends JFrame {
	
	
	private static final long serialVersionUID = 1L;


	
	//instance variables
	private JFrame frame;
	private JPanel panel;  // Display on Frame
	private JButton button1;  // component
	private JButton button2;
	private JButton button3;
	private JLabel label;  // component

	//private int playerNumber = 1;

	//declare the constructor
	public SelectMap(final int playerNumber){
		
		
	
		//Frame
		frame = new JFrame("POKEMON");
		frame.setVisible(true);  // set to Visible
		frame.setSize(599,399); //Refress it
		frame.setSize(600,400);  // Declare the size
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		// When you press the close buton then it close otherwise it don't close.
		
		// pannel button
		panel = new JPanel();
		
		//color panel
		panel.setBackground(Color.gray);
		
		//Declare Button
		button1 = new JButton("Map1");
		button1.setIcon(new ImageIcon("pics/map1.png"));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button1)
		        {	
					MusicPlayer.playOnce("audio/Footstep01.wav");
		            WinCondition button1=new WinCondition(1,playerNumber); // map 1 and character 1
		            button1.setVisible(false);
		            frame.setVisible(false);
			           dispose();
		           
		              
		        }
				
			}
		});
		
		
		button2 = new JButton("Map2");
		button2.setIcon(new ImageIcon("pics/map2.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2)
		        {
					MusicPlayer.playOnce("audio/Footstep01.wav");
					WinCondition button1=new WinCondition(2,playerNumber); // map 1 and character 1
		            button2.setVisible(false);
		            frame.setVisible(false);
			           dispose();
		           
		              
		        }
				
			}
		});
		
		
		button3 = new JButton("Map3");
		button3.setIcon(new ImageIcon("pics/map3.png"));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button3)
		        {
					MusicPlayer.playOnce("audio/Footstep01.wav");
					WinCondition button1=new WinCondition(3,playerNumber); // map 1 and character 1
		            button3.setVisible(false);
		            frame.setVisible(false);
			           dispose();
		           
		        }
				
			}
		});
		
		//Declare Label
		//label = new JLabel("");
		label = new JLabel("SELECT THE MAP");
		

		//Add button and Label on panel
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(label); // Add label
		
		
		
		
		// add panel into frame
		frame.add(panel, BorderLayout.CENTER);
		validate(); // validate the image when run it.
	
		
	}

	public static void main (String[] args){
		// create someting in main so then only it display GUI

	
		new SelectMap(2);
	
		
	}
	


	
   }



    

	
	
	

