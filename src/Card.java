
public class Card {

	private boolean uncovered;
	private Suit suit;
	private int value;
	
	public Card(boolean uncovered, Suit suit, int value) {
		this.uncovered = uncovered;
		this.suit = suit;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
