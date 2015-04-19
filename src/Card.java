
public class Card {

	private boolean uncovered;
	private Suit suit;
	private int value;
	private int color;
	
	public Card(boolean uncovered, Suit suit, int value) {
		this.uncovered = uncovered;
		this.suit = suit;
		this.value = value;
		if(suit.equals(Suit.SPADES) || suit.equals(Suit.CLUBS))
			this.color = 0; //negro
		else
			this.color = 1; //rojo
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

	public Card uncover() {
		this.setUncovered(true);
		return this;
	}

	public int getColor() {
		return color;
	}

}
