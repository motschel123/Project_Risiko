package Risiko;

import Risiko.loading.CardLoader;
import Risiko.loading.CountryLoader;

import java.awt.Color;
import java.util.*;

public class Game {
	private ArrayList<Player> players;
	private Logic logic;
	private ArrayList<Card> cards;
	private Map<String, Country> countries;
	private final String mapPath;
	
	
	public Game(String[] names, Color[] colors, String mapDir) {
		mapPath = mapDir;
		players = initPlayers(names, colors);
		shufflePlayers();
		cards = initCards();
		shuffleCards();
		countries = initCountries();
		
		
		handoutCards();
		
	}
	
	/**
	 * Generates new players from with names and colors.
	 * @author Felix Lehner
	 */
	private ArrayList<Player> initPlayers(String[] names, Color[] colors) {
		
		ArrayList<Player> playerArray = new ArrayList<>();
		
		if (names.length == colors.length) {
			for (int i = 0; i < names.length; i++) {
				playerArray.add(new Player(names[i], colors[i]));
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
		return new CardLoader().loadFrom("/Assets/"+mapPath+"/cards.csv");
	}
	
  	/**
	 * Shuffles *Players* array in new order.
	 * @author Marcel Schöckel
	 */
	private void shufflePlayers() {
		Collections.shuffle(players);
	}
	
	private Map<String, Country> initCountries(){
		Map<String, Country> countries = new HashMap<>();

		ArrayList<Country> loadedCountries = new CountryLoader().loadFrom("/Assets/"+mapPath+"/countries.csv");

		for(Country count: loadedCountries){
			countries.put(count.getName(), count);
		}
		
		return countries;
	}
	
	/**
	 * Shuffles *Cards* array in new order.
	 * @author Marcel Schöckel
	 */
	private void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Calculates the number of cards each player gets and assignes this much cards to each player.
	 * Handout remaining cards from last to first player.
	 * 
	 * @since 05.05.2019
	 * @author Marcel Schöckel
	 */
	private void handoutCards(){
		int cardsPerPlayer = (int) Math.floor(cards.size()/players.size());
		int leftOverCards = cards.size() % players.size();
		
		for(Player p: players){
			p.addCards((ArrayList<Card>) cards.subList(0, cardsPerPlayer));
			cards.subList(0, cardsPerPlayer).clear();
		}
		
		if(cards.size() == leftOverCards){
			for(int i=players.size()-1; i>0; i--){
				if(cards.size()==0){
					return;
				}
				players.get(i).addCard(cards.get(0));
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
