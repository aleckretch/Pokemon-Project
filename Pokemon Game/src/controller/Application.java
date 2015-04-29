package controller;


import java.util.Scanner;

import creatures.CommonCreature;
import creatures.Mouse;
import view.GUI;
import model.Creature;
import model.CreatureGenerator;
import model.Player;

public class Application {
	static Scanner s = new Scanner(System.in);
	static Player p = new Player("Me");
	static Mouse[] creatures;
	
	public static void main(String[] args){

		//creatures = new Mouse[2];
		//CommonCreature first = new CommonCreature("c0", 9);
		
		//creatures[1] = new Mouse("c1", 9);
		//creatures[0] = new Mouse("c0", 1);
		//creatures[1] = new Mouse("c1", 9);
		//p.faceCreature(creatures[0]);
		//p.faceCreature(first);
		//GUI gui = new GUI(p);

		CreatureGenerator cg = new CreatureGenerator();
		cg.setPokemon();
		p.faceCreature(cg.getPokemon());
		GUI gui = new GUI(p);

		//gui.updateEnemyPic();
		/*
		while (creatures[0].isPresent()){
			printOptions();
			int in = s.nextInt();
			if (in == 1){
				p.throwRock();
				System.out.println(creatures[0].getHp());
			}
			else if (in == 2){
				p.throwBait();
			}
			else if (in == 3){
				p.throwBall();
			}
			else if (in == 4){
				System.out.println(creatures[0].getHp());
			}
		}
		gui.updateCollection(p.getCollection());
		p.faceCreature(creatures[1]);
		while (creatures[1].isPresent()){
			printOptions();
			int in = s.nextInt();
			if (in == 1){
				p.throwRock();
			}
			else if (in == 2){
				p.throwBait();
			}
			else if (in == 3){
				p.throwBall();
			}
			else if (in == 4){
				System.out.println(creatures[0].getHp());
			}
		}*/
		//gui.updateCollection(p.getCollection());
	}
	public static void printOptions(){
		System.out.println("1: rock");
		System.out.println("2: bait");
		System.out.println("3: ball");
		System.out.println("4: nothing");
		System.out.println();
	}
}
