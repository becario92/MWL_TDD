import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class WasteToFoundationMoveController {

	private int sizeWaste;
	private Stack<Card> wasteStack;
	private HashMap<Suit, Stack<Card>> foundationsStack;
	
	WasteToFoundationMoveController() {
		wasteStack = new Stack<Card>();
		wasteStack.push(new Card(true, Suit.SPADES));
		
		foundationsStack = new HashMap<Suit, Stack<Card>>();
		foundationsStack.put(Suit.SPADES, new Stack<Card>());
		foundationsStack.put(Suit.CLUBS, new Stack<Card>());
		foundationsStack.put(Suit.DIAMONDS, new Stack<Card>());
		foundationsStack.put(Suit.HEARTS, new Stack<Card>());
	}
	
	public void setSizeWaste(int sizeWaste) {
		this.sizeWaste = sizeWaste;
	}
	
	public int getSizeWaste() {
		return sizeWaste;
	}

	protected HashMap<Suit, Stack<Card>> getFoundationsStack() {
		return foundationsStack;
	}

	protected void setFoundationsStack(HashMap<Suit, Stack<Card>> foundationsStack) {
		this.foundationsStack = foundationsStack;
	}

	public Card getTopCardFromWaste() {
		return wasteStack.peek();
	}

	public Card move() {
		sizeWaste--;
		Suit suit = wasteStack.peek().getSuit();
		foundationsStack.get(suit).push(wasteStack.pop());
		return foundationsStack.get(suit).peek();
	}

	public HashMap<Suit, Integer> getSizeFoundationsStack() {
		HashMap<Suit, Integer> sizeFoundationsStack = new HashMap<Suit, Integer>();
		for(Suit suit : Suit.values())
			sizeFoundationsStack.put(suit, foundationsStack.get(suit).size());
		return sizeFoundationsStack;
	}

}
