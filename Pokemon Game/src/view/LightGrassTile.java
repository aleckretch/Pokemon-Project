package view;


import java.awt.Image;

public class LightGrassTile extends Tile{
	
	public LightGrassTile(int x, int y)
	{
		super("pics/lightGrass.jpeg",x,y);
	}
	
	public Image getImage()
	{
		return super.getImage();
	}
	
	public String getType()
	{
		return "lightGrass";
	}
	

}
