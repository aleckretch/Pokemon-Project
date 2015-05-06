package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class is the JFrame for 
 * the screen for the "Pokemon
 * Info"
 */
public class PokemonInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * displays GUI to be displayed
	 * upon selection of "Pokemon Info"
	 * on the "Game Info" screen
	 */
	public PokemonInfo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("POKEMON INFORMATION");
		l1.setBounds(39, 23, 298, 44);
		frame.getContentPane().add(l1);
		 l1.setFont(new Font("Baoli SC Regular", 3, 16));
		    l1.setForeground (Color.RED);
		
		JPanel common = new JPanel(new BorderLayout());
		JPanel commonPics = new JPanel(new GridLayout(2,3));
		
		ImageIcon common1 = new ImageIcon("pics/mankey.png");
		ImageIcon common2 = new ImageIcon("pics/nidoranf.png");
		ImageIcon common3 = new ImageIcon("pics/nidoranm.png");
		ImageIcon common4 = new ImageIcon("pics/pidgey.png");
		ImageIcon common5 = new ImageIcon("pics/rattata.png");
		ImageIcon common6 = new ImageIcon("pics/ekans.png");
		
		JLabel com1 = new JLabel(common1);
		JLabel com2 = new JLabel(common2);
		JLabel com3 = new JLabel(common3);
		JLabel com4 = new JLabel(common4);
		JLabel com5 = new JLabel(common5);
		JLabel com6 = new JLabel(common6);
		
		commonPics.add(com1);
		commonPics.add(com2);
		commonPics.add(com3);
		commonPics.add(com4);
		commonPics.add(com5);
		commonPics.add(com6);
		
		JLabel commonLabel = new JLabel("																		6 Common Pokemon");
		
		common.add(commonLabel, BorderLayout.NORTH);
		common.add(commonPics, BorderLayout.CENTER);
		
		JPanel uncommon = new JPanel(new BorderLayout());
		JLabel uncommonLabel = new JLabel("3 Uncommon Pokemon");
		uncommon.add(uncommonLabel, BorderLayout.NORTH);
		
		JPanel uncommonPics = new JPanel(new GridLayout(3,1));
		
		ImageIcon uncommon1 = new ImageIcon("pics/beedrill.png");
		ImageIcon uncommon2 = new ImageIcon("pics/clefable.png");
		ImageIcon uncommon3 = new ImageIcon("pics/pikachu.png");
		
		JLabel unCom1 = new JLabel(uncommon1);
		JLabel unCom2 = new JLabel(uncommon2);
		JLabel unCom3 = new JLabel(uncommon3);
		
		uncommonPics.add(unCom1);
		uncommonPics.add(unCom2);
		uncommonPics.add(unCom3);
		
		uncommon.add(uncommonPics, BorderLayout.CENTER);
		
		JPanel rare = new JPanel(new BorderLayout());
		JLabel rareLabel = new JLabel("1 Rare Pokemon");
		rare.add(rareLabel, BorderLayout.NORTH);
		
		JPanel rarePics = new JPanel(new GridLayout(1,1));
		
		ImageIcon rareImage = new ImageIcon("pics/mewtwo.png");
		
		JLabel rarePic = new JLabel(rareImage);
		
		rarePics.add(rarePic);
		
		rare.add(rarePics, BorderLayout.CENTER);
		
		frame.add(uncommon, BorderLayout.WEST);
		frame.add(common, BorderLayout.CENTER);
		frame.add(rare, BorderLayout.EAST);
		frame.add(l1, BorderLayout.NORTH);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		new PokemonInfo();

	}

}
