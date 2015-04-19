import java.util.Stack;


public class WasteToTableausMoveController extends MoveController {

	@Override
	protected boolean canMove(Stack<Card> from, Stack<Card> to) {
		if(from.peek().getValue() == to.peek().getValue() - 1)
			return true;
		else
			return false;
	}

}
