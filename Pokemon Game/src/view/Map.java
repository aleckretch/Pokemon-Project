package view;


import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
	private int[][] data;
	
	public Map()
	{
		grid = new Tile[25][25];
		
		data = new int[][]{
				{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
				{4,1,1,1,1,1,1,1,1,1,1,4,4,4,0,0,0,0,0,0,0,0,0,0,0},
				{4,1,0,0,0,0,0,0,0,0,1,4,4,4,0,4,2,2,2,2,2,2,2,2,0},
				{4,1,0,0,0,0,0,0,0,0,1,4,4,4,1,4,2,2,2,2,2,2,2,2,0},
				{4,1,0,2,2,2,2,2,2,0,1,4,4,4,1,4,2,2,2,2,2,2,2,2,0},
				{4,1,0,2,2,2,2,2,2,0,1,4,4,4,1,4,4,4,4,4,4,4,4,4,0},
				{4,1,0,2,2,2,2,2,2,0,1,4,4,4,1,1,1,1,4,0,0,0,0,0,0},
				{4,1,0,2,2,2,2,2,2,0,1,4,4,4,4,4,4,1,4,0,4,4,4,4,0},
				{4,1,0,0,0,0,0,0,0,0,1,3,3,3,3,3,3,1,4,2,2,2,2,2,2},
				{4,1,4,4,4,4,4,4,4,4,1,1,1,1,3,3,3,1,4,2,2,2,2,2,2},
				{4,1,4,2,2,2,2,0,0,4,1,3,3,3,3,3,3,1,4,2,2,2,2,2,2},
				{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,4,2,2,2,2,2,2},
				{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,4,4,4,4,4,4,4},
				{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,1,1,1,1,1,1,1,1},
				{4,1,4,2,2,2,2,0,0,4,1,0,2,2,3,3,3,4,4,4,4,4,4,4,1},
				{4,1,0,2,2,2,2,0,0,4,1,0,2,2,3,3,3,4,4,4,4,4,4,4,1},
				{4,1,4,4,4,4,4,4,4,4,1,0,0,0,3,3,3,4,4,4,4,4,4,4,1},
				{4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{4,1,0,0,0,0,0,0,0,0,1,0,4,0,4,4,4,4,0,0,0,0,0,1,4},
				{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
				{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
				{4,1,0,3,3,3,3,3,3,0,1,0,4,2,2,2,2,4,0,0,2,2,0,1,4},
				{4,1,0,0,0,0,0,0,0,0,1,0,4,4,4,4,4,4,0,0,0,0,0,1,4},
				{4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4},
				{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}
		};
		
		
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<25;j++)
			{
				if(data[i][j]==BRICK)
					grid[i][j] = new BrickTile(j,i);
				
				else if(data[i][j]==LIGHT_GRASS)
					grid[i][j] = new LightGrassTile(j,i);
				
				else if(data[i][j]==THICK_GRASS)
					grid[i][j] = new DarkGrassTile(j,i);
				
				else if(data[i][j]==WATER)
					grid[i][j] = new WaterTile(j,i);
				
				else if(data[i][j]==TREE)
					grid[i][j] = new TreeTile(j,i);
				else
					grid[i][j] = null;
				
				
			}
		}
		
		

	}
	
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(625,625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Map());
		frame.setVisible(true);
	}
	
	public void paint(Graphics g)
	{		
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<25;j++)
			{
				g.drawImage(grid[i][j].getImage(), grid[i][j].getX(), grid[i][j].getY(), null);
			}
		}
	}
	
	
}
