package view;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import model.Creature;
import model.Player;


public class GUI extends JFrame{
	int SCREEN_WIDTH = 700;
	int SCREEN_HEIGHT = 500;
	int BUTTON_WIDTH = 150;
	int BUTTON_HEIGHT = 50;
	int MARGIN = 15;
	int LEFT_EDGE = 25;
	JFrame frame = new JFrame("Creature Game");
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JTextPane collection = new JTextPane();
	String rockIcon = "src/rockImage.jpg";
	String ballIcon = "src/pokeballImage.jpg";
	String baitIcon = "src/baitImage.jpg";
	String runIcon = "src/runImage.jpg";
	
	String enemyIcon = "src/pokeballImage.jpg";
	
	JButton rockButton = new JButton(rockIcon);
	JButton ballButton = new JButton(ballIcon);
	JButton baitButton = new JButton(baitIcon);
	JButton runButton = new JButton(runIcon);
	JLabel enemyPic;
	Player player;
	
	
	public GUI(final Player player){
		this.player = player;
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		topPanel.setLayout(null);
		bottomPanel.setLayout(null);
		frame.add(topPanel);
		frame.add(bottomPanel);
		topPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT/2);
		bottomPanel.setBounds(0, SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT/2);
		
		/*SCALING SECTION, WITH ISSUES
		Icon imageIcon = new ImageIcon(rockIcon);
		System.out.println(imageIcon.getIconWidth());
		System.out.println(imageIcon.getIconHeight());
		Image image = ((ImageIcon) imageIcon).getImage();
		//Image img2 = image.getScaledInstance((int)imageIcon.getIconWidth()/9, (int)imageIcon.getIconHeight()/9, 1);
		Icon newImageIcon = new ImageIcon(img2);
		 */
		//rockButton.setIcon(new ImageIcon(rockIcon));
		

		
		
		rockButton.setIcon(new ImageIcon(rockIcon));
		ballButton.setIcon(new ImageIcon(ballIcon));
		baitButton.setIcon(new ImageIcon(baitIcon));
		runButton.setIcon(new ImageIcon(runIcon));
		
		rockButton.setBounds(LEFT_EDGE, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
		ballButton.setBounds(LEFT_EDGE + MARGIN + BUTTON_WIDTH, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
		baitButton.setBounds(LEFT_EDGE, BUTTON_HEIGHT + MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
		runButton.setBounds(LEFT_EDGE + MARGIN + BUTTON_WIDTH, BUTTON_HEIGHT + MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
		
		//topPanel.add(enemyPic);
		//ACTION LISTENERS
		rockButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing a rock.");
				player.throwRock();
			}
		});
		ballButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing a ball.");
				player.throwBall();
			}
		});
		baitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing some bait.");
				player.throwBait();
			}
		});
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Running Away.");
				player.run();
			}
		});
		
		bottomPanel.add(rockButton);
		bottomPanel.add(ballButton);
		bottomPanel.add(baitButton);
		bottomPanel.add(runButton);
		frame.setVisible(true);

		
	}
	public void updateCollection(Creature[] in){
		String result = "";
		for (int i = 0; i < in.length; i++){
			if (in[i] != null)
				result += in[i].getName() + '\n';
		}
		System.out.println("setting text " + result);
		collection.setText(result);
	}
	public void showCollection(){
		
	}
	public void updateEnemyPic(){
		
		try{
			enemyPic = new JLabel(player.getTarget().getImage());
			enemyPic.setBounds(SCREEN_WIDTH/2, 0, 200, 200);
		} catch (NullPointerException e){}
	}
	
}
