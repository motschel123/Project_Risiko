package Risiko.graphics;

import java.awt.Color;
import java.util.Map;

import javax.swing.JFrame;

public class StartMenu extends javax.swing.JWindow{
	
	private JFrame frame;
	
	private Map<String, Color> players;
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new StartMenu();
		
		
		/*String[] playerNames = new String[] {"Marcel", "Felix", "Moritz", "Dennis"};
		Color[] colors = new Color[] {Color.green, Color.red, Color.cyan, Color.orange};
		String mapDir = "StandardMap";
		
		
		game = new Game(playerNames, colors, mapDir);
	}*/
	
	public StartMenu() {
		initialize();
		
		frame.setVisible(true);
	}
	
    private void initialize() {
        // init the basic frame holding everything
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        //frame.setUndecorated(true);  // fullscreen
        frame.setBounds(100, 100, 400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Menu");
    }
}