import java.awt.Color;

public class Game {
	private Player[] players;
	private Logic logic;
	private Card[] cards;
	
	
	public enum Area{
		
	}
	
	public Game(String[] names, Color[] colors) {
	
		players = initPlayers(names, colors);
		cards = initCards();
		
		shuffle();
	}
	
	/**
	 * Generates new players from with names and colors.
	 * @author Felix Lehner
	 */
	private Player[] initPlayers(String[] names, Color[] colors) {
		
		Player[] playerArray = new Player[names.length];
		
		if (names.length == colors.length) {
			for (int i = 0; i < playerArray.length; i++) {
				playerArray[i] = new Player(names[i], colors[i]);
			}
		}
		
		return playerArray;
	}
  //TODO this does not make any sense
	private void shuffle() {
		Object[] obj = logic.shuffle(players, cards);
		players = ob[0];
		cards = (Card) obj[1];
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
