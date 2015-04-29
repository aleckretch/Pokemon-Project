package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
/*
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
*/import sun.audio.*;
import model.Creature;
import model.Player;


public class GUI extends JFrame{
	int SCREEN_WIDTH = 700;
	int SCREEN_HEIGHT = 500;
	int BUTTON_WIDTH = 150;
	int BUTTON_HEIGHT = 50;
	int MARGIN = 15;
	int LEFT_EDGE = 25;

	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel graphicPanel = new JPanel();
	JTextPane collection = new JTextPane();
	JTextPane readout = new JTextPane();
	
	//String rockIcon = "src/rockImage.jpg";
	String rockIcon = "Pokemon Game/src/rockImage.jpg";
	String ballIcon = "Pokemon Game/src/pokeballImage.jpg";
	String baitIcon = "Pokemon Game/src/baitImage.jpg";
	String runIcon = "Pokemon Game/src/runImage.jpg";
	String enemyIcon;
	
	JLabel enemyImage;
	JLabel enemyName;
	JLabel hpLabel;
	JLabel runProbLabel;
	
	JButton rockButton = new JButton(rockIcon);
	JButton ballButton = new JButton(ballIcon);
	JButton baitButton = new JButton(baitIcon);
	JButton runButton = new JButton(runIcon);
	BufferedImage enemyPic;
	Player player;
	JLayeredPane frontPane = new JLayeredPane();
	JLayeredPane backPane = new JLayeredPane();
	
	public GUI(final Player player){
		playLoadingMusic();
		this.player = player;
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		topPanel.setLayout(null);
		bottomPanel.setLayout(null);
		graphicPanel.setLayout(null);
		

		topPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT/2);
		bottomPanel.setBounds(0, SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT/2);
		graphicPanel.setBounds(50, 50, 300, 300);
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
				updateGui();
				updateReadout("Throwing a rock.");
			}
		});
		ballButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing a ball.");
				player.throwBall();
				updateGui();
				updateReadout("Throwing a pokeball.");
			}
		});
		baitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing some bait.");
				player.throwBait();
				updateReadout("Throwing some bait.");
			}
		});
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Running Away.");
				player.run();
				updateReadout("Running Away.");
			}
		});
		
		bottomPanel.add(rockButton);
		bottomPanel.add(ballButton);
		bottomPanel.add(baitButton);
		bottomPanel.add(runButton);
		bottomPanel.add(readout);
		
		readout.setEditable(false);
		ImageIcon icon = new ImageIcon(player.getTarget().getImage());
		enemyImage = new JLabel(icon);
		enemyImage.setBounds(SCREEN_WIDTH - 150, 50, 100, 100);
		enemyName = new JLabel(player.getTarget().getName());
		//set the bounds based on the name length, and some sort of space ratio. [][]
		enemyName.setBounds(75, 50, 500, 100);
		hpLabel = new JLabel("Hit Points: " + player.getTarget().getHp());
		hpLabel.setBounds(150, 170, 150, 100);
		runProbLabel = new JLabel("Run Probability: " + player.getTarget().getRunProb());
		runProbLabel.setBounds(150, 190, 150, 100);
		enemyName.setFont(new Font("Serif", Font.BOLD, 60));
		readout.setBounds(MARGIN + SCREEN_WIDTH/2, 0, 300, SCREEN_HEIGHT/2);
		topPanel.add(enemyImage);
		topPanel.add(enemyName);
		topPanel.add(hpLabel);
		topPanel.add(runProbLabel);
		/*
		try{
			enemyPic = ImageIO.read(new File(player.getTarget().getImage()));
		}
		catch (IOException e){
			e.printStackTrace();
		}*/
		//this.add(graphicPanel);
		this.add(topPanel);
		this.add(bottomPanel);
			/*
		frontPane.setLayout(null);
		backPane.setLayout(null);
		frontPane.setBounds(0, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		backPane.setBounds(0, 0, 50, 50);
		backPane.add(topPanel);
		backPane.add(bottomPanel);
		frontPane.add(graphicPanel);
		this.add(frontPane);
		this.add(backPane);
		frontPane.moveToFront(hpLabel);
				graphicPanel.add(runProbLabel);
		*/
		this.setVisible(true);		
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
	private void updateGui(){
		hpLabel.setText("Hit Points: " + player.getTarget().getHp());
		runProbLabel.setText("Run Probability: " + player.getTarget().getRunProb());
	}
	private void updateReadout(String update){
		readout.setText(readout.getText() + update + '\n');
	}
	private BufferedImage resize(BufferedImage in){
		//BufferedImage out = new BufferedImage(200, 200, in);
		
			return new BufferedImage(0, 0, 0);
	}
	
	private void playLoadingMusic(){
		String musicPath = "Pokemon Game/src/Petwoo_Audio.mid";
		try{
			
		
			InputStream in = new FileInputStream(musicPath);
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		}catch (Exception e){
			System.out.println("audio issue");
		}
		
		
		/*
		AudioPlayer ap = AudioPlayer.player;
		AudioStream as;
		AudioData data;
		try{
			InputStream in = new FileInputStream(musicPath);
			System.out.print("--");
			System.out.println(in.available());
			as = new AudioStream(in);
			System.out.print("--");
			data = as.getData();
			System.out.print("--");
			ap.start(as);
			System.out.print("Found audio file.");
		} catch (IOException e){
			System.out.println("No audio file found.");
		}*/
	}
}
