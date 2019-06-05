import java.awt.image.BufferedImage;

public class Card {
	
	int stars;
	Country area;
	BufferedImage icon; 
	
	public Card(int stars, Country area, BufferedImage icon) {
		this.stars = stars;
		this.area = area;
		this.icon = icon;
	}
}
