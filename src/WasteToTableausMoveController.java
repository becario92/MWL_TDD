import java.util.ArrayList;
import java.util.Stack;


public class WasteToTableausMoveController extends MoveController {

	WasteToTableausMoveController() {
		super();
	}
	
	@Override
	protected boolean canMove(Stack<Card> from, Stack<Card> to) {
		if(from.peek().getValue() == to.peek().getValue() - 1)
			return true;
		else
			return false;
	}
	
	protected Card move(Stack<Card> from, ArrayList<Stack<Card>> to, int index) {
		if(!from.isEmpty())
			return move(from, to.get(index));
		return null;
	}

}
