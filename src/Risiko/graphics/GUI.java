package Risiko.graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

/**
  * @author Felix Lehner
  */
public class GUI extends JFrame{
	private JLabel bgImage;
	private JLabel playerBar;
	
	String mapDir;
	
	public GUI(String mapDirectory) {
		
		//init
		super("Risiko");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mapDir = mapDirectory;

		
		// set the map as background
		bgImage = new JLabel(new ImageIcon(getClass().getResource("map.png")));
		add(bgImage);
		
		//init player bar (top left)
		playerBar = new JLabel();
		
				
		setVisible(true);
	}
}
