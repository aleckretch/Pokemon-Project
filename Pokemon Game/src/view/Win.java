package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Win {

	private JFrame frame;
	private JTextField caught;
	private JTextField defense;
	private JTextField points;
	private JTextField hp;
	private JTextField steps;
	
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win window = new Win();
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
	public Win() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("CONGRATULATON YOU WIN !!!");
		l1.setForeground(new Color(255, 0, 0));
		l1.setBackground(Color.LIGHT_GRAY);
		l1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		l1.setBounds(134, 17, 344, 41);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Summary");
		l2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		l2.setBounds(48, 78, 128, 27);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("CAUGHT");
		l3.setBounds(69, 117, 71, 27);
		frame.getContentPane().add(l3);
		
		JLabel l4 = new JLabel("DEFENSE");
		l4.setBounds(69, 149, 71, 27);
		frame.getContentPane().add(l4);
		
		caught = new JTextField();
		caught.setBounds(152, 117, 61, 28);
		frame.getContentPane().add(caught);
		caught.setColumns(10);
		
		defense = new JTextField();
		defense.setBounds(152, 148, 61, 28);
		frame.getContentPane().add(defense);
		defense.setColumns(10);
		
		JLabel l5 = new JLabel("POINTS");
		l5.setBounds(69, 188, 61, 16);
		frame.getContentPane().add(l5);
		
		points = new JTextField();
		points.setBounds(152, 182, 61, 28);
		frame.getContentPane().add(points);
		points.setColumns(10);
		
		JLabel l6 = new JLabel("HP");
		l6.setBounds(269, 122, 61, 16);
		frame.getContentPane().add(l1);
		
		JLabel l7 = new JLabel("STEPS");
		l7.setBounds(269, 154, 61, 16);
		frame.getContentPane().add(l7);
		
		hp = new JTextField();
		hp.setBounds(325, 116, 61, 28);
		frame.getContentPane().add(hp);
		hp.setColumns(10);
		
		steps = new JTextField();
		steps.setBounds(325, 148, 61, 28);
		frame.getContentPane().add(steps);
		steps.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 78, 377, 155);
		frame.getContentPane().add(panel);
		
		JButton b1 = new JButton("CONTINUE");
		b1.setBounds(34, 245, 117, 29);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("NEW GAME");
		b2.setBounds(34, 278, 117, 29);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("NEXT LEVEL");
		b3.setBounds(34, 310, 117, 29);
		frame.getContentPane().add(b3);
	}
}
