package Risiko.graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Risiko.Game;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class MainMenu extends javax.swing.JWindow{

	private JFrame frame;
	
	JPanel mainPanel;
	
	JLabel player1Label, player2Label, player3Label, player4Label;
	
	JButton startButton;
	private JTextField textField1, textField2, textField3, textField4;
	private JList<String> list1, list2, list3, list4;
	private ListSelectionListener listener;
	
	private ArrayList<String> colorsToChoseFrom;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainMenu window = new MainMenu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		super();
		
		initColors();
		
		initialize();
		frame.setVisible(true);
	}
	
	private void initColors() {
		colorsToChoseFrom = new ArrayList<String>() {{
			add("Magenta"); 
			add("Blue");
			add("Orange");
			add("Black");
		}};
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        //frame.setUndecorated(true);  // fullscreen
        frame.setBounds(100, 100, 400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Menu");
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_panel);
		
		
		player1Label = new JLabel("Spieler 1");
		player1Label.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSpieler = new GridBagConstraints();
		gbc_lblSpieler.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpieler.gridx = 1;
		gbc_lblSpieler.gridy = 1;
		mainPanel.add(player1Label, gbc_lblSpieler);
		
		
		textField1 = new JTextField();
		textField1.setText("Enter player name");
		GridBagConstraints gbc_txtEnterName = new GridBagConstraints();
		gbc_txtEnterName.anchor = GridBagConstraints.WEST;
		gbc_txtEnterName.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnterName.gridx = 3;
		gbc_txtEnterName.gridy = 1;
		mainPanel.add(textField1, gbc_txtEnterName);
		textField1.setColumns(10);
		textField1.setText("Enter player name");
		textField1.setText("Enter player name");
		textField1.setText("Enter player name");
		
		list1 = new JList<String>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 5;
		gbc_list.gridy = 1;
		list1.setListData(colorsToChoseFrom.toArray(new String[0]));
		mainPanel.add(list1, gbc_list);
		
		player2Label = new JLabel("Spieler 2");
		player2Label.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSpieler_1 = new GridBagConstraints();
		gbc_lblSpieler_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpieler_1.gridx = 1;
		gbc_lblSpieler_1.gridy = 2;
		mainPanel.add(player2Label, gbc_lblSpieler_1);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		mainPanel.add(textField2, gbc_textField);
		
		list2 = new JList<String>();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 5;
		gbc_list_1.gridy = 2;
		list2.setListData(colorsToChoseFrom.toArray(new String[0]));
		mainPanel.add(list2, gbc_list_1);
		
		player3Label = new JLabel("Spieler 3");
		player3Label.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSpieler_2 = new GridBagConstraints();
		gbc_lblSpieler_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpieler_2.gridx = 1;
		gbc_lblSpieler_2.gridy = 3;
		mainPanel.add(player3Label, gbc_lblSpieler_2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		mainPanel.add(textField3, gbc_textField_1);
		
		list3 = new JList<String>();
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.insets = new Insets(0, 0, 5, 5);
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 5;
		gbc_list_2.gridy = 3;
		list3.setListData(colorsToChoseFrom.toArray(new String[0]));
		mainPanel.add(list3, gbc_list_2);
		
		player4Label = new JLabel("Spieler 4");
		player4Label.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSpieler_3 = new GridBagConstraints();
		gbc_lblSpieler_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpieler_3.gridx = 1;
		gbc_lblSpieler_3.gridy = 4;
		mainPanel.add(player4Label, gbc_lblSpieler_3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 4;
		mainPanel.add(textField4, gbc_textField_2);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		
		startButton = new JButton("Spiel Starten");
		GridBagConstraints gbc_btnSpielStarten = new GridBagConstraints();
		gbc_btnSpielStarten.anchor = GridBagConstraints.WEST;
		gbc_btnSpielStarten.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpielStarten.gridx = 3;
		gbc_btnSpielStarten.gridy = 6;
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] names = checkGetNames();
				Color[] colors = checkGetColors();
				
				if(names == null || colors == null) {
					startButton.setBackground(new Color(255, 0, 10));
				} else {
					frame.setVisible(false);
					new Game(names, colors, "StandardMap");
				}
			}
		});
		
		list4 = new JList<String>();
		GridBagConstraints gbc_list_3 = new GridBagConstraints();
		gbc_list_3.insets = new Insets(0, 0, 5, 5);
		gbc_list_3.fill = GridBagConstraints.BOTH;
		gbc_list_3.gridx = 5;
		gbc_list_3.gridy = 4;
		list4.setListData(colorsToChoseFrom.toArray(new String[0]));
		mainPanel.add(list4, gbc_list_3);
		mainPanel.add(startButton, gbc_btnSpielStarten);
		
		System.out.println(list1.getSelectedValue());
	}
	
	private String[] checkGetNames() {
		String[] names = new String[4];
		
		names[0] = textField1.getText().replaceAll(" ", "");
		names[1] = textField2.getText().replaceAll(" ", "");
		names[2] = textField3.getText().replaceAll(" ", "");
		names[3] = textField4.getText().replaceAll(" ", "");
		
		for(String name: names) {
			if(name == null || name == "") {
				return null;
			}
		}
		return names;
	}
	
	private Color[] checkGetColors() {
		Color[] colors = new Color[4];
		int black = 1, magenta = 1, blue = 1, orange = 1;
		
		colors[0] = getColorByString(list1.getSelectedValue());
		colors[1] = getColorByString(list2.getSelectedValue());
		colors[2] = getColorByString(list3.getSelectedValue());
		colors[3] = getColorByString(list4.getSelectedValue());
		
		for(int i=0; i<colors.length; i++) {
			if(colors[i] == null) {
				return null;
			}
			
			for(int j=0; j<colors.length; j++) {
				if(i!=j) {
					if(colors[i] == colors[j]) {
						return null;
					}
				}
			}
		}
		
		return colors;
	}
	
	private Color getColorByString(String c) {
		Color color;
		
		if(c == null) {
			return null;
		}
		
		switch (c) {
		case "Magenta": return Color.MAGENTA;
		case "Blue": return Color.BLUE;
		case "Black": return Color.BLACK;
		case "Orange": return Color.ORANGE;
		default: return Color.WHITE;
		}
	}
}
