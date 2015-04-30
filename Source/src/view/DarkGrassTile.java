package view;

import java.awt.Image;

public class DarkGrassTile extends Tile{
	
	public DarkGrassTile(int x, int y)
	{
		super("pics/thickGrass.jpeg",x,y);
	}
	
	public Image getImage()
	{
		return super.getImage();
	}
	
	public String getType()
	{
		return "darkGrass";
	}

}
