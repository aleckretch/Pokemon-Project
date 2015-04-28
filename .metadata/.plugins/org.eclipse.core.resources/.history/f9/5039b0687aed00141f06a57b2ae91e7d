package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import view.Frog;
import view.SpriteObject;


public class FrogRunner {
	private TreeSet<Character> keySet;
	private SpriteObject frog;
	private Map map;
	private JPanel panel;
	private Timer animTimer;
	
	// TODO 7: run the runner and click to see explosions!
	// TODO 15: run this and move the frog around!
	
	public FrogRunner() {
		keySet = new TreeSet<Character>();
		map = new Map();
		// TODO 13: uncomment these two lines
		frog = new Frog(400, 300);
		frog.start();
		
		// creates the panel that actually draws the sprites
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				// TODO 14: uncomment the next line
				frog.draw(g);
				
			}
		};
		
		panel.setPreferredSize(new Dimension(400,300));
		
		// creates the timer for animating the panel
		animTimer = new Timer(15, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (frog != null){ // move the frog according to what keys are being pressed
					if (keySet.contains('w'))
						frog.moveUp();
					else if (keySet.contains('a'))
						frog.moveLeft();
					else if (keySet.contains('s'))
						frog.moveDown();
					else if (keySet.contains('d'))
						frog.moveRight();
					else
						frog.moveStop();
				}
				
				
				// repaint the panel
				panel.repaint();
			}
			
		});
				
		map.add(panel);
		
		map.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
		
		map.setVisible(true);
		animTimer.start();
	}
	
	public static void main(String[] args){
		new FrogRunner();
	}
}

