package view;

import java.awt.Image;


public class BrickTile extends Tile{
	
	public BrickTile(int x, int y)
	{
		super("pics/brick_tile_red.png",x,y);
	}
	
	public Image getImage()
	{
		return super.getImage();
	}
	
	public String getType()
	{
		return "brick";
	}
}
