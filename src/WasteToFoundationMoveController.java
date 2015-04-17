import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class WasteToFoundationMoveController {

	private int sizeWaste;
	private HashMap<Suit, Integer> sizeFoundations;
	private Stack<Card> wasteStack;
	
	WasteToFoundationMoveController() {
		wasteStack = new Stack<Card>();
		wasteStack.push(new Card(true));
	}
	
	public void setSizeWaste(int sizeWaste) {
		this.sizeWaste = sizeWaste;
	}
	
	public int getSizeWaste() {
		return sizeWaste;
	}

	public HashMap<Suit, Integer> sizeFoundations() {
		// TODO Auto-generated method stub
		return null;
	}

	public Card getTopCardFromWaste() {
		return wasteStack.peek();
	}

}
