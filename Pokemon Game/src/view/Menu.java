package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;


public class Menu extends JFrame {

	private JFrame frame;
	private JLabel label1;
	private JButton runButton;
	private JButton pokemonButton;
	private JButton itemsButton;
	private JButton fightButton;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		runButton.setBounds(372, 330, 228, 48);
		frame.getContentPane().add(runButton);
		
		JButton pokemonButton = new JButton("POKEMON");
		pokemonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pokemonButton.setBounds(372, 284, 228, 48);
		frame.getContentPane().add(pokemonButton);
		
		JButton itemsButton = new JButton("ITEMS");
		itemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		itemsButton.setBounds(149, 330, 228, 48);
		frame.getContentPane().add(itemsButton);
		
		JButton fightButton = new JButton("FIGHT");
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fightButton.setBounds(149, 284, 228, 48);
		frame.getContentPane().add(fightButton);
		
		JLabel label1 = new JLabel("SELECT THE OPTION ");
		label1.setBounds(6, 284, 143, 88);
		frame.getContentPane().add(label1);
	}
}