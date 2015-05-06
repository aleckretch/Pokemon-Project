package model;

/**
 * the interface for the Pokemon
 */
public interface CreatureInterface {
	
	public void rock(int damage);
	public boolean ball();
	public void bait(int damage);
	void checkDead();
	void checkDuration();
	void checkRunProb();
	void run();
	public boolean isPresent();
	public String getName();
	public int getHp();
}
