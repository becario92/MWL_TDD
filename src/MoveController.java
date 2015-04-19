import java.util.HashMap;
import java.util.Stack;


public abstract class MoveController {
	
	private Stack<Card> deckStack;
	private Stack<Card> wasteStack;
	private HashMap<Suit, Stack<Card>> foundationsStack;
	
	protected MoveController() {
		deckStack = new Stack<Card>();
		deckStack.push(new Card(false, Suit.SPADES, 1));
		
		wasteStack = new Stack<Card>();
		wasteStack.push(new Card(true, Suit.SPADES, 1));
		
		foundationsStack = new HashMap<Suit, Stack<Card>>();
		for(Suit suit : Suit.values()) {
			Stack<Card> foundationStack = new Stack<Card>();
			foundationStack.push(new Card(true, suit, 0));
			foundationsStack.put(suit, foundationStack);
		}
	}

	public Card move(Stack<Card> from, Stack<Card> to) {
		if(canMove(from, to)) {
			to.push(from.pop());
			return to.peek();
		}
		return null;
	}

	protected abstract boolean canMove(Stack<Card> from, Stack<Card> to);
	
	protected Stack<Card> getDeckStack() {
		return deckStack;
	}

	protected Stack<Card> getWasteStack() {
		return wasteStack;
	}

	protected HashMap<Suit, Stack<Card>> getFoundationsStack() {
		return foundationsStack;
	}
	
}
