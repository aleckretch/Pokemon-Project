package view;
import java.awt.BorderLayout;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import view.Frog;
import view.SpriteObject;


public class FrogRunner{
	private TreeSet<Character> keySet;
	private SpriteObject frog;
	private JPanel panel;
	private JLayeredPane lpane = new JLayeredPane();
	private Timer animTimer;
	Map map;
	// TODO 7: run the runner and click to see explosions!
	// TODO 15: run this and move the frog around!
	
	public FrogRunner() {
		map = new Map();
		keySet = new TreeSet<Character>();

		// TODO 13: uncomment these two lines
		frog = new Frog(20, 25);
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
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(625, 625));
		frame.setLayout(new BorderLayout());
		lpane.setBounds(0,0,625,625);
		map.setBounds(0,0,625,625);
		map.setOpaque(true);
		panel.setBounds(0,0,625,625);
		panel.setOpaque(false);
		lpane.add(map, new Integer(0),0);
		lpane.add(panel, new Integer(1), 0);
		frame.add(lpane);
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
		
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
				map.repaint();
				panel.repaint();
			}
			
		});
				
		
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
	
		animTimer.start();
	}
	
	public static void main(String[] args){
		new FrogRunner();
	}
}

