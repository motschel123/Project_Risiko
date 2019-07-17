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
	
	
	private int turn = 0;
	
	private int phase = 0;
	
	private Country attackingCountry = null;
	public Country attackedCountry = null;
	
	/**
	 * 
	 * @param names Array containing the player names
	 * @param colors Array containing the player colors
	 * @param mapDir containing the map dir
	 */
	public Game(String[] names, Color[] colors, String mapDir) {
		this.mapDir = mapDir;
		setup(names, colors, mapDir);
		
		
		// Load up GUI
		gui = new GUI(this);
		
		gui.addCountryLabels(mapDir);
		
		for(Player p: players) {
			// add each player to the GUI
			// links each playerLabel to the related Player
			p.addLabel(gui.addPlayer(p.getName(), p.getColor()));
		}
		
		
		
		
		// start game mechanics
		startGame();
		
		// TODO: reuse discard cards
	}
	
	private void startGame() {
		handoutCards();
		
		if(!placeArmy()) {
			System.err.println("Handout card error");
			return;
		}
		
		cards = discardCards;
		
		nextTurn();
	}
	
	private void nextTurn() {
		/**
		 * 1. get units
		 * 2. place units
		 * 3. (opt) attack
		 * 4. move troops
		 * 4. draw cards if allowed to
		 */
		
		System.out.println(cards.size());
		// calc player who's at turn
		int playerTurn = turn % players.size();
		Player player = players.get(playerTurn); 
		
		gui.setTurn(player);
		gui.setPlacingPhase();
		gui.setPhase("Placing-Phase");
		phase = 1;
		// 1.
		player.addUnits(3);
		
		
		turn++;
	}
	
	public void attackPhase() {
		System.out.println("AttackPhase");
		phase = 2;
		gui.selectingAC = true;
		gui.setAttackingPhase();
		gui.setPhase("Attacking-Phase");
	}
	
	
	public void attack() {
		if(attackingCountry != null && attackedCountry != null) {
			for(String countryName: attackingCountry.getBorders()) {
				if(countryName.equalsIgnoreCase(attackedCountry.getName())) {
					System.out.println("yeet");
					if(attackSuccessful()) {
						System.out.println("succ");
						attackedCountry.setUnitPower(attackedCountry.getUnitPower() - 1);
						gui.countryLabels.get(countryName).update();
						if(attackedCountry.getUnitPower() <= 0) {
							attackedCountry.setOwner(attackingCountry.getOwner());
							attackedCountry.setUnitPower(1);
							gui.countryLabels.get(countryName).update();
							gui.countryLabels.get(countryName).setForeground(attackingCountry.getOwner().getColor());
						}
					} else {
						System.out.println("sitt");
						gui.countryLabels.get(countryName).update();
						attackingCountry.setUnitPower(attackingCountry.getUnitPower() - 1);
						gui.countryLabels.get(attackingCountry.getName()).update();
						if(attackingCountry.getUnitPower() <= 0 || attackingCountry.getUnitPower() == 0) {
							attackingCountry.setOwner(attackedCountry.getOwner());
							attackingCountry.setUnitPower(1);
							gui.countryLabels.get(attackingCountry.getName()).update();
							movePhase();
						}
					}
					gui.countryLabels.get(attackingCountry.getName()).update();
					gui.countryLabels.get(attackingCountry.getName()).setForeground(attackingCountry.getOwner().getColor());
					attackingCountry=null;
					gui.selectingAC = true;
					gui.setPhase("Attackphase");
					
				}
			}
		}
	}
	
	private boolean attackSuccessful() {
		if(Math.random() > 0.5) {
			return true;
		} 
		return false;
	}
	
	public void movePhase() {
		System.out.println("MovePhase");
		
		gui.setPhase("Move phase");
	}
	
	public Country getCountryByName(String name) {
		return countries.get(name);
	}
	
	private void setup(String[] names, Color[] colors, String mapDir) {
		// Init everything
		players = initPlayers(names, colors);
		shufflePlayers();
		cards = initCards();
		shuffleCards();
		countries = initCountries();
		
		discardCards = new ArrayList<Card>();
	}
	
	/**
	 * Generates new players with names and colors.
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
		return CardLoader.loadFrom(mapDir);
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

		ArrayList<Country> loadedCountries = CountryLoader.loadFrom(mapDir);

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
			p.addCards(cards.subList(0, cardsPerPlayer));
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
	
	private boolean placeArmy() {
		for(Player p: players) {
			if(!p.placeAllCards(this)) {
				return false;
			}
		}
		
		//updateCountryGUI();
		return true;
	}
	
	public boolean placeCard(Player p, Card c, String countryName) {
		if(countries.containsKey(countryName)) {
			Country country = countries.get(countryName);
			
			if(country.getOwner() == null || country.getOwner().getName() == p.getName()) {
				country.setOwner(p);
				country.setUnitPower(country.getUnitPower() + c.getStars());
				gui.updateCountryLabels(countries);
			}
			
			discardCards.add(c);
			
			return true; 
		}
		
		
		return false;
	}
	
	public void setAttackingCountry(Country c) {
		attackingCountry = c;
	}
	
	public Country getAttackingCountry() {
		return attackingCountry;
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
	
	public int getPhase() {
		return phase;
	}
}
