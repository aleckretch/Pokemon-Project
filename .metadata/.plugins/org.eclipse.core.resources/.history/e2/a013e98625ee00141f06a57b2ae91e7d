package model;

import java.awt.image.BufferedImage;
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
	
	public Player(String name){
		this.name = name;
		//init arrays
	}
	public void faceCreature(Creature target){
		this.target = target;
		System.out.println("Facing " + target.getName());
	}
	public void throwRock(){
		System.out.println("Throwing a rock");
		target.rock(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	public void throwBait(){
		System.out.println("Throwing some bait");
		target.bait(damage);
		if (!target.isPresent()){
			System.out.println("(Back to world screen");
			return;
		}
	}
	public void throwBall(){
		//remove a ball
		System.out.println("Throwing a safari ball");
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
	
	
}
