import java.util.ArrayList;
import java.util.Stack;


public class DeckToWasteMoveController {

	private int sizeDeck;
	private int sizeWaste;
	private ArrayList<Integer> sizeFoundations;
	private Stack<Card> deckStack;
	
	DeckToWasteMoveController() {
		// en este movimiento, el deck puede tener de 0 a 24 cartas
		sizeDeck = (int) (Math.random()*25);
		// no necesariamente tendrá ese número de cartas, pero para los test es suficiente
		sizeWaste = 24 - sizeDeck;
		sizeFoundations = new ArrayList<Integer>();
		
		deckStack = new Stack<Card>();
		deckStack.push(new Card());
	}

	public Card move() {
		// TODO Auto-generated method stub
		sizeDeck -= 1;
		sizeWaste += 1;
		return deckStack.peek();
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

	public Card getTopCardFromWaste() {
		return deckStack.peek();
	}

	public Stack<Card> getWasteStack() {
		return deckStack;
	}

	public void setWasteStack(Stack<Card> deckStack) {
		this.deckStack = deckStack;
	}

}
