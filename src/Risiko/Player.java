package Risiko;

import Risiko.Card;
import Risiko.Game;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Felix Lehner
 * @author Marcel Schöckel
 */
public class Player {
	/** The name that gets displayed. */
	final private String name;
	/** The player's color */
	final private Color color;
	/** The player's hand. */
	private ArrayList<Card> cards;
	/**  */
	private ArrayList<Game> areas;
	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	
	/** Getter Methods*/
	public Color getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Add cards to the players hand
	 * @author Marcel Schöckel
	 */
	public void addCards(ArrayList<Card> cards){
		this.cards.addAll(cards);
	}

	public void addCard(Card card) {
		cards.add(card);
	}
}
