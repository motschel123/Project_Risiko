package Risiko;

/**
 * A country
 *
 * @author Felix Lehner
 * @since 04.06.19
 */
public class Country {
    /**
     * All countries with a direct border (i.e. counties that can be attacked)
     */
    final private String[] borders;
    /**
     * The player that is currently in power of this country
     */
    private Player owner;
    /**
     * name of the country
     */
    final private String name;
    /**
     * The amount of troop units
     */
    private int unitPower;

    public Country(String[] borders, Player owner, String name, int unitPower) {
        this.borders = borders;
        this.owner = owner;
        this.name = name;
        this.unitPower = unitPower;
    }

    /**
     * Constructor
     *
     * @author Marcel Schöckel
     * @author Felix Lehner
     */
    public Country(String name, String[] borders) {
        this.name = name;
        this.borders = borders;
        this.unitPower = 0;
        this.owner = null;
    }

    /**
     * Getter&Setter methods
     *
     * @author Felix Lehner
     * @author Marcel Schöckel
     */
    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public int getUnitPower() {
        return unitPower;
    }

    public String[] getBorders() {
        return borders;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setUnitPower(int unitPower) {
        this.unitPower = unitPower;
    }
}
