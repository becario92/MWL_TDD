import java.util.HashMap;
import java.util.Stack;


public class GameController {

	private static GameController GAMECONTROLLER;
	
	private Stack<Card> deckStack;
	private Stack<Card> wasteStack;
	private HashMap<Suit, Stack<Card>> foundationsStack;
	
	private GameController() {
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
