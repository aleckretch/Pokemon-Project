//index temp
package view;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import view.Pokedex;

/**
 * This class is the JFrame 
 * for the opening screen
 * 
 *
 */
public class Index extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton b1;
	private JButton b3;
	private JButton b2;
	
	
	/**
	 * constructs the GUI for
	 * the opening screen. 
	 * 
	 */
	public Index() {
		
		frame = new JFrame();
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	
		frame.setSize(605,405);
		
		JLabel l1 = new JLabel("Click below to know more about Pokemon");
		l1.setFont(new Font("Baoli SC Regular", Font.BOLD, 13));
		l1.setForeground(Color.RED);
		l1.setBounds(26, 41, 292, 21);
		frame.getContentPane().add(l1);
	
	  b1 = new JButton("POKEDEX");
	  b1.setBounds(26, 69, 183, 50);
	  frame.getContentPane().add(b1);
	  b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()==b1)
			        {
					   MusicPlayer.playOnce("audio/Footstep01.wav");
			           Pokedex b1=new Pokedex();
			           b1.setVisible(false);

			        }
			        
			}
		});
		
		
		JLabel l2 = new JLabel("Click below to know more about Game");
		l2.setFont(new Font("Baoli SC Regular", Font.BOLD, 13));
		l2.setForeground(Color.RED);
		l2.setBounds(26, 155, 292, 21);
		frame.getContentPane().add(l2);
		
		b2 = new JButton("GAME INFO");
		b2.setBounds(26, 181, 183, 50);
		frame.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()==b2)
			        {
						MusicPlayer.playOnce("audio/Footstep01.wav");
			          GameInfo b2=new GameInfo();
			           b2.setVisible(false);

			        }
			        
			}
		});
		
		
		b3 = new JButton("CONTINUE");
		b3.setBounds(47, 304, 114, 50);
		frame.getContentPane().add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()==b3)
			        {
						MusicPlayer.playOnce("audio/Footstep01.wav");
			          SelectCharacter b3=new SelectCharacter();
			           b3.setVisible(false);
			           frame.setVisible(false);
			           dispose();
			        }
			        
			}
		});
		
		JLabel l4 = new JLabel("");
		l4.setIcon(new ImageIcon("pics/Background.png"));
		l4.setBounds(0, 0, 600, 400);
		//l4.setSize(600,400);
		l4.setSize(605,405);
		frame.getContentPane().add(l4);
		
	
		
	}
	public static void main(String args[])
    {
    	
		new Index();
    }
	
	

}

