package Risiko.graphics;

import Risiko.Country;
import Risiko.Game;
import Risiko.Player;
import Risiko.loading.CountryLocationLoader;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GUI extends javax.swing.JWindow {

	private int playerCount;

	private JFrame frame;

	private JLayeredPane layeredPane;
	
	private JLabel backgroundLabel;
	private JLabel phasenLabel;
	
	private JPanel playerPanel;
	private JPanel countryPanel;
	private JPanel controllPanel;
	private JPanel phasenPanel;
	
	private JButton unit1Button, unit2Button, unit3Button;
	
	private Player playerTurn;
	
	private int unitPlaced = 0;
	private boolean unitPlacable = false;

	public Map<String, CountryLabel> countryLabels;
	public Map<String, PlayerLabel> playerLabels;
	private Map<String, JButton> cardButtons;

	private JButton cardButton;
	
	public boolean selectingAC = false;
	
	private Game game;
	
	private int unitsPlaced = 0;
	private JPanel unitPanel;
	private JPanel panel;
	private JButton endAttackPhaseButton;
	/**
	 * Create the application.
	 */
	public GUI(Game game) {
		this.game = game;
		countryLabels = new HashMap<String, CountryLabel>();
		playerLabels = new HashMap<String, PlayerLabel>();
		cardButtons = new HashMap<String, JButton>();
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// init the basic frame holding everything
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		// frame.setUndecorated(true); // fullscreen
		frame.setBounds(100, 100, 1410, 910);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Risiko");
		frame.getContentPane().setLayout(null);

		// init the layered pane to hold multiple other components ordered
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1400, 871);
		layeredPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		layeredPane.setAutoscrolls(true);
		frame.getContentPane().add(layeredPane);

		// init that background label to contain the map image
		backgroundLabel = new JLabel();
		backgroundLabel.setAlignmentX(10.0f);
		backgroundLabel.setAutoscrolls(true);
		backgroundLabel.setBounds(10, 11, 800, 728);
		ImageIcon bgImageIcon = new ImageIcon(
				Objects.requireNonNull(getClass().getClassLoader().getResource("Assets/StandardMap/map.png")));
		bgImageIcon.getImage().getScaledInstance(-1, (int) backgroundLabel.getBounds().getHeight(), java.awt.Image.SCALE_SMOOTH);
		backgroundLabel.setIcon(bgImageIcon);
		layeredPane.add(backgroundLabel);
		layeredPane.setLayer(backgroundLabel, 0);

		// init the background

		playerPanel = new JPanel();
		playerPanel.setBackground(Color.DARK_GRAY);
		playerPanel.setBounds(820, 11, 570, 464);
		playerPanel.setLayout(new GridLayout(0, 1, 6, 15));
		layeredPane.add(playerPanel);
		layeredPane.setLayer(playerPanel, 1);

		// init the country panel to hold all country labels
		countryPanel = new JPanel();
		countryPanel.setOpaque(false);
		countryPanel.setBounds(10, 11, 800, 728);
		countryPanel.setLayout(null);
		layeredPane.setLayer(countryPanel, 1);
		layeredPane.add(countryPanel);

		controllPanel = new JPanel();
		controllPanel.setOpaque(false);
		controllPanel.setBounds(820, 486, 570, 374);
		layeredPane.add(controllPanel);
		controllPanel.setLayout(null);
		
		unitPanel = new JPanel();
		unitPanel.setOpaque(false);
		unitPanel.setBounds(0, 0, 248, 86);
		controllPanel.add(unitPanel);
		GridBagLayout gbl_unitPanel = new GridBagLayout();
		gbl_unitPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_unitPanel.rowHeights = new int[]{0, 0, 0};
		gbl_unitPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_unitPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		unitPanel.setLayout(gbl_unitPanel);
		
		unit1Button = new JButton("Unit 1");
		GridBagConstraints gbc_unit1Button = new GridBagConstraints();
		gbc_unit1Button.fill = GridBagConstraints.HORIZONTAL;
		gbc_unit1Button.insets = new Insets(0, 0, 5, 5);
		gbc_unit1Button.gridx = 0;
		gbc_unit1Button.gridy = 0;
		unitPanel.add(unit1Button, gbc_unit1Button);
		unit1Button.setForeground(Color.WHITE);
		unit1Button.setVisible(false);
		unit1Button.setEnabled(false);
		
		unit2Button = new JButton("Unit 2");
		GridBagConstraints gbc_unit2Button = new GridBagConstraints();
		gbc_unit2Button.fill = GridBagConstraints.HORIZONTAL;
		gbc_unit2Button.insets = new Insets(0, 0, 5, 5);
		gbc_unit2Button.gridx = 1;
		gbc_unit2Button.gridy = 0;
		unitPanel.add(unit2Button, gbc_unit2Button);
		unit2Button.setForeground(Color.WHITE);
		unit2Button.setVisible(false);
		unit2Button.setEnabled(false);
		
		unit3Button = new JButton("Unit 3");
		GridBagConstraints gbc_unit3Button = new GridBagConstraints();
		gbc_unit3Button.fill = GridBagConstraints.HORIZONTAL;
		gbc_unit3Button.insets = new Insets(0, 0, 5, 0);
		gbc_unit3Button.gridx = 2;
		gbc_unit3Button.gridy = 0;
		unitPanel.add(unit3Button, gbc_unit3Button);
		unit3Button.setForeground(Color.WHITE);
		unit3Button.setVisible(false);
		unit3Button.setEnabled(false);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(244, 128, 326, 246);
		controllPanel.add(panel);
		panel.setLayout(null);
		
		endAttackPhaseButton = new JButton("End Attack Phase");
		endAttackPhaseButton.setEnabled(false);
		endAttackPhaseButton.setVisible(false);
		endAttackPhaseButton.setBounds(199, 212, 117, 23);
		endAttackPhaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.movePhase();
			}
			
		});
		panel.add(endAttackPhaseButton);
		
		phasenPanel = new JPanel();
		phasenPanel.setBackground(Color.CYAN);
		phasenPanel.setBounds(10, 750, 800, 110);
		layeredPane.add(phasenPanel);
		phasenPanel.setLayout(null);
		
		phasenLabel = new JLabel("Phase");
		phasenLabel.setBounds(10, 11, 404, 117);
		phasenPanel.add(phasenLabel);

	}
	
	public void setPlacingPhase() {
		
	}
	
	public void setAttackingPhase() {
		endAttackPhaseButton.setVisible(true);
		endAttackPhaseButton.setEnabled(true);
	}

	public void setTurn(Player player) {
		playerTurn = player;
		unit1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitPlaced = 1;
				unitPlacable = true;
			}
		});
		unit2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitPlaced = 2;
				unitPlacable = true;
			}
		});
		unit3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitPlaced = 3;
				unitPlacable = true;
			}
		});
		unit1Button.setEnabled(true); unit1Button.setVisible(true); unit1Button.setBackground(player.getColor());
		unit2Button.setEnabled(true); unit2Button.setVisible(true); unit2Button.setBackground(player.getColor());
		unit3Button.setEnabled(true); unit3Button.setVisible(true); unit3Button.setBackground(player.getColor());
		
		playerLabels.forEach((String name, PlayerLabel pLabel) -> {
			if(name != player.getName()) {
				Border border = BorderFactory.createEmptyBorder();
				pLabel.setBorder(border);
			} else {
				Border border = BorderFactory.createLineBorder(new Color(255, 0, 0), 4);
				pLabel.setBorder(border);
			}
		});
		
		
		
		//loadDisplayCards("Assets");
	}
	
	public void checkNextStage() {
		if(unitsPlaced == 3) {
			game.attackPhase();
		}
	}
	
	public void setPhase(String phase) {
		phasenLabel.setText(phase);
	}
	
	public void loadDisplayCards(String path) {
		
		cardButton = new JButton();
		String name = "test";
		GridBagConstraints gbc_cardLabel = new GridBagConstraints();
		gbc_cardLabel.insets = new Insets(0, 0, 0, 5);
		gbc_cardLabel.gridx = 0;
		gbc_cardLabel.gridy = 1;
		controllPanel.add(cardButton, gbc_cardLabel);
		cardButtons.put(name ,cardButton);
	}

	public PlayerLabel addPlayer(String name, Color color) {
		if (playerPanel.getComponents().length >= 6) {
			return null;
		}
		PlayerLabel playerLabel = new PlayerLabel(name, color);

		playerPanel.add(playerLabel, -1);
		
		playerLabels.put(name, playerLabel);

		return playerLabel;
	}

	public void addCountryLabels(String path) {
		Map<String, Dimension> locations = CountryLocationLoader.loadFrom(path);

		for (String countryName : locations.keySet()) {
			Dimension location = locations.get(countryName);

			System.out.println("size " + countryName + ": " + location.width + "|" + location.height);
			countryLabels.put(countryName, addCountryLabel(location, countryName));
			System.out.println("in countryLabels: " + countryLabels.get(countryName).getLocation().getX() + "|"
					+ countryLabels.get(countryName).getLocation().getY());
			System.out.println("on screen: " + countryLabels.get(countryName).getLocationOnScreen().getX() + "|"
					+ countryLabels.get(countryName).getLocationOnScreen().getY() + "\n");
		};

		layeredPane.revalidate();
		layeredPane.repaint();
	}

	private CountryLabel addCountryLabel(Dimension pos, String countryName) {
		final CountryLabel cLabel = new CountryLabel(pos, game.getCountryByName(countryName));

		cLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switch(game.getPhase()) {
				case 1:
					if(unitPlacable && cLabel.getCountry().getOwner() == playerTurn) {
						Country c = game.getCountryByName(countryName);
						c.setUnitPower(c.getUnitPower()+1);
						updateCountryLabels(game.getCountries());
						switch(unitPlaced) {
						case 1: unit1Button.setEnabled(false); unitPlacable=false; break;
						case 2: unit2Button.setEnabled(false); unitPlacable=false; break;
						case 3: unit3Button.setEnabled(false); unitPlacable=false; break;
						default: unit1Button.setEnabled(false); unitPlacable=false; break;
						}
						unitsPlaced++;
						checkNextStage();
					}
					break;
				case 2: 
					if(selectingAC && cLabel.getCountry().getOwner() == playerTurn && cLabel.getCountry().getUnitPower() > 0) {
						if(game.getAttackingCountry() != null) {
							countryLabels.get(game.getAttackingCountry().getName()).setForeground(playerTurn.getColor());
						}
						game.setAttackingCountry(cLabel.getCountry());
						cLabel.setForeground(new Color(255,0,0));
					} else if(selectingAC && game.getAttackingCountry() != null && cLabel.getCountry().getOwner() != playerTurn) 
						for(String c: game.getAttackingCountry().getBorders()) {
							if(c.replaceAll("/", "_").replaceAll(" ", "").equalsIgnoreCase(cLabel.getCountry().getName().replaceAll("/", "_").replaceAll(" ", ""))) {
								game.attackedCountry = cLabel.getCountry();
								selectingAC = false;
								game.attack();
								selectingAC = true;
						}
					}
					break;
				case 3: 
					break;
				}
			}
		});
		
		countryPanel.add(cLabel);

		return cLabel;
	}

	public void updateCountryLabels(Map<String, Country> countries) {

		for (String cName : countryLabels.keySet()) {
			CountryLabel cLabel = countryLabels.get(cName);

			countries.forEach((String name, Country c) -> {
				System.out.println(name + " | " + c.getName());
			});
			System.out.println(cName);

			Country country = countries.get(cName);

			cLabel.setText(country.getUnitPower() + "");

			if (country.getOwner() != null) {
				cLabel.setForeground(country.getOwner().getColor());
			}
		}

		/*
		 * countryLabels.forEach((String cName, JLabel cLabel) -> { Country country =
		 * countries.get(cName);
		 * 
		 * cLabel.setText(country.getUnitPower() + "");
		 * cLabel.setBackground(country.getOwner().getColor()); });
		 */
	}

	public int getFrameExtendedState() {
		return frame.getExtendedState();
	}

	public void setFrameExtendedState(int extendedState) {
		frame.setExtendedState(extendedState);
	}
}
