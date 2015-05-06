package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class contains all the 
 * information for the win screen
 *
 */
public class Win {

	private JFrame frame;
	private JTextField defense;
	private JTextField points;
	private JTextField hp;
	private JLabel steps, caught, stepsR, caughtR;
	private int numPokemonR, numStepsR;
	
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
					Win window = new Win(false, 0, 4);
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
	public Win(boolean win, int numSteps, int numPokemon) {
		initialize(win, numSteps, numPokemon);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean win, int numSteps, int numPokemon) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("CONGRATULATON YOU WIN !!!");
		if (!win)
		{
			l1.setText("Sorry, you lose.");
		}
		l1.setForeground(new Color(255, 0, 0));
		l1.setBackground(Color.LIGHT_GRAY);
		l1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		l1.setBounds(134, 17, 344, 41);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Your Summary");
		l2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		l2.setBounds(48, 78, 150, 27);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("CAUGHT");
		l3.setBounds(69, 122, 61, 16);
		frame.getContentPane().add(l3);
		
		caught = new JLabel("" + numPokemon);
		caught.setBounds(125, 117, 61, 28);
		frame.getContentPane().add(caught);

		JLabel l7 = new JLabel("STEPS");
		l7.setBounds(269, 122, 61, 16);
		frame.getContentPane().add(l7);
		
		steps = new JLabel("" + numSteps);
		steps.setBounds(325, 117, 61, 28);
		frame.getContentPane().add(steps);
		
		JLabel l4 = new JLabel("Rival Summary");
		l4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		l4.setBounds(48, 178, 150, 27);
		frame.getContentPane().add(l4);
		
		numPokemonR = getRandom(5,1);
		numStepsR = getRandom(700,400);
		
		JLabel l5 = new JLabel("CAUGHT");
		l5.setBounds(69, 222, 61, 16);
		frame.getContentPane().add(l5);
		
		caughtR = new JLabel("" + numPokemonR);
		caughtR.setBounds(125, 217, 61, 28);
		frame.getContentPane().add(caughtR);

		JLabel l6 = new JLabel("STEPS");
		l6.setBounds(269, 222, 61, 16);
		frame.getContentPane().add(l6);
		
		stepsR = new JLabel("" + numStepsR);
		stepsR.setBounds(325, 217, 61, 28);
		frame.getContentPane().add(stepsR);
		
		JLabel l8 = new JLabel();
		if (numPokemonR > numPokemon)
		{
			l8.setText("Rival beat you because it caught more pokemon.");
		}
		else if (numPokemonR < numPokemon)
		{
			l8.setText("You beat Rival because you caught more pokemon.");
		}
		else
		{
			if (numStepsR > numSteps)
			{
				l8.setText("You beat Rival because you caught more pokemon in less steps.");
			}
			else
			{
				l8.setText("Rival beat you because it caught more pokemon in less steps.");
			}
		}
		l8.setBounds(69, 262, 500, 28);
		frame.getContentPane().add(l8);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 78, 377, 155);
		frame.getContentPane().add(panel);
		
		/*
		b1 = new JButton("CONTINUE");
		b1.setBounds(34, 278, 117, 29);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
		        {	
		            FrogRunner b1=new FrogRunner(1,1,1);
		            b1.setVisible(false);
		            frame.setVisible(false);
		            frame.dispose();
		            
		        }
			}
		});
		*/
		
		 b2 = new JButton("NEW GAME");
		 b2.setBounds(34, 310, 117, 29);
		frame.getContentPane().add(b2);
		 b2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==b2)
			        {	
			            SelectCharacter b2=new SelectCharacter();
			            b2.setVisible(false);
			            frame.setVisible(false);
			            frame.dispose();
			            
			        }
				}
			});
	}
	
	private static int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}

}
