package Risiko.graphics;

import java.awt.Font;

import javax.swing.JLabel;

public class CountryLabel extends JLabel{

	public CountryLabel(int x, int y) {
		super("0");
		
		setHorizontalTextPosition(JLabel.LEFT);
		setVerticalTextPosition(JLabel.TOP);
		setFont(new Font("Serif", Font.PLAIN, 30));
		setOpaque(true);
		setBounds(x, y, 15, 22);
		
	}
}
