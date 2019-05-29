import java.awt.Color;

public class Game {
	private Player[] players;
	private Logic logic;
	
	
	
	public enum Area{
		
	}
	
	public Game(String[] names, Color[] colors) {
		
		players = initPlayers(names, colors);
		
		
	}
	
	/**
	 * Generates new players from with names and colors.
	 * @author Felix Lehner
	 */
	private Player[] initPlayers(String[] names, Colors[] colors) {
		
		Player[] playerArray = new Player[names.length];
		
		if (names.length == colors.length) {
			for (int i = 0; i < playerArray.length; i++) {
				playerArray[i] = new Player(names[i], colors[i])
			}
		}
		
		return playerArray;
	}
}
