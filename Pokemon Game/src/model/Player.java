package model;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.GUI;
//Goggles that let you 
public class Player {
	private int MAX_SAFARI_BALLS = 30;
	private int MAX_STEPS = 500;
	private int MAX_ITEMS = 10;
	private int damage = 5;
	private String name;//check this, something wierd about String initialization
	private SafariBall[] balls = new SafariBall[MAX_SAFARI_BALLS];
	private Item[] items = new Item[0];
	private BufferedImage image;
	private int totalCreatures = 0;
	private int MAX_CREATURES = 10;
	private Creature[] collection = new Creature[MAX_CREATURES];
	private Creature target;
	private int x, y;
	boolean enemyPresent = false;
	
	public Player(String name){
		this.name = name;
		//init arrays
	}
	public void faceCreature(Creature target){
		this.target = target;
		enemyPresent = true;
 		System.out.println("Facing " + target.getName());
	}
	public void throwRock(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is throwing a rock.");
		target.rock(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	public void throwBait(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is throwing some bait.");
		target.bait(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	public void throwBall(){
		if (absentEnemyViolation()){ return; }
		
		//remove a ball
		System.out.println(name + " is throwing a safari ball.");
		if (target.isPresent() && target.ball()){
			System.out.println("You caught a " + target.getName());
			//Check if you already have it before adding
			collection[totalCreatures] = target;
			totalCreatures++;
			System.out.println("You now have " + totalCreatures + " total creatures in your collection!");
		}
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	public void run(){
		if (absentEnemyViolation()){ return; }
		System.out.println(name + " is running away.");
	}
	public Creature[] getCollection(){
		return collection;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void moveLeft()
	{
		x--;
	}
	
	public void moveRight()
	{
		x++;
	}
	
	public void moveUp()
	{
		y++;
	}
	
	public void moveDown()
	{
		y--;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	private boolean absentEnemyViolation(){
		if (target == null){
			JOptionPane.showMessageDialog(new JFrame(), "There is no enemy present.  "
					+ "This message only appears if something went wrong!");
			return true;
		}
		return false;
	}
	public Creature getTarget(){
		if (absentEnemyViolation()){ return null; }
		return target;
	}
}
