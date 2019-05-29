import java.awt.Color;

public class Game {
	private Player[] players;
	private Logic logic;
	private Card[] cards;
	
	
	public enum Area{
		
	}
	
	public Game(int playerCount) {
		
		players = initPlayers(playerCount);
		cards = initCards();
		
		shuffle(players, cards);
		
		
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
	
	private void shuffle(){
		Object[] obj = Logic.shuffle(players, cards);
		players = ob[0];
		cards = obj[1];
	}
	
	private Card[] initCards() {
		// TODO: initiate cards from XML/JSON file to keep game consistent
		
	}
	
	private Color getPlayerColor() {
		return Color.BLACK;
	}
	
	private String getPlayerName() {
		return "name";
	}
}
