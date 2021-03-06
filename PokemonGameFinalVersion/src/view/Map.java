package view;


import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is the JPanel that 
 * constructs the Map on which the 
 * characters navigates in gameplay
 * 
 *
 */
public class Map extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Tile[][] grid;
	JPanel gridPanel;
	private static final int BRICK=1;
	private static final int LIGHT_GRASS=0;
	private static final int THICK_GRASS=2;
	private static final int WATER=3;
	private static final int TREE=4;
	private static final int ITEM=5;
	private int[][] data;
	
	private int shiftX = 0;
	private int shiftY = 0;
	
	/**
	 * constructs the 25 by
	 * 25 grid of tiles to be 
	 * painted in the paint method
	 * 
	 * @param mapNumber determines which map is used
	 */
	public Map(int mapNumber)
	{		
		grid = new Tile[25][25];
		
		if (mapNumber == 1)
		{
			data = new int[][]{
					{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
					{4,1,1,1,1,1,1,1,1,1,1,4,4,4,0,0,0,0,0,0,0,0,0,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,0,4,2,2,2,2,2,2,2,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,1,4,2,2,2,2,2,2,2,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,1,4,2,2,2,2,2,2,2,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,1,4,4,4,4,4,4,4,4,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,1,1,1,1,4,0,0,0,0,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,4,4,4,4,4,4,1,4,0,4,4,4,0,4},
					{4,1,0,0,0,0,0,0,0,0,1,3,3,3,3,3,3,1,4,2,2,2,2,2,4},
					{4,1,4,4,4,4,4,4,4,4,1,1,1,1,3,3,3,1,4,2,2,2,2,2,4},
					{4,1,4,2,2,2,2,0,0,4,1,3,3,3,3,3,3,1,4,2,2,2,2,2,4},
					{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,4,2,2,2,2,2,4},
					{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,4,4,4,4,4,0,4},
					{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,1,1,1,1,1,1,4},
					{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,4,4,4,4,4,4,1,4},
					{4,1,0,2,2,2,2,0,0,4,1,0,2,2,3,3,3,4,4,4,4,4,4,1,4},
					{4,1,4,4,4,4,4,4,4,4,1,0,0,0,3,3,3,4,4,4,4,4,4,1,4},
					{4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4},
					{4,1,0,0,0,0,0,0,0,0,1,0,4,0,4,4,4,4,0,0,0,0,0,1,4},
					{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
					{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
					{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
					{4,1,0,0,0,0,0,0,0,0,1,0,4,4,4,4,4,4,0,0,0,0,0,1,4},
					{4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4},
					{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}
			};
		}
		else if (mapNumber == 2)
		{
			data = new int[][]{
					{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
					{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,3},
					{3,1,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,1,3},
					{3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2,1,3},
					{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
					{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
			};
		}
		else if (mapNumber == 3)
		{
			data = new int[][]{
					{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
					{4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
					{4,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,4},
					{4,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,3,3,3,3,1,0,4},
					{4,0,1,0,0,0,0,0,0,4,0,1,0,0,0,0,0,1,3,3,3,3,1,0,4},
					{4,0,1,0,0,4,4,0,0,0,0,1,0,0,4,4,0,1,3,3,3,3,1,0,4},
					{4,0,1,2,2,2,0,0,0,0,0,1,0,0,4,4,0,1,1,1,1,1,1,0,4},
					{4,0,1,2,2,2,1,0,0,1,1,1,0,0,4,2,0,0,0,0,0,0,1,0,4},
					{4,0,1,2,2,2,1,0,0,0,0,0,0,2,2,2,0,2,2,2,2,0,1,0,4},
					{4,0,1,2,2,2,1,0,0,0,0,0,0,2,2,2,0,2,4,4,2,0,1,0,4},
					{4,0,1,1,1,1,1,1,1,0,4,4,0,2,2,1,0,2,4,4,2,0,1,0,4},
					{4,0,1,0,0,0,0,0,0,0,4,4,0,2,2,1,0,2,2,2,2,0,1,0,4},
					{4,0,1,0,2,2,2,0,0,0,4,0,1,1,1,1,0,0,0,0,0,0,1,0,4},
					{4,0,1,0,2,2,2,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,4},
					{4,0,1,0,4,4,4,4,0,2,2,2,1,0,0,0,2,2,2,0,0,0,1,0,4},
					{4,0,1,0,4,4,4,4,0,2,2,2,1,0,0,2,2,4,2,0,0,0,1,0,4},
					{4,0,1,0,2,2,2,2,0,2,1,1,1,1,0,2,2,2,2,0,0,0,1,0,4},
					{4,0,1,0,2,2,2,2,2,2,1,0,0,1,0,2,4,2,2,0,0,0,1,0,4},
					{4,0,1,0,2,2,0,1,1,1,1,0,0,1,0,0,1,1,1,1,0,0,1,0,4},
					{4,0,1,0,0,0,0,1,0,0,4,4,2,1,0,0,1,0,0,1,0,0,1,0,4},
					{4,0,1,3,3,0,0,1,0,0,4,2,2,1,0,0,1,4,0,1,0,0,1,0,4},
					{4,0,1,3,3,0,0,1,0,0,4,2,2,1,0,0,1,0,0,1,4,0,1,0,4},
					{4,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,4},
					{4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
					{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}
			};
		}
		
		int itemCount = 0;
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<25;j++)
			{
				int randomNumber = getRandom(15, 1);
				if(data[i][j]==BRICK)
					grid[i][j] = new BrickTile(j,i);
				
				else if(data[i][j]==LIGHT_GRASS)
				{
					if (randomNumber==8 && itemCount < 3)
					{
						grid[i][j] = new ItemTile(j,i);
						itemCount++;
					}
					else
					{
						grid[i][j] = new LightGrassTile(j,i);
					}
				}
				
				else if(data[i][j]==THICK_GRASS)
					grid[i][j] = new DarkGrassTile(j,i);
				
				else if(data[i][j]==WATER)
					grid[i][j] = new WaterTile(j,i);
				
				else if(data[i][j]==TREE)
					grid[i][j] = new TreeTile(j,i);
				
				else if(data[i][j]==ITEM)
					grid[i][j] = new ItemTile(j,i);
				
				else
					grid[i][j] = null;
				
				
			}
		}
		
	}
	
	/** 
	 * 
	 * @param max maximum possible number chosen 
	 * @param min minimum possible number chosen
	 * @return returns a random number between the max and min
	 */
	private static int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	
	public static void main(String[] args)
	{
		new Map(1);
	}
	
	/**
	 * 
	 * @return Grid of Tiles
	 */
	public Tile[][] getGrid()
	{
		return grid;
	}
	
	/**
	 * sets grid at x y to light Grass tile
	 * 
	 * @param x position of tile
	 * @param y position of tile
	 */
	public void setLightGrass(int x, int y)
	{
		grid[y][x] = new LightGrassTile(x,y);
	}
	
	/**
	 * overrides paint method
	 * 
	 * @param Graphics used to draw images
	 */
	public void paint(Graphics g)
	{		
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<25;j++)
			{
				g.drawImage(grid[i][j].getImage(), 
							grid[i][j].getX() + shiftX, 
							grid[i][j].getY() + shiftY, 
							null);
			}
		}
	}
	/**
	 * shifts x value
	 * 
	 * @param in value X is shifted by
	 */
	public void setShiftX(int in){
		shiftX += in;
	}
	
	/**
	 * shifts y value
	 * 
	 * @param in value Y is shifted by
	 */
	public void setShiftY(int in){
		shiftY += in;
	}
	/**
	 * 
	 * @return shift in X
	 */
	public int getShiftX(){
		return shiftX;
	}
	/**
	 * 
	 * @return shift in y
	 */
	public int getShiftY(){
		return shiftY;
	}
	
	
}
