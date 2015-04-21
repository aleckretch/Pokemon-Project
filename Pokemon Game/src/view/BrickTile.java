package view;

import javax.swing.JLabel;


public class BrickTile extends Tile{
		
	public BrickTile(int x, int y)
	{
		super("pics/brick_tile_red.png",x,y);
	}
	
	public JLabel getLabel()
	{
		return super.getLabel();
	}

}
