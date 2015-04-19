import java.util.HashMap;
import java.util.Stack;

public class WasteToFoundationMoveController {

	private int sizeWaste;
	private Stack<Card> wasteStack;
	private HashMap<Suit, Stack<Card>> foundationsStack;
	
	WasteToFoundationMoveController() {
		wasteStack = new Stack<Card>();
		wasteStack.push(new Card(true, Suit.SPADES, 1));
		
		foundationsStack = new HashMap<Suit, Stack<Card>>();
		for(Suit suit : Suit.values()) {
			Stack<Card> foundationStack = new Stack<Card>();
			foundationStack.push(new Card(true, suit, 0));
			foundationsStack.put(suit, foundationStack);
		}
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
		if(wasteStack.isEmpty())
			return null;
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

	protected Stack<Card> getWasteStack() {
		return wasteStack;
	}

	protected void setWasteStack(Stack<Card> wasteStack) {
		this.wasteStack = wasteStack;
	}

	public boolean canMove() {
		if(wasteStack.peek().getValue() == foundationsStack.get(wasteStack.peek().getSuit()).peek().getValue() + 1)
			return true;
		else
			return false;
	}

}
