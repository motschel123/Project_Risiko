
public class Logic {
	
	public statc Object[] shuffle(ArrayList<Player> players, ArrayList<Card> cards){
		players = shufflePlayers(players);
		cards = shufflePlayers(cards);
		
		return {players, cards};
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
