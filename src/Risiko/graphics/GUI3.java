package Risiko.graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import Risiko.Game;
import Risiko.Player;

/**
  * @author Felix Lehner
  */
public class GUI3 extends JFrame{
	private JLayeredPane layeredPane;
	private JLabel bgImage;
	private JPanel playerBar;
	
	String mapDir;
	
	public GUI3(String mapDirectory, Game game) {
		
		//init
		super("Risiko");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mapDir = mapDirectory;

		
		// create Components
		// create LayeredPane to hold all components
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		layeredPane.setBackground(Color.black);
		
		// set map image as background
		bgImage = new JLabel(new ImageIcon(getClass().getResource("map.png")));
		layeredPane.add(bgImage, 1);
		
		
		//init player bar (top left)
		playerBar = new JPanel();
		
		for(Player p: game.getPlayers()) {
			JLabel pLabel = new JLabel();
			pLabel.setBackground(p.getColor());
			pLabel.setText(p.getName());
			
			playerBar.add(pLabel);
		}
		
		//layeredPane.add(playerBar, 0);
		
		layeredPane.setVisible(true);
		add(layeredPane);
		
		setVisible(true);
	}
}
