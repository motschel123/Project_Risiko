package Risiko.graphics;

import Risiko.Country;
import Risiko.loading.CountryLocationLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GUI extends javax.swing.JWindow implements ActionListener {

    private int playerCount;

    private JFrame frame;

    private JMenuBar menuBar_1;
    private JMenu jmGame;
    private JMenuItem jmItemExit;

    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel playerPanel;
    private JPanel countryPanel;
    
    private Controller controller;

    public Map<String, JLabel> countryLabels;

    /**
     * Create the application.
     */
    public GUI(ActionListener al) {
        countryLabels = new HashMap<String, JLabel>();
        controller = al;
        
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // init the basic frame holding everything
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        //frame.setUndecorated(true);  // fullscreen
        frame.setBounds(100, 100, 1200, 800);
        frame.setResizable(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Risiko");
        frame.addActionListener(this);


        // init the menu bar on the top to display control options
        menuBar_1 = new JMenuBar();
        frame.setJMenuBar(menuBar_1);
        jmGame = new JMenu("Game");
        menuBar_1.add(jmGame);
        jmItemExit = new JMenuItem("Exit");
        //jmItemExit.addActionListener(ev -> System.exit(0));

        jmGame.add(jmItemExit);
        frame.getContentPane().setLayout(null);

        // init the layered pane to hold multiple other components ordered
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1194, 750);
        layeredPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        layeredPane.setAutoscrolls(true);
        frame.getContentPane().add(layeredPane);

        // init that background label to contain the map image
        backgroundLabel = new JLabel();
        backgroundLabel.setAlignmentX(10.0f);
        backgroundLabel.setAutoscrolls(true);
        backgroundLabel.setBounds(10, 11, 800, 728);
        ImageIcon bgImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Assets/StandardMap/map.png")));
        bgImageIcon.getImage().getScaledInstance(-1, (int) backgroundLabel.getBounds().getHeight(), java.awt.Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(bgImageIcon);
        layeredPane.add(backgroundLabel);
        layeredPane.setLayer(backgroundLabel, 0);


        // init the background

        playerPanel = new JPanel();
        playerPanel.setBackground(Color.LIGHT_GRAY);
        playerPanel.setBounds(820, 11, 364, 464);
        playerPanel.setLayout(new GridLayout(0, 1, 6, 5));
        layeredPane.add(playerPanel);
        layeredPane.setLayer(playerPanel, 1);

        // init the country panel to hold all country labels
        countryPanel = new JPanel();
        countryPanel.setOpaque(false);
        countryPanel.setBounds(10, 11, 800, 728);
        countryPanel.setLayout(null);
        layeredPane.setLayer(countryPanel, 1);
        layeredPane.add(countryPanel);

    }
    
    public void playerAtTurn(String playerName) {
    	
    }

    public PlayerLabel addPlayer(String name, Color color) {
        if (playerPanel.getComponents().length >= 6) {
            return null;
        }
        PlayerLabel playerLabel = new PlayerLabel(name, color);

        playerPanel.add(playerLabel, -1);

        return playerLabel;
    }

    public void addCountryLabels(String path) {
        Map<String, Dimension> locations = CountryLocationLoader.loadFrom(path);

        for(String countryName: locations.keySet()){
        	Dimension location = locations.get(countryName);
        	
            System.out.println("size " + countryName + ": " + location.width + "|" + location.height);
            countryLabels.put(countryName, addCountryLabel(location));
            System.out.println("in countryLabels: " + countryLabels.get(countryName).getLocation().getX() + "|" + countryLabels.get(countryName).getLocation().getY());
            System.out.println("on screen: " + countryLabels.get(countryName).getLocationOnScreen().getX() + "|" + countryLabels.get(countryName).getLocationOnScreen().getY() + "\n");
        };
        
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private CountryLabel addCountryLabel(Dimension pos) {
        CountryLabel cLabel = new CountryLabel(pos);

        countryPanel.add(cLabel);

        return cLabel;
    }
    
    public void updateCountryLabels(Map<String, Country> countries) {
    	
    	
    	for(String cName: countryLabels.keySet()) {
    		JLabel cLabel = countryLabels.get(cName);
    		
    		Country country = countries.get(cName);
            
            cLabel.setText(country.getUnitPower() + "");
            
            if(country.getOwner() != null) {
            	cLabel.setBackground(country.getOwner().getColor());
            }    		
    	}
    	
        /*countryLabels.forEach((String cName, JLabel cLabel) -> {
            Country country = countries.get(cName);
            
            cLabel.setText(country.getUnitPower() + "");
            cLabel.setBackground(country.getOwner().getColor());
        });*/
    }
    
    /** Forwards events to controller. */
    public void getActionCommand(ActionEvent ae) {
        controller.getActionCommand(ae);
    } 

    public int getFrameExtendedState() {
        return frame.getExtendedState();
    }

    public void setFrameExtendedState(int extendedState) {
        frame.setExtendedState(extendedState);
    }
}
