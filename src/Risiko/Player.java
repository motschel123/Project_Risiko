package Risiko;

import Risiko.Card;
import Risiko.Game;
import Risiko.graphics.PlayerLabel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felix Lehner
 * @author Marcel Schoeckel
 */
public class Player {
	/** The name that gets displayed. */
	final private String name;
	/** The player's color */
	final private Color color;
	/** The player's hand. */
	private List<Card> cards;
	/**  */
	private List<Country> areas;
	
	private PlayerLabel pLabel = null;
	
	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
		
		cards = new ArrayList<Card>();
		areas = new ArrayList<Country>();
	}
	
	
	public boolean placeAllCards(Game game) {
		for(Card c: cards) {
			if(!game.placeCard(this, c, c.countryName)) {
				return false;
			}
		}
		cards.clear();
		updateLabel();
		return true;
	}
	
	private boolean placeCard(Game game, Card c, String countryName) {
		if(cards.contains(c)) {
			if(game.placeCard(this, c, countryName)) {
				cards.remove(c);
				return true;
			}
		}
		updateLabel();
		return false;
	}
	
	public void updateLabel() {
		pLabel.setCardCounter(cards.size());
	}
	
	public void addLabel(PlayerLabel label) {
		pLabel = label;
	}
	
	/**
	 * Add cards to the players hand
	 * @author Marcel Schoeckel
	 */
	public void addCards(List<Card> cards){
		this.cards.addAll(cards);
		updateLabel();
	}
	
	
	public void addCard(Card card) {
		cards.add(card);
		updateLabel();
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	/** Getter Methods*/
	public Color getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
}
