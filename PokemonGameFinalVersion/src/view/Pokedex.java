package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import creatures.Beedrill;
import creatures.Clefable;
import creatures.Ekans;
import creatures.Mankey;
import creatures.Mewtwo;
import creatures.NidoranFemale;
import creatures.NidoranMale;
import creatures.Pidgey;
import creatures.Pikachu;
import creatures.Rattata;


/**
 * This class is the JFrame for
 * the pokedex. It displays the pokemon
 * and all of their stats
 */
public class Pokedex extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b10;
	
	/**
	 * contstrucs GUI to be displayed 
	 * upon the selection of "Pokedex"
	 * 
	 * provides information on each
	 * pokemon in the game
	 */
	public Pokedex() {
		
		frame = new JFrame();
		frame.setSize(599,399);
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JLabel l1 = new JLabel("POKEDEX");
		l1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		l1.setBounds(127, 17, 119, 33);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Click on image to see the Pokemon's information");
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		l2.setBounds(56, 62, 369, 26);
		frame.getContentPane().add(l2);
		
	    b1 = new JButton("   EKANS");
		b1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b1.setIcon(new ImageIcon("pics/ekans.png"));
		b1.setBounds(66, 96, 154, 53);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
		        {
		            Ekans b1=new Ekans();
		            b1.setVisible(false);
		              
		        }
			}
		});
		
		 
		
		b2 = new JButton("BEEDRILL");
		b2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b2.setIcon(new ImageIcon("pics/beedrill.png"));
		b2.setBounds(66, 147, 154, 53);
		frame.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b2)
		        {
		            Beedrill b2=new Beedrill();
		            b2.setVisible(false);
		              
		        }
			}
		});
		
		
		b3 = new JButton("CLEFABLE");
		b3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b3.setIcon(new ImageIcon("pics/clefable.png"));
		b3.setBounds(66, 199, 154, 53);
		frame.getContentPane().add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b3)
		        {
		            Clefable b3=new Clefable();
		            b3.setVisible(false);
		              
		        }
			}
		});
		
		b4 = new JButton("MANKEY");
		b4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b4.setIcon(new ImageIcon("pics/mankey.png"));
		b4.setBounds(66, 252, 154, 53);
		frame.getContentPane().add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b4)
		        {
		            Mankey b4=new Mankey();
		            b4.setVisible(false);
		              
		        }
			}
		});
		
		
		b5 = new JButton("MEWTWO");
		b5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b5.setIcon(new ImageIcon("pics/mewtwo.png"));
		b5.setBounds(66, 303, 154, 53);
		frame.getContentPane().add(b5);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b5)
		        {
		            Mewtwo b5=new Mewtwo();
		            b5.setVisible(false);
		              
		        }
			}
		});
		
		b6 = new JButton("NIDORAN");
		b6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b6.setIcon(new ImageIcon("pics/nidoranf.png"));
		b6.setBounds(221, 303, 154, 53);
		frame.getContentPane().add(b6);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b6)
		        {
		            NidoranFemale b6=new NidoranFemale();
		            b6.setVisible(false);
		              
		        }
			}
		});
		
		
		b7 = new JButton("NIDORONI");
		b7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b7.setIcon(new ImageIcon("pics/nidoranm.png"));
		b7.setBounds(221, 96, 154, 53);
		frame.getContentPane().add(b7);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b7)
		        {
		            NidoranMale b7=new NidoranMale();
		            b7.setVisible(false);
		              
		        }
			}
		});
		
		
	    b8 = new JButton("PIDGEY");
		b8.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b8.setIcon(new ImageIcon("pics/pidgey.png"));
		b8.setBounds(221, 147, 154, 53);
		frame.getContentPane().add(b8);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b8)
		        {
		            Pidgey b8=new Pidgey();
		            b8.setVisible(false);
		              
		        }
			}
		});
		
		
		b9 = new JButton("PIKACHU");
		b9.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b9.setIcon(new ImageIcon("pics/pikachu.png"));
		b9.setBounds(221, 199, 154, 53);
		frame.getContentPane().add(b9);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b9)
		        {
		            Pikachu b9=new Pikachu();
		            b9.setVisible(false);
		              
		        }
			}
		});
		
		
		
		b10 = new JButton("RATTATA");
		b10.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b10.setIcon(new ImageIcon("pics/rattata.png"));
		b10.setBounds(221, 252, 154, 53);
		frame.getContentPane().add(b10);
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b10)
		        {
		            Rattata b10=new Rattata();
		            b10.setVisible(false);
		              
		        }
			}
		});
		
		
	}

	public static void main(String args[])
    {
    	
		new Pokedex();
    }
	
	

}


