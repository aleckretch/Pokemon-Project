package view;
import view.FrogSprite;

/**
 * This class extends SpriteObject.
 *The constructor calls the constructor
 *of FrogSprite
 */
public class Frog extends SpriteObject{
	/**
	 * 
	 * @param x position of sprite
	 * @param y position of sprite
	 * @param playerNumber determines which sprite sheet is used
	 * @param map determines which map is used
	 * @param frogRunner runner that runs the animation
	 */
	public Frog(int x, int y, int playerNumber, Map map, FrogRunner frogRunner){
		super(new FrogSprite(playerNumber), x, y, 100, map, frogRunner);
	}
	
	
}

