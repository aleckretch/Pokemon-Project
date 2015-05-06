package view;

import java.awt.Image;

/**
 * This class extends Tile and 
 * constructs a Tile with the image
 * of a Tree
 */
public class TreeTile extends Tile{
	/**
	 * constructs a Tile with the 
	 * image of a tree
	 * 
	 * @param x position of tile
	 * @param y position of tile 
	 */
	public TreeTile(int x, int y)
	{
		super("pics/tree.png",x,y);
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
		return "tree";
	}
}
