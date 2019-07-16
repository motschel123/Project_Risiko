package Risiko.graphics;

import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{
	
	private String filePath;
	private int x, y;
	private final int width = 70;
	private final int height = 200;
	
	
	public Card(String filePath, int x, int y) {
		super();
		this.filePath = filePath;
		this.x = x;
		this.y = y;
		
		initialize();
	}
	
	private void initialize(){
				
		// init that background label to contain the map image
        setAlignmentX(10.0f);
        setAutoscrolls(true);
        setBounds(x, y, width, height);
        ImageIcon bgImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(filePath)));
        bgImageIcon.getImage().getScaledInstance(-1, (int) getBounds().getHeight(), java.awt.Image.SCALE_SMOOTH);
        setIcon(bgImageIcon);
	}
	
	public void setEnabled(boolean enabled){
		setVisible(enabled);
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		
		setBounds(x, y, width, height);
	}
}
