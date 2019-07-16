package Risiko.graphics;

import java.awt.*;

import javax.swing.JLabel;

import Risiko.Country;

public class CountryLabel extends JLabel{
	
	private Country country;
	private Font font = new Font("Carlito", Font.BOLD, 20);

	public CountryLabel(Dimension bounds, Country country) {
		super("0");
		
		this.country = country;
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.TOP);
		setFont(font);
		setOpaque(false);
		setBounds(bounds.width, bounds.height, 15, 25);
		
	}

	public Country getCountry() {
		return country;
	}
}
