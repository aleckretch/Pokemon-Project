package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;


public class Pokedex {

	private JFrame frame;
	
	/**
	 * Launch the application...
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	} 

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("POKEDEX");
		l1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		l1.setBounds(127, 17, 119, 33);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Click on image to see the Pokemon's information");
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		l2.setBounds(56, 62, 369, 26);
		frame.getContentPane().add(l2);
		
		JButton b1 = new JButton("   EKANS");
		b1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b1.setIcon(new ImageIcon("pics/ekans.png"));
		b1.setBounds(66, 96, 154, 53);
		frame.getContentPane().add(b1);
		
		
		JButton b2 = new JButton("BEEDRILL");
		b2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b2.setIcon(new ImageIcon("pics/beedrill.png"));
		b2.setBounds(66, 147, 154, 53);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("CLEFABLE");
		b3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b3.setIcon(new ImageIcon("pics/clefable.png"));
		b3.setBounds(66, 199, 154, 53);
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("MANKEY");
		b4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b4.setIcon(new ImageIcon("pics/mankey.png"));
		b4.setBounds(66, 252, 154, 53);
		frame.getContentPane().add(b4);
		
		JButton b5 = new JButton("MEWTWO");
		b5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b5.setIcon(new ImageIcon("pics/mewtwo.png"));
		b5.setBounds(66, 303, 154, 53);
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("NIDORANF");
		b6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b6.setIcon(new ImageIcon("pics/nidoranf.png"));
		b6.setBounds(221, 303, 154, 53);
		frame.getContentPane().add(b6);
		
		JButton b7 = new JButton("NIDORANM");
		b7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b7.setIcon(new ImageIcon("pics/nidoranm.png"));
		b7.setBounds(221, 96, 154, 53);
		frame.getContentPane().add(b7);
		
		JButton b8 = new JButton("PIDGEY");
		b8.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b8.setIcon(new ImageIcon("pics/pidgey.png"));
		b8.setBounds(221, 147, 154, 53);
		frame.getContentPane().add(b8);
		
		JButton b9 = new JButton("PIKACHU");
		b9.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b9.setIcon(new ImageIcon("pics/pikachu.png"));
		b9.setBounds(221, 199, 154, 53);
		frame.getContentPane().add(b9);
		
		JButton b10 = new JButton("RATTATA");
		b10.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		b10.setIcon(new ImageIcon("pics/rattata.png"));
		b10.setBounds(221, 252, 154, 53);
		frame.getContentPane().add(b10);
		
		
	}
}
