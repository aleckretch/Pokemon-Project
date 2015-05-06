package model;


import java.util.Scanner;

import javax.swing.JFrame;

import view.FrogRunner;
import view.GUI;
import view.Index;
import view.Map;
import view.MusicPlayer;
import model.Creature;
import model.CreatureGenerator;
import model.Player;

/**
 * Battle class calls for a new battle vs a Pokemon
 */
public class Battle {
	static JFrame theGame;
	public static Player p;
	static CreatureGenerator cg = new CreatureGenerator();
	static Map map;
	static GUI gui;
	
	/**
	 * constructor sets the player
	 * @param takes the player
	 */
	public Battle(FrogRunner frogRunner){
		p = new Player("Me", frogRunner);
	}
	
	public static void main(String[] args){
		//battle();
		theGame = new JFrame("Pokemon Game");
		theGame.setSize(600, 400);
		theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGame.setLayout(null);	
		Index index = new Index();
		theGame.add(index);
		index.setBounds(0, 0, 600, 400);
		
		theGame.setVisible(true);
	}
	
	/**
	 * the options for the player
	 */
	public static void printOptions(){
		System.out.println("1: rock");
		System.out.println("2: bait");
		System.out.println("3: ball");
		System.out.println("4: nothing");
		System.out.println();
	}
	/**
	 * sets the stage for the battle
	 */
	public static void battle(){
		if (!p.isEnemyPresent()){
			cg.setPokemon();
			p.faceCreature(cg.getPokemon());
			if (p.getTarget() instanceof CreatureMewtwo){
				MusicPlayer.playTransition("audio/RareFightTransition.wav");
			}
			else{
				MusicPlayer.playTransition("audio/CommonFightTransition.wav");
			}
			new GUI(p);
			p.resetEnemyPresent();
		}
	}
	/**
	 * sets the map for the battle to know what to return to after the battle
	 * @param the map
	 */
	public static void setMap(Map mapIn){
		map = mapIn;
	}
	/**
	 * shifts the x coordinate on the map
	 * @param integer of the amount to shift the map
	 */
	public static void setShiftX(int in){
		map.setShiftX(in);
	}
	/**
	 * shifts the y coordinate on the map
	 * @param integer of the amount to shift the map
	 */
	public static void setShiftY(int in){
		map.setShiftY(in);
	}
	/*
	public static void goToMapScreen(){
		theGame.removeAll();
		theGame.add(map);
		theGame.setVisible(true);
		System.out.println("Going to map screen");
	}*/
}
