package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is the JFrame for
 * the "Game Info" screen
 */
public class GameInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	

	/**
	 * Constructs GUI for the 
	 * "GameInfo" screen
	 */
	public GameInfo() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("GAME INFORMATION AND INSTRUCTION");
		l1.setBounds(57, 26, 364, 42);
		frame.getContentPane().add(l1);
		 l1.setFont(new Font("Baoli SC Regular", 3, 16));
		    l1.setForeground (Color.RED);
		
		 b1 = new JButton("GENERAL INFO");
		b1.setBounds(86, 98, 154, 42);
		frame.getContentPane().add(b1);
		 
		  b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
		        {	
					//MusicPlayer.playOnce("audio/Footstep01.wav");
					GenerInfo b1=new GenerInfo();
		            b1.setVisible(false);
   
		            
		        }
			}
		});

		
		b2 = new JButton("MAPS");
		b2.setBounds(86, 170, 154, 42);
		frame.getContentPane().add(b2);
		 b2.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b2)
			      {	
					//MusicPlayer.playOnce("audio/Footstep01.wav");
					MapsInfo b2=new MapsInfo();
			        b2.setVisible(false);
			      
			            
			        }
				}
			});

		
		b3 = new JButton("CHARACTER");
		b3.setBounds(86, 249, 154, 42);
		frame.getContentPane().add(b3);
		 b3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b3)
				      {	
						//MusicPlayer.playOnce("audio/Footstep01.wav");
						CharacterInfo b3=new CharacterInfo();
				        b3.setVisible(false);
				          
				        }
					}
				});
		
		b4 = new JButton("POKEMON");
		b4.setBounds(298, 98, 154, 42);
		frame.getContentPane().add(b4);
		b4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b4)
				      {	
						//MusicPlayer.playOnce("audio/Footstep01.wav");
						PokemonInfo b4=new PokemonInfo();
				        b4.setVisible(false);
				          
				        }
					}
				});
		
		b5 = new JButton("ITEMS");
		b5.setBounds(298, 170, 154, 42);
		frame.getContentPane().add(b5);
		b5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b5)
				      {	
						//MusicPlayer.playOnce("audio/Footstep01.wav");
						ItemsInfo b5=new ItemsInfo();
				        b5.setVisible(false);
				          
				        }
					}
				});
		
		b6 = new JButton("BATTLES");
		b6.setBounds(298, 249, 154, 42);
		frame.getContentPane().add(b6);
		b6.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b6)
				      {	
						//MusicPlayer.playOnce("audio/Footstep01.wav");
						BattleInfo b6=new BattleInfo();
				        b6.setVisible(false);
				          
				        }
					}
				});
		
		
	
	}
	public static void main(String[] args) {
		
		new GameInfo();
		

}
}
