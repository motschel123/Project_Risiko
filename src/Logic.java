
public class Logic {
	
	public static Object[][] shuffle(ArrayList<Player> players, ArrayList<Card> cards){
		players = shufflePlayers(players);
		cards = shufflePlayers(cards);
	}
	
	public static ArrayList<Card> shuffleCards(ArrayList<Card> cards){
		Collection.shuffle(cards);
		return cards;
	}
		
	public static ArrayList<Player> shufflePlayers(ArrayList<Player> players){
		Collection.shuffle(players);
		return players;
	}
	
}
