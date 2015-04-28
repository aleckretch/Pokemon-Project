package view;

import java.awt.Image;


public class TreeTile extends Tile{
	
	public TreeTile(int x, int y)
	{
		super("pics/tree.jpg",x,y);
	}
	
	public Image getImage()
	{
		return super.getImage();
	}
	
	public String getType()
	{
		return "tree";
	}
}
