package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class SelectMap extends JFrame {
	
	private static final Object MapA = null;
	//instance variables
	private JFrame frame;
	private JPanel panel;  // Display on Frame
	private JButton button1;  // component
	private JButton button2;
	private JButton button3;
	private JLabel label;  // component
	private Object map;
	private Object mapA;

	
	//declare the constructor
	public SelectMap(){
		gui();
	}
	
	//Declare the method
	public void gui(){
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
		button1 = new JButton("MapA");
		button1.setIcon(new ImageIcon("pics/Map1.png"));
		button2 = new JButton("MapB");
		button2.setIcon(new ImageIcon("pics/Map1.png"));
		
		button3 = new JButton("MapC");
		button3.setIcon(new ImageIcon("pics/Map1.png"));
		
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

	
		new SelectMap();
		
	}
	


	
   }