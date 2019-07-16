package Risiko.graphics;

import java.awt.*;

import javax.swing.JLabel;

public class CountryLabel extends JLabel{
	
	private Font font = new Font("Carlito", Font.BOLD, 20);

	public CountryLabel(Dimension bounds) {
		super("0");
		
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.TOP);
		setFont(font);
		setOpaque(false);
		setBounds(bounds.width, bounds.height, 15, 25);
		
	}
}
