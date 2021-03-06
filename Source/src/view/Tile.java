package view;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Tile{
	
	private int x, y, width, height;
	Image image;
	
	
	public Tile(String img, int x, int y)
	{
		Icon imageIcon = new ImageIcon(img);
		image = ((ImageIcon) imageIcon).getImage();
		width=25;
		height=25;
		image = image.getScaledInstance(width,height,1);
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x*width;
	}
	
	public int getY()
	{
		return y*height;
	}
	
	public int getWidth()
	{
		return width;
		
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public abstract String getType();
	
	

}
