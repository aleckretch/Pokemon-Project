package view;


import java.awt.Image;

/**
 * This class extends Tile
 * and creates a Tile with the
 * image of light grass
 * 
 *
 */

public class LightGrassTile extends Tile{
	
	/**
	 * constructs a tile with the light grass image
	 * @param x position of tile
	 * @param y position of tile
	 */
	public LightGrassTile(int x, int y)
	{
		super("pics/lightGrass.jpeg",x,y);
	}
	
	/**
	 * @return image of tile
	 */
	public Image getImage()
	{
		return super.getImage();
	}
	
	/**
	 * @return type of tile in String
	 */
	public String getType()
	{
		return "lightGrass";
	}
	

}
