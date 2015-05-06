package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * this abstract class creates a creature
 * that will be fought in battle
 */
public abstract class Creature {
	private int BALL_POWER = 50;
	public int luck = 5;//affects each throw type, and its potency
	private boolean isPresent = true; //goes false if dies or runs
	private String name;
	private int hp;
	private int runProb;
	private int runDuration;
	private int rarity; //higher means less rare
	private BufferedImage sprite;
	private String imgFilePath;
	private boolean isDead = false;
	
	/**
	 * constructs the creature (pokemon)
	 * @param String name of creature
	 * @param String name of image file path
	 * @param int HP amount of creature
	 * @param int run probability of the creature
	 * @param int run duration of the creature
	 */
	public Creature (String name, String imgFilePath, int hp, int runProb, int runDuration) {
		this.name = name;
		this.hp = hp;
		this.runProb = runProb;
		this.runDuration = runDuration;
		this.luck = luck;
		this.sprite = null;
		this.imgFilePath = imgFilePath;
		try 
		{
		    sprite = ImageIO.read(new File(imgFilePath));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
	}
	
	/**
	 * the effects of the pokemon when a rock is thrown
	 * @param integer for the damage that should be done
	 */
	public void rock(int damage){
		runDuration--;
		hp -= damage + getRandom(luck, 0);
		runProb += (int)(damage/2);
		checkDead();
		checkDuration();
		checkRunProb();
	}
	/**
	 * return boolean if the pokemon should be caught
	 */
	public boolean ball(){
		if (!isPresent){
			return false;
		}
		runDuration--;
		if (hp < BALL_POWER){
			System.out.println("Catching luck " + luck);
			isPresent = false;
			return true;
		}
		System.out.println("    You Missed " + luck);
		checkDuration();
		checkRunProb();
		return false;
	}
	
	/**
	 * the effects on the pokemon if bait is thrown
	 * @param integer of the damage done to the pokemon
	 */
	public void bait(int damage){
		runDuration--;
		runProb -= damage;
		checkDead();
		checkDuration();
		checkRunProb();
	}
	/**
	 * check if the pokemon is dead
	 */
	private void checkDead(){
		if (hp <= 0){
			isPresent = false;
			isDead = true;
		}
	}
	
	/**
	 * checks the run duration of the Pokemon
	 */
	private void checkDuration(){
		if (runDuration <= 0){
			run();
		}
	}
	private void checkRunProb(){
		
	}
	/**
	 * runs away from Pokemon
	 */
	private void run(){
		isPresent = false;
	}
	/**
	 * @return the boolean if there is a Pokemon present
	 */
	public boolean isPresent(){
		return isPresent;
	}
	/**
	 * @return the string name of the pokemon
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return the int hp of the pokemon
	 */
	public int getHp(){
		return hp;
	}
	/**
	 * @return the int run probability of the pokemon
	 */
	public int getRunProb(){
		return runProb;
	}
	
	/**
	 * Generates a random number in between two integers
	 *
	 * @param int maximum number
	 * @param int minimum number
	 * @return a random int number
	 */
	private int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	/**
	 * @return the String of the image path
	 */
	public String getImage(){
		return imgFilePath;
	}
	/**
	 * @return the boolean of if the Pokemon is dead
	 */
	public boolean isDead(){
		return isDead;
	}
}
