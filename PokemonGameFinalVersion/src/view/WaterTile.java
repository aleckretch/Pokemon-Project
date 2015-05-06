package view;

import java.awt.Image;

/**
 * This class extends Tile 
 * and constructs a Tile with 
 * the image of Water
 */
public class WaterTile extends Tile{
	/**
	 * constructs a Tile with the image
	 * of water
	 * 
	 * @param x position of tile
	 * @param y position of tile 
	 */
	public WaterTile(int x, int y)
	{
		super("pics/water.jpeg",x,y);
	}
	/**
	 * @return returns image of tile
	 */
	public Image getImage()
	{
		return super.getImage();
	}
	/**
	 * @return type of tile in a String
	 */
	public String getType()
	{
		return "water";
	}

	
}
