package view;

import java.awt.Image;


public class WaterTile extends Tile{
	
	public WaterTile(int x, int y)
	{
		super("pics/water.jpeg",x,y);
	}
	
	public Image getImage()
	{
		return super.getImage();
	}
	
	public String getType()
	{
		return "water";
	}

	
}
