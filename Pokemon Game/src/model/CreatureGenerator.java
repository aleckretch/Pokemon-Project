package model;

import java.util.Random;

public class CreatureGenerator {
	public static void main(String[] args){
		new CreatureGenerator();
	}
	Creature pokemon;
	public CreatureGenerator(){
		//possibly accept a random seed here if needed
	}
	
	public Creature makeCreature(){
		int rarity = getRandom(10, 1);

		if (rarity > 9){
			//1/10: rare creature
		} else if (rarity > 6){
			//4/10: uncommon creature
		} else {
			//6/10;: common creature
		}
		return pokemon;
	}
	
	public void setPokemon(){
		int randomNumber = getRandom(7, 1);
		if (randomNumber == 1)
		{
			pokemon = new CreaturePidgey();
		}
		else if (randomNumber == 2)
		{
			
		}
		else if (randomNumber == 3)
		{
			
		}
		else if (randomNumber == 4)
		{
			
		}
		else if (randomNumber == 5)
		{
			
		}
		else if (randomNumber == 6)
		{
			
		}
		else if (randomNumber == 7)
		{
			
		}
	}
	
	public Creature getPokemon(){
		return pokemon;
	}
	
	private static int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}
