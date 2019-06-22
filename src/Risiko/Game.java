package Risiko;

import Risiko.graphics.GUI;
import Risiko.loading.CardLoader;
import Risiko.loading.CountryLoader;

import java.awt.Color;
import java.util.*;

public class Game {
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	private ArrayList<Card> discardCards;
	private Map<String, Country> countries;
	private final String mapDir;
	
	private GUI gui;
	
	/**
	 * 
	 * @param String Array containing the player names
	 * @param Color Array containing the player colors
	 * @param String containing the map dir 
	 */
	public Game(String[] names, Color[] colors, String mapDir) {
		
		// Init everything
		this.mapDir = mapDir;
		players = initPlayers(names, colors);
		shufflePlayers();
		//cards = initCards();
		//shuffleCards();
		//countries = initCountries();
		
		// Load up GUI
		gui = new GUI();
		
		for(Player p: players) {
			gui.addPlayer(p.getName(), p.getColor());
		}
		
		
		/*
		// start game mechanics
		handoutCards();
		
		if(!placeArmee()) {
		
		}
		
		*/
		// TODO: reuse dicard cards
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
	 * Shuffles *Players* array in new order.
	 * @author Marcel Schoeckel
	 */
	private void shufflePlayers() {
		Collections.shuffle(players);
	}
	
	/**
	 * Generates cards from existing CSV file
	 * @author Felix Lehner
	 * @author Marcel Schoeckel
	 */
	private ArrayList<Card> initCards() {
		return CardLoader.loadFrom("Assets/"+mapDir+"/cards.csv");
	}
	
	/**
	 * Shuffles *Cards* array in new order.
	 * @author Marcel Schoeckel
	 */
	private void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	
	private Map<String, Country> initCountries(){
		Map<String, Country> countries = new HashMap<>();

		ArrayList<Country> loadedCountries = CountryLoader.loadFrom("Assets/"+mapDir+"/countries.csv");

		for(Country count: loadedCountries){
			countries.put(count.getName(), count);
		}
		
		return countries;
	}
	
	/**
	 * Calculates the number of cards each player gets and assignes this much cards to each player.
	 * Handout remaining cards from last to first player.
	 * 
	 * @since 05.05.2019
	 * @author Marcel Schoeckel
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
	
	private boolean placeArmee() {
		for(Player p: players) {
			if(!p.placeAllCards(this)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean placeCard(Player p, Card c, String countryName) {
		if(countries.containsKey(countryName)) {
			Country country = countries.get(countryName);
			
			if(country.getOwner() == null || country.getOwner().getName() == p.getName()) {
				country.setOwner(p);
				country.setUnitPower(country.getUnitPower() + c.getStars());
			}
			
			discardCards.add(c);
			
			return true; 
		}
		
		
		return false;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public ArrayList<Card> getDiscardCards() {
		return discardCards;
	}

	public Map<String, Country> getCountries() {
		return countries;
	}

	public String getMapDir() {
		return mapDir;
	}

	public GUI getGui() {
		return gui;
	}
}
