import java.util.Stack;


public class DeckToWasteMoveController extends MoveController {
	
	DeckToWasteMoveController() {
		super();
	}
	
	@Override
	protected Card move(Stack<Card> from, Stack<Card> to) {
		Card movedCard = super.move(from, to);
		if(movedCard != null)
			to.push(to.pop().uncover());
		return movedCard;
	}

	@Override
	protected boolean canMove(Stack<Card> from, Stack<Card> to) {
		if(from.isEmpty())
			return false;
		return true;
	}
	

}
