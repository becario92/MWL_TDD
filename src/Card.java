
public class Card {

	private boolean uncovered;
	private Suit suit;
	
	public Card(boolean uncovered, Suit suit) {
		this.uncovered = uncovered;
		this.suit = suit;
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
