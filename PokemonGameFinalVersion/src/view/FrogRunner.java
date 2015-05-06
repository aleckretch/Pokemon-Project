package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import view.Frog;
import view.SpriteObject;
import view.Win;
/**
 * This class is the JFrame
 * for the gameplay animation.
 * It displays the character walking around
 * the map as well as the music.
 */
public class FrogRunner extends JFrame{
	private TreeSet<Character> keySet;
	public SpriteObject frog;
	private JPanel panel;
	private JFrame frame;
	private JLabel stepsLabel, pokemonCountLabel, itemsLabel;
	private JLayeredPane lpane = new JLayeredPane();
	private Timer animTimer;
	public List<String> items;
	private KeyEvent lastKeyPressed;
	private int winCondition;
	
	Map map;
	
	/**
	 * Constructor puts together everything for 
	 * the animation. Adds keyListeners for 
	 * character movement. Makes the GUI
	 * for the sprite walking around the map
	 * 
	 * @param mapNumber determines which map is used
	 * @param playerNumber determines which player is used
	 * @param winCondition determines which win condition is used
	 */
	public FrogRunner(int mapNumber, int playerNumber, int winCondition) {
		MusicPlayer.play("audio/PokeSounds.wav");
		map = new Map(mapNumber);
		this.winCondition = winCondition;
		model.Battle.setMap(map);
		keySet = new TreeSet<Character>();
		items = new ArrayList<String>();

		// TODO 13: uncomment these two lines
		frog = new Frog(150-8, 150-25, playerNumber, map, this);
		frog.start();
		
		// creates the panel that actually draws the sprites
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				// TODO 14: uncomment the next line
				frog.draw(g);
				
			}
		};
		
		panel.setPreferredSize(new Dimension(400,300));
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(300, 340));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		lpane.setBounds(0,0,625,625);
		map.setBounds(0,0,625,625);
		map.setOpaque(true);
		panel.setBounds(0,0,625,625);
		panel.setOpaque(false);
		lpane.add(map, new Integer(0),0);
		lpane.add(panel, new Integer(1), 0);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3,1));
		stepsLabel = new JLabel("steps: " + frog.getSteps() + "/500");
		pokemonCountLabel = new JLabel("caught pokemon: 0");
		itemsLabel = new JLabel("items: " + items.size() + " (" + items.toString() + ")");
		topPanel.add(stepsLabel);
		topPanel.add(pokemonCountLabel);
		topPanel.add(itemsLabel);
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(lpane, BorderLayout.CENTER);
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
		
		// creates the timer for animating the panel
		animTimer = new Timer(15, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (frog != null){ // move the frog according to what keys are being pressed\
					updateSteps();
					if (keySet.contains('s'))
						frog.moveUp();
					else if (keySet.contains('d'))
						frog.moveLeft();
					else if (keySet.contains('w'))
						frog.moveDown();
					else if (keySet.contains('a'))
						frog.moveRight();
					else
						frog.moveStop();
				}
				
				
				// repaint the panel
				map.repaint();
				panel.repaint();
			}
			
		});
				
		
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				tempButton(arg0.getKeyChar());
				keySet.add(arg0.getKeyChar());
				lastKeyPressed = arg0;
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				keySet.remove(arg0.getKeyChar());
			}
		});
	
		animTimer.start();
	}
	/**
	 * removes the last key pressed from the keySet
	 */
	public void releaseKey(){
		if (lastKeyPressed != null){
			keySet.remove(lastKeyPressed.getKeyChar());
		}
	}
	/**
	 * updates the amount of steps taken
	 * by the user. Exits game screen 
	 * and enters win screen when maximum
	 * steps is reached
	 */
	public void updateSteps(){
		if (frog.getSteps() < frog.getAllowedSteps())
		{
			stepsLabel.setText("steps: " + frog.getSteps() + "/" + frog.getAllowedSteps());
		}
		else
		{
			frame.setVisible(false); //you can't see me!
			frame.dispose(); //Destroy the JFrame object
			new Win(false, frog.getSteps(), frog.getNumPokemon());
			frog = null;
		}
	}
	/**
	 * Updates the 
	 * display to show the 
	 * items the user has 
	 * retrieved
	 */
	public void updateItems() {
		itemsLabel.setText("items: " + items.size() + " (" + items.toString() + ")");
	}
	
	/**
	 * updates the pokemon
	 * the user has caught. Brings
	 * up win screen if win condition
	 * is met
	 */
	public void updatePokemonCount() {
		pokemonCountLabel.setText("caught pokemon: " + frog.getNumPokemon());
		if (frog.getNumPokemon() == 5 && winCondition == 1)
		{
			frame.setVisible(false); //you can't see me!
			frame.dispose(); //Destroy the JFrame object
			new Win(true, frog.getSteps(), 0);
			frog = null;
		}
	}
	
	/**
	 * brings up win screen if
	 * mewtwo is caught and win 
	 * condition equals 2
	 */
	public void mewtwoCaught() {
		if (winCondition == 2)
		{
			frame.setVisible(false); //you can't see me!
			frame.dispose(); //Destroy the JFrame object
			new Win(true, frog.getSteps(), 0);
			frog = null;
		}
	}
	
	/**
	 * adds item to item list
	 * 
	 * @param item Item to be added to items list
	 */
	public void addItem(String item)
	{
		items.add(item);
		updateItems();
	}
	
	public static void main(String[] args){
		new FrogRunner(1,2,1);
	}
	
	/**
	 * pauses and plays the MusicPlayer
	 * by pressing z to pause and
	 * x to resume
	 * 
	 * @param in user input 
	 */
	private void tempButton(char in){
		if (in == 'z')
			MusicPlayer.pause();
		if (in == 'x'){
			MusicPlayer.resume();
		}
	}
}

