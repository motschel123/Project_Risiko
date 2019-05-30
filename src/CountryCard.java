import java.awt.Image;

/**
  * These cards are representing a country each.
  * 
  *
  * @author Felix Lehner
  */
class CountryCard extends Card {
  public CountryCard (int stars, Game.Area area, Image icon) {
    this.Stars = stars;
    this.area = area;
    this.icon = icon;
  }
}
