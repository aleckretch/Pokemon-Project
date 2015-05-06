package view;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Thread.State;

import javax.imageio.ImageIO;

/**
 * This class sets the character sprite
 */
	public class FrogSprite extends Sprite {
		private static final int leftBorder = 0, vertBorder = 0; // magic numbers for the sheet
		private static final int MAX_FRAMES = 3; // more magic numbers
		private static final int width = 17, height = 25; // width and height of a single frame
		
		private static BufferedImage sheet; // the sprite sheet
		private State previousState; // the last state of the frog

		// TODO 11: talk about FrogSprite
		/**
		 * @param takes an integer that determines which player sprite will be selected
		 */
		public FrogSprite(int playerNumber){
			if (sheet == null) // load the sprite sheet into memory
				try{
					if (playerNumber == 1)
						sheet = ImageIO.read(new File("pics/pokeguy-red-sprite-sheet.png"));
					else if (playerNumber == 2)
						sheet = ImageIO.read(new File("pics/pokeguy-blue-sprite-sheet.png"));
				}catch(Exception e){};
			previousState = State.MOVING_DOWN; // what is this for?
		}
		
		@Override
		public void setState(State state){ // why is this being overridden?
			previousState = getState();
			super.setState(state);
		}
		
		@Override
		public Image getImage() {
			// TODO 12: finish implementing getImage in Frog. 
			
			if (sheet == null)
				return null;
			
			int row = 0, col = frame, offset = 0;
			
			// Unlike explosion, we have to consider the sprite's different states
			switch(getState()){
				case IDLE: 
					col = 0;
					switch (previousState) {
						case MOVING_UP:
							row = 1;
							break;
						case MOVING_DOWN:
							row = 0;
							break;
						case MOVING_LEFT:
							row = 2;
							break;
						case MOVING_RIGHT:
							row = 3;
							break;
						default:
							break;
					}
					break;		
				case MOVING_UP:
					row = 1;
					break;
				case MOVING_DOWN:
					row = 0;
					break;
				case MOVING_LEFT:
					row = 2;
					break;
				case MOVING_RIGHT:
					row = 3;
					break;
				default:
					break;
			}
		
			/*
			 * This is a bit of hard-coding because certain 
			 * frames in the sheet are thinner than others
			 */
			
			frame = (frame + 1) % MAX_FRAMES; // increment frame
			
			// get the subimage of the frame from the row and column
			BufferedImage temp = sheet.getSubimage(leftBorder + col * width, row * (height + vertBorder), width - offset, height);
			
			// Up-scaling the frame by 2x
			return temp.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		}

		@Override
		public int getHeight() {
			return height;
		}

		@Override
		public int getWidth() {
			return width;
		}
}


