package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class Creature {
	private int BALL_POWER = 50;
	private int luck = 50;//affects each throw type, and its potency
	private boolean isPresent = true; //goes false if dies or runs
	private String name;
	private int hp;
	private int runProb;
	private int runDuration;
	private int rarity; //higher means less rare
	private BufferedImage sprite;
	private String imgFilePath = "src/baitImage.jpg";
	
	public Creature (String name, String imgFilePath, int hp, int runProb, int runDuration) {
		this.name = name;
		this.hp = hp;
		this.runProb = runProb;
		this.runDuration = runDuration;
		this.luck = luck;
		this.sprite = null;

		try 
		{
		    sprite = ImageIO.read(new File(imgFilePath));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
	}
	
	public void rock(int damage){
		runDuration--;
		hp -= damage + getRandom(luck, 0);
		runProb += (int)(damage/2);
		checkDead();
		checkDuration();
		checkRunProb();
	}
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
	
	public void bait(int damage){
		runDuration--;
		runProb -= damage;
		checkDead();
		checkDuration();
		checkRunProb();
	}
	private void checkDead(){
		if (hp <= 0){
			isPresent = false;
			//die();
		}
	}
	private void checkDuration(){
		if (runDuration <= 0){
			run();
		}
	}
	private void checkRunProb(){
		
	}
	private void run(){
		isPresent = false;
	}
	public boolean isPresent(){
		return isPresent;
	}
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}
	private int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	public String getImage(){
		return imgFilePath;
	}
}
