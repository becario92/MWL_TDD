import java.util.ArrayList;
import java.util.Stack;


public class StartGameController {

	public int sizeWaste() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			sizeFoundations.add(0);
		}
		return sizeFoundations;
	}
	
	public int sizeDeck() {
		return 24;
	}
	
	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> sizeCoveredCardsTableaus = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			sizeCoveredCardsTableaus.add(new Integer(i + 1));
		}
		return sizeCoveredCardsTableaus;
	}
	
	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = new ArrayList<Stack<Card>>();
		for (int i = 0; i < 7; i++) {
			Stack<Card> uncoveredCardsStack = new Stack<Card>();
			uncoveredCardsStack.add(new Card(true));
			uncoveredCardsStackTableaus.add(uncoveredCardsStack);
		}
		return uncoveredCardsStackTableaus;
	}

}
