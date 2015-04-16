import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DeckToWasteMoveControllerTest {
	
	private DeckToWasteMoveController deckToWasteMoveController;
	
	@Before
	public void before() {
		deckToWasteMoveController = new DeckToWasteMoveController();
	}
	
	@Test
	public void moveTest() {
		int sizeDeck = deckToWasteMoveController.getSizeDeck();
		int sizeWaste = deckToWasteMoveController.getSizeWaste();
		ArrayList<Integer> sizeFoundations = deckToWasteMoveController.getSizeFoundations();
		Card topCardFromDeck = deckToWasteMoveController.getTopCardFromDeck();
		
		Card movedCard = deckToWasteMoveController.move();
		
		Card topCardFromWaste = deckToWasteMoveController.getTopCardFromWaste();
		
		assertEquals(sizeDeck - 1, deckToWasteMoveController.getSizeDeck());
		assertEquals(sizeWaste + 1, deckToWasteMoveController.getSizeWaste());
		assertEquals(sizeFoundations, deckToWasteMoveController.getSizeFoundations());
		
		assertEquals(topCardFromDeck, movedCard);
		assertEquals(movedCard, topCardFromWaste);
	}

}
