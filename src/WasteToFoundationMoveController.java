import java.util.HashMap;
import java.util.Stack;

public class WasteToFoundationMoveController extends MoveController {
	
	WasteToFoundationMoveController() {
		super();
	}

	public HashMap<Suit, Integer> getSizeFoundationsStack() {
		HashMap<Suit, Integer> sizeFoundationsStack = new HashMap<Suit, Integer>();
		for(Suit suit : Suit.values())
			sizeFoundationsStack.put(suit, getFoundationsStack().get(suit).size());
		return sizeFoundationsStack;
	}

	@Override
	public boolean canMove(Stack<Card> from, Stack<Card> to) {
		if(from.peek().getValue() == to.peek().getValue() + 1)
			return true;
		else
			return false;
	}
	
	protected Card move(Stack<Card> from, HashMap<Suit, Stack<Card>> to) {
		if(!from.isEmpty())
			return move(from, to.get(from.peek().getSuit()));
		return null;
	}

}
