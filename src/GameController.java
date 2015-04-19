import java.util.HashMap;
import java.util.Stack;


public class GameController {

	private static GameController GAMECONTROLLER = new GameController();
	
	private Stack<Card> deckStack;
	private Stack<Card> wasteStack;
	private HashMap<Suit, Stack<Card>> foundationsStack;
	
	private GameController() {
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
	
	public static GameController getGameController() {
		return GAMECONTROLLER;
	}

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
