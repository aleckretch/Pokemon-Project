package view;


import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Map extends JFrame{
	
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
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,4,2,2,2,2,2,2,2,0,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,4,2,2,2,2,2,2,2,0,0},
				{0,1,0,2,2,2,2,2,2,0,1,0,0,0,0,4,2,2,2,2,2,2,2,2,0},
				{0,1,0,2,2,2,2,2,2,0,1,0,0,0,0,4,4,4,4,4,0,0,0,0,0},
				{0,1,0,2,2,2,2,2,2,0,1,0,0,0,0,0,0,0,0,4,0,0,0,0,0},
				{0,1,0,2,2,2,2,2,2,0,1,0,0,0,0,0,0,0,0,4,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,4,2,2,2,0,0},
				{0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,4,2,2,2,0,0},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,3,3,3,0,0,4,2,2,2,0,0},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,3,3,3,0,0,4,2,2,2,0,0},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,3,3,3,0,0,4,4,4,4,4,4},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,3,3,3,0,0,0,0,0,0,0,0},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,2,2,2,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
				{0,1,0,3,3,3,3,3,3,0,1,0,0,2,2,2,2,0,0,0,2,2,0,1,0},
				{0,1,0,3,3,3,3,3,3,0,1,0,0,2,2,2,2,0,0,0,2,2,0,1,0},
				{0,1,0,3,3,3,3,3,3,0,1,0,0,2,2,2,2,0,0,0,2,2,0,1,0},
				{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		
		
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<25;j++)
			{
				if(data[i][j]==BRICK)
					grid[i][j] = new BrickTile(i,j);
				
				else if(data[i][j]==LIGHT_GRASS)
					grid[i][j] = new LightGrassTile(i,j);
				
				else if(data[i][j]==THICK_GRASS)
					grid[i][j] = new DarkGrassTile(i,j);
				
				else if(data[i][j]==WATER)
					grid[i][j] = new WaterTile(i,j);
				
				else
					grid[i][j] = new TreeTile(i,j);
				
				
			}
		}
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(25,25));
		
		for(int m=0;m<25;m++)
		{
			for(int n=0;n<25;n++)
			{
				gridPanel.add(grid[m][n].getLabel());
			}
		}
		
		this.add(gridPanel);
		this.setSize(625, 625);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new Map();
	}
	
	
}
