package Risiko;

import java.awt.Color;


public class main {

	static Game game;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] playerNames = new String[] {"Marcel", "Felix", "Moritz", "Dennis"};
		Color[] colors = new Color[] {Color.green, Color.red, Color.cyan, Color.orange};
		String mapDir = "MapExample1";
		
		
		game = new Game(playerNames, colors, mapDir);
	}

}