package view;

import java.awt.Image;

/**
 * This class extends Tile and 
 * constructs a Tile with 
 * the image of a brick
 *
 */
public class BrickTile extends Tile{
	
	/**
	 * Constructor for BrickTile
	 * 
	 * @param x position of the tile
	 * @param y position of the tile
	 */
	public BrickTile(int x, int y)
	{
		super("pics/brick_tile_red.png",x,y);
	}
	/**
	 * @return the image of the Tile
	 */
	public Image getImage()
	{
		return super.getImage();
	}
	/**
	 * @return the Type of the tyle in a String
	 */
	public String getType()
	{
		return "brick";
	}

}
