package model;

import java.util.Random;

/**
 * this class generates a random creature
 */
public class CreatureGenerator {
	public static void main(String[] args){
		new CreatureGenerator();
	}
	Creature pokemon;
	public CreatureGenerator(){
		//possibly accept a random seed here if needed
	}
	
	/**
	 * sets a random pokemon (12% for common, 8% chance uncommon, 4% rare)
	 */
	public void setPokemon(){
		int randomNumber = getRandom(100, 1);
		//common (each has 12% chance to appear)
		if (randomNumber < 12)
		{
			pokemon = new CreatureEkans();
		}
		else if (randomNumber < 24)
		{
			pokemon = new CreatureMankey();
		}
		else if (randomNumber < 36)
		{
			pokemon = new CreatureNidoranFemale();
		}
		else if (randomNumber < 48)
		{
			pokemon = new CreatureNidoranMale();
		}
		else if (randomNumber < 60)
		{
			pokemon = new CreaturePidgey();
		}
		else if (randomNumber < 72)
		{
			pokemon = new CreatureRattata();
		}
		//uncommon (each has 8% chance to appear)
		else if (randomNumber < 80)
		{
			pokemon = new CreatureBeedrill();
		}
		else if (randomNumber < 88)
		{
			pokemon = new CreatureClefable();
		}
		else if (randomNumber < 96)
		{
			pokemon = new CreaturePikachu();
		}
		//rare (4% chance to appear)
		else
		{
			pokemon = new CreatureMewtwo();
		}
	}
	
	/**
	 * @return the pokemon
	 */
	public Creature getPokemon(){
		return pokemon;
	}
	
	/**
	 * sets a random number between to integers
	 * @param int maximum
	 * @param int minimum
	 * @return int the randomly generated number
	 */
	private static int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}
