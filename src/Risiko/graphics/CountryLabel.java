package Risiko.graphics;

import java.awt.*;

import javax.swing.JLabel;

public class CountryLabel extends JLabel{

	public CountryLabel(Dimension bounds) {
		super("0");
		
		setText("0");
		setHorizontalTextPosition(JLabel.LEFT);
		setVerticalTextPosition(JLabel.TOP);
		setFont(new Font("Serif", Font.PLAIN, 20));
		setOpaque(true);
		setBounds(bounds.width, bounds.height, 15, 25);
		
	}
}
