package Risiko.graphics;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class GUI {
	
	private int playerCount;

	private JFrame frame;
	
	private JMenuBar menuBar_1;
	private JMenu jmGame;
	private JMenuItem jmItemExit;
	
	private JLayeredPane layeredPane;
	private JLabel bgLabel;
	private JPanel playerPanel;
	private JPanel panel;
	
	/**
	 * Create the application.
	 */
	public GUI() {		
		initialize();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// init the basic frame holding everything
		frame = new JFrame();
		frame.setUndecorated(true);  // fullscreen
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// init the menu bar on the top to display control options
		menuBar_1 = new JMenuBar();
		frame.setJMenuBar(menuBar_1);
		jmGame = new JMenu("Game");
		menuBar_1.add(jmGame);
		jmItemExit = new JMenuItem("Exit");
		jmItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		jmGame.add(jmItemExit);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// init the layered pane to hold multiple other components ordered
		layeredPane = new JLayeredPane();
		layeredPane.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(layeredPane);
		
		
		// init the background
		ImageIcon bgImageIcon = new ImageIcon(getClass().getResource("map.png"));
		bgImageIcon = new ImageIcon(bgImageIcon.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH)); // resize
		bgLabel = new JLabel(bgImageIcon);
		layeredPane.add(bgLabel, BorderLayout.EAST);
		layeredPane.setLayer(bgLabel, 0);
		
		
		playerPanel = new JPanel();
		layeredPane.add(playerPanel, BorderLayout.NORTH);
		layeredPane.setLayer(playerPanel, 1);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
	}
	
	public boolean addPlayer(String name, Color color) {
		if(playerPanel.getComponents().length >= 6) {
			return false;
		}
		JLabel playerLabel = new JLabel();
		playerLabel.setHorizontalTextPosition(JLabel.LEFT);
		playerLabel.setBackground(color);
		playerLabel.setText(name);
		playerLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		playerLabel.setOpaque(true);
		
		playerPanel.add(playerLabel, -1);
		
		return true;
	}

	public int getFrameExtendedState() {
		return frame.getExtendedState();
	}
	public void setFrameExtendedState(int extendedState) {
		frame.setExtendedState(extendedState);
	}
}
