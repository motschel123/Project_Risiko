package Risiko.graphics;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.*;

public class GUI {

	private JFrame frame;
	
	private JMenuBar menuBar_1;
	private JMenu jmGame;
	private JMenuItem jmItemExit;
	
	private JLayeredPane layeredPane;
	private JLabel bgLabel;
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
		
		// init the layered pane to hold multiple other components ordered
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		// init the background
		bgLabel = new JLabel();
		bgLabel = new JLabel(new ImageIcon(getClass().getResource("map.png")));
		layeredPane.setLayout(new BorderLayout(0, 0));
		layeredPane.add(bgLabel);
		
		
		panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
	}

	public int getFrameExtendedState() {
		return frame.getExtendedState();
	}
	public void setFrameExtendedState(int extendedState) {
		frame.setExtendedState(extendedState);
	}
}
