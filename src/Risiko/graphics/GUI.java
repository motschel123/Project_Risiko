package Risiko.graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Risiko.Game;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class GUI {

	private JFrame frame;
	
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
		frame = new JFrame();
		//frame.setUndecorated(true);  // fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel bgLabel = new JLabel();
		bgLabel = new JLabel(new ImageIcon(getClass().getResource("map.png")));
		layeredPane.setLayout(new BorderLayout(0, 0));
		layeredPane.add(bgLabel);
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
	}

	public int getFrameExtendedState() {
		return frame.getExtendedState();
	}
	public void setFrameExtendedState(int extendedState) {
		frame.setExtendedState(extendedState);
	}
}
