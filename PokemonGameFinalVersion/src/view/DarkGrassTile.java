package view;

import java.awt.Image;

/**
 * This class extends Tile
 * and constructs a Tile with 
 * and image of dark grass
 *
 */
public class DarkGrassTile extends Tile{
	/**
	 * Constructs a tile
	 * with an image of dark grass
	 * 
	 * @param x position of tile
	 * @param y position of tile
	 */
	public DarkGrassTile(int x, int y)
	{
		super("pics/thickGrass.jpeg",x,y);
	}
	/**
	 * @return image of tile
	 */
	public Image getImage()
	{
		return super.getImage();
	}
	/**
	 * @return Type of tile in a String
	 */
	public String getType()
	{
		return "darkGrass";
	}

}
