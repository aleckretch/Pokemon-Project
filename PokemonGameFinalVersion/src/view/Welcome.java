package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import view.Index;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * This class is the JFrame for 
 * the welcome screen
 *
 */
public class Welcome extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;

		
	
	private JButton b1;
	private JLabel l1;
	
	
	/**
	 * constructs GUI for the welcome
	 * screen of the game
	 */
	    public Welcome()
	    {
	    setTitle("Welcome To The Pokemon");
	    setSize(600,400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	
	    
	    BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("pics/Background.png"));
		} catch (IOException e) {
		    e.printStackTrace();   
		}
		
	  
		Image dimg = img.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		setContentPane(new JLabel(imageIcon));
	    
		
		setLayout(new FlowLayout());
	  
	    l1 = new JLabel("WELCOME TO THE WORLD OF POKEMON");
	    l1.setFont(new Font("Baoli SC Regular", 3, 26));
	    l1.setForeground (Color.RED);
	   
	    
	    b1=new JButton("Next");
	
	    
	    b1.setFont(new Font("Baoli SC Regular", 3, 26));
	    
	    b1.setIcon(new ImageIcon("pics/NextButton.png"));
	    
	    add(b1);
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
		        {	
					MusicPlayer.play("audio/Footstep01.wav");
		            Index b1=new Index();
		            b1.setVisible(false);
		            dispose();
		            
		            
		        }
			}
		});

	   
	   
	    add(l1);
	    
	    //Validated it.
	    validate();
	    
	    // Just for refresh :) Not optional!
	    setSize(599,399);
	    
	    }
	    
   
    
    public static void main(String[] args) {
    	new Welcome();
        
    

    }

	
} 