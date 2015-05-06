package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Battle;
import view.Sprite;

//TODO 8: Look at and discuss SpriteObject.
// Consider: Despite having no abstract methods, this class is abstract. Why would that be necessary?
public abstract class SpriteObject {
	public Point position; // position of the sprite object
	private Sprite sprite; // the object's sprite
	private Image frame; // the last frame of the sprite
	private Timer t; // timer used to update the frame
    private double steps = 0;
    private int allowedSteps = 500;
    private int spriteX;
    private int spriteY;
    private Battle battle;
	
	final int UP = 0;
	final int DOWN = 1;
	final int LEFT = 2;
	final int RIGHT = 3;
	final int TILE_WIDTH = 35;
	final int FIGHTING_LIKELIHOOD = 975; //out of 1000
	FrogRunner frogRunner;
	Map map;
	/**
	 * Constructs a new SpriteObject.
	 * 
	 * @param sprite	sprite to use for this object
	 * @param x	x position of the object
	 * @param y	y position of the object
	 * @param delay	delay in switching animation frames
	 */
	protected SpriteObject(Sprite sprite, int x, int y, int delay, Map map, FrogRunner frogRunner){
		battle = new Battle(frogRunner);
		this.sprite = sprite;
		this.position = new Point(x, y);
		spriteX = this.position.x;
		spriteY = this.position.y;
		frame = sprite.getImage();
		this.map = map;
		this.frogRunner = frogRunner;
		// this timer is constructed using an anonymous class
		t = new Timer(delay, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nextFrame();
			}
		});
	}
	
	/**
	 * Get the sprite for this SpriteObject
	 * @return	the object's sprite
	 */
	public Sprite getSprite(){
		return sprite;
	}
	
	/**
	 * Sets the SpriteObject to be at the given position
	 * @param x	the new x position
	 * @param y	the new y position
	 */
	public void setPosition(int x, int y){
		position.setLocation(x, y);
	}

	/**
	 * Draws the SpriteObject on the given context
	 * @param g	the graphics context to render to
	 */
	public void draw(Graphics g){
		if (sprite != null && !sprite.isFinished()) // only render if not finished
			//g.drawImage(frame, position.x  - sprite.getWidth(), position.y - sprite.getHeight(), null);
			g.drawImage(frame, position.x, position.y, null);
	}
	
	/**
	 * Move the SpriteObject left
	 */
	public void moveLeft(){
		if (!noObstacle(LEFT)){
			return;
		}
		if (sprite.getState() != Sprite.State.MOVING_RIGHT){
			sprite.setState(Sprite.State.MOVING_RIGHT);
			nextFrame();
		}
		
		battle.setShiftX(-3);
		spriteX = spriteX + 3;
        addStep();

	}
	
	/**
	 * Move the SpriteObject right
	 */
	public void moveRight(){

		if (!noObstacle(RIGHT)){
			return;
		}
		if (sprite.getState() != Sprite.State.MOVING_LEFT){
			sprite.setState(Sprite.State.MOVING_LEFT);
			nextFrame();
		}

		model.Battle.setShiftX(3);
		spriteX = spriteX - 3;
        addStep();
		
	}
	
	/**
	 * Move the SpriteObject up
	 */
	public void moveUp(){
		
		if (!noObstacle(UP)){
			return;
		}
		if (sprite.getState() != Sprite.State.MOVING_DOWN){
			sprite.setState(Sprite.State.MOVING_DOWN);
			nextFrame();
		}
		model.Battle.setShiftY(-3);
		spriteY = spriteY + 3;
        addStep();
		

	}
	
	/**
	 * Move the SpriteObject down
	 */
	public void moveDown(){
		
		if (!noObstacle(DOWN)){
			return;
		}
		if (!noObstacle2(spriteX + 5, spriteY))
			return;
		if (sprite.getState() != Sprite.State.MOVING_UP){
			sprite.setState(Sprite.State.MOVING_UP);
			nextFrame();
		}
		
		model.Battle.setShiftY(3);
		spriteY = spriteY - 3;
        addStep();
		

	}
	
	/**
	 * Stop moving the SpriteObject
	 */
	public void moveStop(){
		if (sprite.getState() != Sprite.State.IDLE){
			sprite.setState(Sprite.State.IDLE);
			nextFrame();
		}
	}
	
	/**
	 * Start animating the SpriteObject
	 */
	public void start(){
		if (!t.isRunning())
			t.start();
		sprite.reset();
	}
	
	/**
	 * Stop animating the sprite
	 */
	public void stop(){
		t.stop();
	}
	
	/**
	 * Advance the frame to the next image
	 */
	private void nextFrame(){
		frame = sprite.getImage();
	}
	
	private boolean noObstacle2(int y, int x){
		Tile futureTile = map.getGrid()[x/TILE_WIDTH][y/TILE_WIDTH];
		if (futureTile instanceof TreeTile){
			return false;
		}
		if (futureTile instanceof WaterTile){
			return false;
		}
		return true;
	}
	
	/** 
	 * checks if there is an obstacle at the tile the character
	 * desires to move to
	 * 
	 * @param the direction attempted to move
	 * @return returns true if the character can move
	 */
	private boolean noObstacle(int direction){
		//System.out.print(position.x + ", ");
		//System.out.println(position.y);
		//YES-THESE ARE SWITCHED, POSSIBLY SOMETHING TO DEAL WITH IN THE FUTURE
		//int tilePositionY = position.x / TILE_WIDTH;
		//int tilePositionX = position.y  / TILE_WIDTH ;//same as height
		int tilePositionX;;
		int tilePositionY;
		int precision = 3;
		
		if (map.getGrid()[spriteY / TILE_WIDTH][spriteX / TILE_WIDTH] instanceof DarkGrassTile){
			darkGrassHit();
		}
		
		
		switch (direction){
		
		case UP:
			tilePositionX = spriteX / TILE_WIDTH;
			tilePositionY = (spriteY + precision + sprite.getHeight()) / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			break;
			
		case DOWN:
			tilePositionX = spriteX / TILE_WIDTH;
			tilePositionY = (spriteY - precision) / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			break;
		case LEFT:
			tilePositionX = (spriteX+sprite.getWidth() + precision) / TILE_WIDTH;
			tilePositionY = (spriteY+sprite.getHeight()) / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			tilePositionY = spriteY / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			break;
		case RIGHT:
			tilePositionX = (spriteX - precision) / TILE_WIDTH;
			tilePositionY = (spriteY+sprite.getHeight()) / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				System.out.println("tree");
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				System.out.println("water");
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			tilePositionY = spriteY / TILE_WIDTH;
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof TreeTile){
				System.out.println("tree");
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof WaterTile){
				System.out.println("water");
				return false;
			}
			if (map.getGrid()[tilePositionY][tilePositionX] instanceof ItemTile){
				itemHit(tilePositionX, tilePositionY);
			}
			
/*
			if (map.getGrid()[tilePositionX][tilePositionY] instanceof BrickTile){
				System.out.println("brick");
			}
			if (map.getGrid()[tilePositionX][tilePositionY] instanceof LightGrassTile){
				System.out.println("Light Grass");
			}
			if (map.getGrid()[tilePositionX][tilePositionY] instanceof DarkGrassTile){
				System.out.println("Dark Grass");
			}
			*/
			break;
				
		}
		return true;
	}
    
	/** 
	 * increases step count by .2
	 * 
	 */
    public void addStep(){
        steps = steps + .2;
    }
    
    /** 
	 * 
	 * @return returns integer value of total steps
	 */
    public int getSteps(){
        return (int)steps;
    }
    
    /** 
	 * 
	 * @return returns integer value of total allowed steps
	 */
    public int getAllowedSteps(){
        return allowedSteps;
    }
    
    /** 
	 * 
	 * @return returns integer value of number of caught pokemon
	 */
    public int getNumPokemon(){
    	return battle.p.totalCreatures;
    }
    
	/** 
	 * give an item if an item tile is hit, then reset the tile to light grass
	 * 
	 * @param the x value of the character
	 * @param the y value of the character
	 */
    public void itemHit(int x, int y) {
    	frogRunner.releaseKey();

    	map.setLightGrass(x, y);
    	int random = getRandom(4, 1);
    	if (random == 1)
    	{
    		frogRunner.addItem("steps");
        	allowedSteps = allowedSteps + 100;
        	JOptionPane.showConfirmDialog(null, "You found an additional steps item! This item gives you 100 additional steps in the safari zone.", "Item Obtained!", JOptionPane.PLAIN_MESSAGE);
    	}
    	else if (random == 2)
    	{
    		frogRunner.addItem("safari ball");
        	JOptionPane.showConfirmDialog(null, "You found the safari ball item! This item increases your chance at catching pokemon.", "Item Obtained!", JOptionPane.PLAIN_MESSAGE);
    	}
    	else
    	{
    		frogRunner.addItem("hp view");
        	JOptionPane.showConfirmDialog(null, "You found the HP view item! This item lets you view a pokemon's HP level in battle.", "Item Obtained!", JOptionPane.PLAIN_MESSAGE);
    	}
    }
    
	/** 
	 * a chance that the player could fight a pokemon
	 */
    public void darkGrassHit(){
    	System.out.println("could fight pokemon");
    	if (getRandom(1000, 1) > FIGHTING_LIKELIHOOD){
    		frogRunner.releaseKey();
			battle.battle();
		}
    }
    
	/** 
	 * returns a random number in between two desired numbers
	 * 
	 * @param the maximum the random number can be
	 * @param the minimum the random number can be
	 * @return the random integer
	 */
	private static int getRandom(int max, int min){
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}

