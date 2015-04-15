package model;

public class Creature {
	private int MAX_LUCK = 80;
	private int MIN_LUCK = 60;
	private boolean isPresent = true; //goes false if dies or runs
	private String name;
	private int hp = 100;
	private int runProb = 20;
	private int runDuration = 7;
	private int rarity = 6; //higher means less rare
	
	public Creature(String name){
		this.name = name;
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
