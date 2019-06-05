import java.awt.Color;
import java.Math;

public class Game {
	private ArrayList<Player> players;
	private Logic logic;
	private ArrayList<Card> cards;
	
	
	public Game(String[] names, Color[] colors) {
		
		players = shufflePlayers(initPlayers(names, colors));
		cards = shuffleCards(initCards());
		
		handoutCards();
		
	}
	
	/**
	 * Generates new players from with names and colors.
	 * @author Felix Lehner
	 */
	private ArrayList<Player> initPlayers(String[] names, Color[] colors) {
		
		ArrayList<Player> playerArray = new Player[names.length];
		
		if (names.length == colors.length) {
			for (int i = 0; i < playerArray.length; i++) {
				playerArray[i] = new Player(names[i], colors[i]);
			}
		}
		
		return playerArray;
	}
	
	/**
	 * Generates cards from existing CSV file
	 * @author Marcel Schöckel
	 */
	private ArrayList<Card> initCards() {
		CardLoader loader = new CardLoader();
		return loader.loadFrom("/Assets/cards");
	}
	
  	/**
	 * Shuffles *Players* array in new order.
	 * @author Marcel Schöckel
	 */
	private ArrayList<Player> shufflePlayers(ArrayList<Player> players) {
		Collection.shuffle(players);
		
		return players;
	}
	
	/**
	 * Shuffles *Cards* array in new order.
	 * @author Marcel Schöckel
	 */
	private ArrayList<Card> shuffleCards(ArrayList<Card> cards) {
		Collection.shuffle(cards);
		
		return cards;
	}
	
	/**
	 * 
	 *
	 */
	private void handoutCards(){
		int cardsPerPlayer = Math.floor(cards.length/players);
		
		
	}
	
	private Color getPlayerColor() {
		return Color.BLACK;
	}
	
	private String getPlayerName() {
		return "name";
	}
}
