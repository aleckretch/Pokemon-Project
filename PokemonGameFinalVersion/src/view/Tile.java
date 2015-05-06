/**
 * This is an abstract class
 * that holds the properties of 
 * a Tile and constructs a Tile
 * with a specific filename
 *
 */

package view;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Tile{
	
	private int x, y, width, height;
	Image image;
	
	/**
	 * takes in a filename and creates an image and 
	 * resizes it 
	 * 
	 * @param img String filename to be used in ImageIcon constructor
	 * @param x position of Tile 
	 * @param y position of Tile
	 */
	public Tile(String img, int x, int y)
	{
		Icon imageIcon = new ImageIcon(img);
		image = ((ImageIcon) imageIcon).getImage();
		width=35;
		height=35;
		image = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return integer value of the x coordinate of the tile
	 */
	public int getX()
	{
		return x*width;
	}
	
	/**
	 * @return integer value of the y coordinate of the tile
	 */
	public int getY()
	{
		return y*height;
	}
	
	/**
	 * @return integer value of the width of the tile
	 */
	public int getWidth()
	{
		return width;
		
	}
	
	/**
	 * @return integer value of the height of the tile
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * @return image of the tile
	 */
	public Image getImage()
	{
		return image;
	}
	
	/**
	 * @return string of the type of tile
	 */
	public abstract String getType();
	
	

}
