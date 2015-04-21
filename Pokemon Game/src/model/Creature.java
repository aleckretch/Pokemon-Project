package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class Creature {
	private int MAX_LUCK;
	private int MIN_LUCK;
	private boolean isPresent = true; //goes false if dies or runs
	private String name;
	private int hp;
	private int runProb;
	private int runDuration;
	private int rarity; //higher means less rare
	private BufferedImage sprite;
	
	public Creature (String name, String imgFilePath, int maxLuck, int minLuck, int hp, int runProb, int runDuration) {
		this.name = name;
		this.MAX_LUCK = maxLuck;
		this.MIN_LUCK = minLuck;
		this.hp = hp;
		this.runProb = runProb;
		this.runDuration = runDuration;
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
		hp -= damage;
		runProb += damage;
		checkDead();
		checkDuration();
		checkRunProb();
	}
	public boolean ball(){
		if (!isPresent){
			return false;
		}
		runDuration--;
		float luck = (float) (Math.random() * 100 + MAX_LUCK);//[][]fix this line/////////////////////////////////
		if (luck > hp){
			System.out.println("Catching luck " + luck);
			isPresent = false;
			return true;
		}
		System.out.println("    You Missed " + luck);
		checkDuration();
		checkRunProb();
		return false;
	}
	public boolean ball2(){
		if (!isPresent){
			return false;
		}
		runDuration--;
		Random r = new Random();
		int ballPower = r.nextInt() * 
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
}
