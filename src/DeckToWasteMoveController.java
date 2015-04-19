import java.util.ArrayList;
import java.util.Stack;


public class DeckToWasteMoveController {

	private int sizeDeck;
	private int sizeWaste;
	private ArrayList<Integer> sizeFoundations;
	private Stack<Card> deckStack;
	private Stack<Card> wasteStack;
	
	DeckToWasteMoveController() {
		// en este movimiento, el deck puede tener de 0 a 24 cartas
		sizeDeck = (int) (Math.random()*25);
		// no necesariamente tendrá ese número de cartas, pero para los test es suficiente
		sizeWaste = 24 - sizeDeck;
		sizeFoundations = new ArrayList<Integer>();
		
		deckStack = new Stack<Card>();
		deckStack.push(new Card(false, Suit.SPADES, 1));
		wasteStack = new Stack<Card>();
	}

	public Card move() {
		if(deckStack.isEmpty())
			return null;
		sizeDeck--;
		sizeWaste++;
		wasteStack.push(deckStack.pop());
		return wasteStack.peek();
	}

	public int getSizeDeck() {
		return sizeDeck;
	}

	public void setSizeDeck(int sizeDeck) {
		this.sizeDeck = sizeDeck;
	}

	public int getSizeWaste() {
		return sizeWaste;
	}

	public void setSizeWaste(int sizeWaste) {
		this.sizeWaste = sizeWaste;
	}

	public ArrayList<Integer> getSizeFoundations() {
		return sizeFoundations;
	}

	public void setSizeFoundations(ArrayList<Integer> sizeFoundations) {
		this.sizeFoundations = sizeFoundations;
	}

	public Card getTopCardFromDeck() {
		return deckStack.peek();
	}

	public Stack<Card> getWasteStack() {
		return deckStack;
	}

	public void setWasteStack(Stack<Card> deckStack) {
		this.deckStack = deckStack;
	}

	public Card getTopCardFromWaste() {
		return wasteStack.peek();
	}

}
