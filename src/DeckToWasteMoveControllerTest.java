import static org.junit.Assert.*;

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
		int sizeDeck = deckToWasteMoveController.getDeckStack().size();
		int sizeWaste = deckToWasteMoveController.getWasteStack().size();
		
		Card topCardFromDeck = deckToWasteMoveController.getDeckStack().peek();
		assertFalse(topCardFromDeck.isUncovered());
		Card movedCard = deckToWasteMoveController.move(deckToWasteMoveController.getDeckStack(), deckToWasteMoveController.getWasteStack());
		Card topCardFromWaste = deckToWasteMoveController.getWasteStack().peek();
		assertTrue(topCardFromWaste.isUncovered());
		
		assertEquals(sizeDeck - 1, deckToWasteMoveController.getDeckStack().size());
		assertEquals(sizeWaste + 1, deckToWasteMoveController.getWasteStack().size());
		
		assertEquals(topCardFromDeck, movedCard);
		assertEquals(movedCard, topCardFromWaste);
		
		assertNull(deckToWasteMoveController.move(deckToWasteMoveController.getDeckStack(), deckToWasteMoveController.getWasteStack()));
	}

}
