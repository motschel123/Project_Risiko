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
	 * @author Felix Lehner
	 * @author Marcel Schöckel
	 */
	private ArrayList<Card> initCards() {
		return new CardLoader().load("/Assets/cards/");
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
	 * Calulates the number of cards each player gets and assignes this much cards to each player.
	 * Remaining cards are given the players from back to forth.
	 *
	 * @author Marcel Schöckel
	 */
	private void handoutCards(){
		int cardsPerPlayer = Math.floor(cards.length/players);
		int leftOverCards = cards.length % players;
		
		for(Player p: players){
			p.addCards(cards.sublist(0, cardsPerPlayer));
			cards.sublist(0, cardsPerPlayer).clear();
		}
		
		if(cards.length == leftOverCards){
			for(int x=players.length-1; i>0; i--){
				if(cards.size()==0){
					return;
				}
				players[x].addCard(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	private Color getPlayerColor() {
		return Color.BLACK;
	}
	
	private String getPlayerName() {
		return "name";
	}
}
