package model;

import java.util.Random;

public class CreatureCommon extends Creature {
	
	public CreatureCommon(String name, int rarity) {
		super(name, rarity);
		// TODO Auto-generated constructor stub
	}
	
	Creature pokemon;

	public void setPokemon(){
		int randomNumber = getRandom(7, 1);
		if (randomNumber == 1)
		{
			pokemon = new SPECIFIC POKEMON CLASS;
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
