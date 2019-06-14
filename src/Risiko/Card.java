package Risiko;

public class Card {
	
	final int stars;
	final String countryName;
	
	public Card(int stars, String area) {
		this.stars = stars;
		this.countryName = area;
	}

	public int getStars() {
		return stars;
	}

	public String getCountryName() {
		return countryName;
	}
}
