import java.awt.Color;
import java.util.ArrayList;

/*
 * 
 * @author Felix Lehner
 */
public class Player {
	/** The name that gets displayed. */
	final private String name;
	/** The player's color */
	final private Color color;
	/** The player's hand. */
	private ArrayList<Card> cards;
	/**  */
	private ArrayList<Game.Area> areas;
	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
}
