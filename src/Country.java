/**
 *
 * A country 
 *
 * @since 04.06.19
 * @author Felix Lehner
 */
class Country {
  /**All countries with a direct border (i.e. counties that can be attacked)*/
  private String[] borders;
  /**The player that is currently in power of this country*/
  private Player owner;
  /**name of the country*/
  private String name;
  /**The amount of troop units*/
  private int unitPower;
}
