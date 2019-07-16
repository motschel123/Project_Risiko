package Risiko.graphics;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class PlayerLabel extends JLabel {
	
	boolean isTurn;
	int numberOfCards = 0;
	int numberOfAreas = 0;
	
	String name;
	Color color;

	public PlayerLabel(String name, Color color) {
		super(name, SwingConstants.CENTER);
		this.name = name;
		this.color = color;
		setHorizontalTextPosition(JLabel.CENTER);
		setBackground(color);
		setFont(new Font("Carlito", Font.PLAIN, 30));
		setForeground(Color.WHITE);
		setOpaque(true);

		updateText();
	}
	
	public void setCardCounter(int numCards) {
		numberOfCards = numCards;
		updateText();
	}
	
	public void updateText() {
		List<String> strings = new LinkedList<String>();
		
		/*if(isTurn) {
			strings.add("X");
		} else {
			strings.add("O");
		}*/
		strings.add(name);
		strings.add("|");
		strings.add(String.valueOf(numberOfAreas + " Gebiete"));

		setText(String.join(" ", strings));
		repaint();
	}
	
	public void setAreasCounter(int areas) {
		numberOfAreas = areas;
	}
}
