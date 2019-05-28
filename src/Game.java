import java.awt.Color;

public class Game {
	private Player[] players;
	private Logic logic;
	
	//das finde ich nicht gut ändere das!! 
	
	public enum Area{
		
	}
	
	public Game(int playerCount) {
		
		players = initPlayers(playerCount);
		
		
	}
	
	// initiate Players
	// TODO: make each player Enter their name/color
	
	private Player[] initPlayers(int playerCount) {
		
		String[] names = new String[playerCount];
		Color[] colors = new Color[playerCount];
		
		Player[] playerArray = new Player[playerCount];
		
		for(Player p: playerArray) {
			String pName = getPlayerName();
			Color pColor = getPlayerColor();
			
			p = new Player(pName, pColor);
		}
		
		return playerArray;
	}
	
	private Color getPlayerColor() {
		return Color.BLACK;
	}
	
	private String getPlayerName() {
		return "name";
	}
}
