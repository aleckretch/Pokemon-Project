package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Welcome extends JFrame implements MouseListener {
	
	
		private static final Container con = null;
		/*
	private static final String Background = null;
	private static final String BoaderLayout = null;
	private static final Container frame = null;
	*/
	
	private JButton b1;
	private JLabel l1;
	
	
	
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
		
		
		ImageIcon img1 = new ImageIcon("pics/pokemon.png");
	    l1=new JLabel(img1); 
		
	  
		
	    l1 = new JLabel("WELCOME TO THE WORLD OF POKEMON");
	    l1.setFont(new Font("Baoli SC Regular", 3, 26));
	    l1.setForeground (Color.RED);
	   
	    
	    b1=new JButton("Next");
	    //con.add(b1);
        
	    
	    b1.setFont(new Font("Baoli SC Regular", 3, 26));
	    
	    b1.setIcon(new ImageIcon("pics/NextButton.png"));
	    
	    add(b1);
	    b1.addMouseListener(this);
	   
	    add(l1);
	    
	    //Validated it.
	    validate();
	    
	    // Just for refresh :) Not optional!
	    setSize(599,399);
	    
	    }
    
    public static void main(String args[])
    {
    	
    new Welcome();
    }

    
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==b1)
        {
            SelectMap b1=new SelectMap();
            b1.setVisible(false);
        }
        
	
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
} 