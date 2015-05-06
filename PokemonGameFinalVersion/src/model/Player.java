package model;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.FrogRunner;
import view.GUI;
//Goggles that let you 
/**
 * This class creates a player that will fight a creature
 */
public class Player {
	private int MAX_SAFARI_BALLS = 30;
	private int MAX_STEPS = 500;
	private int MAX_ITEMS = 10;
	private int damage = 5;
	private String name;//check this, something wierd about String initialization
	private BufferedImage image;
	public FrogRunner frogRunner;
	public int totalCreatures = 0;
	private int MAX_CREATURES = 10;
	private Creature[] collection = new Creature[MAX_CREATURES];
	private Creature target;
	private int x, y;
	boolean enemyPresent = false;
	
	/**
	 * @param String name of character
	 * @param FrogRunner the frogrunner
	 */
	public Player(String name, FrogRunner frogRunner){
		this.name = name;
		this.frogRunner = frogRunner;
		//init arrays
	}
	/**
	 * @param Creature the creature the player is fighting
	 */
	public void faceCreature(Creature target){
		this.target = target;
		enemyPresent = true;
 		System.out.println("Facing " + target.getName());
	}
	
	/**
	 * hurts the pokemon if a rock is thrown
	 */
	public void throwRock(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is throwing a rock.");
		target.rock(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	/**
	 * throws bait
	 */
	public void throwBait(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is throwing some bait.");
		target.bait(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	
	/**
	 * throws ball
	 */
	public boolean throwBall(){
		if (absentEnemyViolation()){ return false; }
		
		//remove a ball
		System.out.println(name + " is throwing a pokeball.");
		if (frogRunner.items.contains("safari ball"))
		{
			target.luck = 10;
		}
		if (target.isPresent() && target.ball()){
			System.out.println("You caught a " + target.getName());
			//Check if you already have it before adding
			collection[totalCreatures] = target;
			totalCreatures++;
			frogRunner.updatePokemonCount();
			if (target.getName().equals("Mewtwo"))
			{
				
			}
			System.out.println("You now have " + totalCreatures + " total creatures in your collection!");
			return true;
		}
		return false;
	}
	
	/**
	 * player runs away
	 */
	public void run(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is running away.");
	}
	
	/**
	 * @return the collection of caught pokemon
	 */
	public Creature[] getCollection(){
		return collection;
	}
	
	/**
	 * @return the x value of the player
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * @return the y value of the player
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * moves the player left by shifting the x value
	 */
	public void moveLeft()
	{
		x--;
	}
	
	/**
	 * moves the player right by shifting the x value
	 */
	public void moveRight()
	{
		x++;
	}
	
	/**
	 * moves the player up by shifting the y value
	 */
	public void moveUp()
	{
		y++;
	}
	
	/**
	 * moves the player down by shifting the y value
	 */
	public void moveDown()
	{
		y--;
	}
	
	/**
	 * @return the string name of the player
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @param a string new name for the player
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @return boolean if there is no enemy
	 */
	private boolean absentEnemyViolation(){
		if (target == null){
			JOptionPane.showMessageDialog(new JFrame(), "There is no enemy present.  "
					+ "This message only appears if something went wrong!");
			return true;
		}
		return false;
	}
	
	/**
	 * @return the pokemon
	 */
	public Creature getTarget(){
		if (absentEnemyViolation()){ return null; }
		return target;
	}
	
	/**
	 * @return boolean of if there is an enemy
	 */
	public boolean isEnemyPresent(){
		return enemyPresent;
	}
	
	/**
	 * resets the enemy to none
	 */
	public void resetEnemyPresent()
	{
		enemyPresent = false;
	}
}
