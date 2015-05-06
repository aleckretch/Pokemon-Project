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
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;



/*
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
*/import sun.audio.*;
import model.Creature;
import model.CreatureMewtwo;
import model.Player;

/**
 * This class is the GUI for
 * the battle screen
 *
 */
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
	/*
	String rockIcon = "Pokemon Game/src/rockImage.jpg";
	String ballIcon = "Pokemon Game/src/pokeballImage.jpg";
	String baitIcon = "Pokemon Game/src/baitImage.jpg";
	String runIcon = "Pokemon Game/src/runImage.jpg";
	*/
	String rockIcon = "pics/rockImage.jpg";
	String ballIcon = "pics/pokeballImage.jpg";
	String baitIcon = "pics/bait.jpeg";
	String runIcon = "pics/runImage.jpg";
	
	String enemyIcon;
	
	JLabel enemyImage;
	JLabel enemyName;
	JLabel hpLabel;
	JLabel runProbLabel;
	
	JButton rockButton = new JButton();
	JButton ballButton = new JButton();
	JButton baitButton = new JButton();
	JButton runButton = new JButton();
	BufferedImage enemyPic;
	Player player;
	JLayeredPane frontPane = new JLayeredPane();
	JLayeredPane backPane = new JLayeredPane();
	
	/**
	 * Constructs GUI for the battle 
	 * screen
	 * 
	 * @param player Player class to be used
	 * in battle screen
	 */
	public GUI(final Player player){
		controller.Application.setPlayer(player);
		MusicPlayer.pause();
		if (player.getTarget() instanceof CreatureMewtwo){
			MusicPlayer.play("audio/LegendaryFight.wav");
		}
		else if (player.getTarget().getHp() > 60){
			MusicPlayer.play("audio/RareFight.wav");
		}
		else{
			MusicPlayer.play("audio/CommonFight.wav");
		}
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
		
		ImageIcon rockImageIcon = new ImageIcon(rockIcon);
		Image rockImg = rockImageIcon.getImage() ;  
		Image newRockImg = rockImg.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		rockImageIcon = new ImageIcon( newRockImg );
		
		ImageIcon ballImageIcon = new ImageIcon(ballIcon);
		Image ballImg = ballImageIcon.getImage() ;  
		Image newBallImg = ballImg.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		ballImageIcon = new ImageIcon( newBallImg );
		
		ImageIcon baitImageIcon = new ImageIcon(baitIcon);
		Image baitImg = baitImageIcon.getImage() ;  
		Image newBaitImg = baitImg.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		baitImageIcon = new ImageIcon( newBaitImg );
		
		ImageIcon runImageIcon = new ImageIcon(runIcon);
		Image runImg = runImageIcon.getImage() ;  
		Image newRunImg = runImg.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		runImageIcon = new ImageIcon( newRunImg );
		   
		rockButton.setIcon(rockImageIcon);
		ballButton.setIcon(ballImageIcon);
		baitButton.setIcon(baitImageIcon);
		runButton.setIcon(runImageIcon);
		
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
				if (player.getTarget().isDead()){
					updateReadout(player.getTarget().getName() + " died.");
					//delay for a second before returning to mainscreen. 
					returnToMap();
				}
			}
		});
		ballButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing a ball.");
				updateReadout("Throwing a pokeball.");
				if (player.throwBall()){
					updateReadout("You caught a " + player.getTarget().getName());
					//transitionDelay();
					returnToMap();
				}
			}
		});
		baitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Throwing some bait.");
				player.throwBait();
				updateGui();
				updateReadout("Throwing some bait.");
			}
		});
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Running Away.");
				player.run();
				updateReadout("Running Away.");
				returnToMap();
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
		
		//MOREGAN'S VERSION: ISSUE WITH CASTING
		/*
		Icon imageIcon = new ImageIcon(player.getTarget().getImage());
		Image unscaledImage = imageIcon.getImage();
		int width=200;
		int height=200;
		Image image = unscaledImage.getScaledInstance(width,height,Image.SCALE_DEFAULT);
		enemyImage = new JLabel((ImageIcon)image);
		*/
		
		enemyImage.setBounds(SCREEN_WIDTH - 150, 50, 200, 200);
		enemyName = new JLabel(player.getTarget().getName());
		//set the bounds based on the name length, and some sort of space ratio. [][]
		enemyName.setBounds(75, 50, 500, 100);
		hpLabel = new JLabel("Hit Points: " + player.getTarget().getHp());
		hpLabel.setBounds(150, 170, 150, 100);
		if (!player.frogRunner.items.contains("hp view"))
		{
			hpLabel.setText("");
		}
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
	
	/**
	 * updates collection of pokemon
	 * 
	 * @param in creature array used to update collection
	 */
	public void updateCollection(Creature[] in){
		String result = "";
		for (int i = 0; i < in.length; i++){
			if (in[i] != null)
				result += in[i].getName() + '\n';
		}
		System.out.println("setting text " + result);
		collection.setText(result);
	}

	/**
	 * updates hpLabel and runProbLabel in battle screen
	 */
	private void updateGui(){
		hpLabel.setText("Hit Points: " + player.getTarget().getHp());
		if (!player.frogRunner.items.contains("hp view"))
		{
			hpLabel.setText("");
		}
		runProbLabel.setText("Run Probability: " + player.getTarget().getRunProb());
	}
	/**
	 * Adds update to readout
	 * 
	 * @param update String to be added to the readout JTextPane
	 */
	private void updateReadout(String update){
		readout.setText(readout.getText() + update + '\n');
	}
	/**
	 * resizes image
	 * 
	 * @param in image to be resized
	 * @return resized image
	 */
	private BufferedImage resize(BufferedImage in){
		//BufferedImage out = new BufferedImage(200, 200, in);
		
			return new BufferedImage(0, 0, 0);
	}
	
	/**
	 * plays music
	 */
	private void playLoadingMusic(){
		/*
		String musicPath = "Pokemon Game/src/Petwoo_Audio.mid";
		try{
			
		
			InputStream in = new FileInputStream(musicPath);
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		}catch (Exception e){
			System.out.println("audio issue");
		}
		*/
		
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
	/**
	 * calls for a delay in Thread
	 */
	private void transitionDelay(){
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * removes view and returns to map
	 */
	private void returnToMap(){
		player.resetEnemyPresent();
		MusicPlayer.pause();
		MusicPlayer.play("audio/PokeSounds.wav");
		dispose();
	}
}
