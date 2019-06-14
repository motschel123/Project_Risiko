package Risiko;

import java.awt.image.BufferedImage;

public class Card {
	
	final int stars;
	final String area;
	
	public Card(int stars, String area) {
		this.stars = stars;
		this.area = area;
	}

	public int getStars() {
		return stars;
	}

	public String getArea() {
		return area;
	}
}
