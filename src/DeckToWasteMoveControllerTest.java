import java.util.ArrayList;

import org.junit.Before;

public class DeckToWasteMoveControllerTest {
	
	private DeckToWasteMoveController deckToWasteMoveController;
	
	private int sizeWaste;
	private ArrayList<Integer> sizeFoundations;
	private int sizeDeck;
	
	@Before
	public void before() {
		deckToWasteMoveController = new DeckToWasteMoveController();
		sizeWaste = deckToWasteMoveController.sizeWaste();
		sizeFoundations = deckToWasteMoveController.sizeFoundations();
		sizeDeck = deckToWasteMoveController.sizeDeck();
	}

}
