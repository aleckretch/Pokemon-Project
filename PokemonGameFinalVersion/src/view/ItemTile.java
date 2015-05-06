package view;

import java.awt.Image;

/**
 * This class extends Tile
 * and constructs a Tile with 
 * the image of a PokeBall
 */
public class ItemTile extends Tile{
	
	/**
	 * constructs a tile with the "Item" image
	 * @param x position of tile
	 * @param y position of tile
	 */
	public ItemTile(int x, int y)
	{
		super("pics/item-tile.png",x,y);
	}
	
	/**
	 * @return image of tile
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
		return "item";
	}
}
