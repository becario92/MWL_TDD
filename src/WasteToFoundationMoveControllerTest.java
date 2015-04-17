import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class WasteToFoundationMoveControllerTest {
	
	private WasteToFoundationMoveController wasteToFoundationMoveController;
	
	@Before
	public void before() {
		wasteToFoundationMoveController = new WasteToFoundationMoveController();
	}
	
	@Test
	public void moveTest() {
		int sizeWaste = wasteToFoundationMoveController.getSizeWaste();
		HashMap<Suit, Integer> sizeFoundationsStackBefore = wasteToFoundationMoveController.getSizeFoundationsStack();
		
		Card topCardFromWaste = wasteToFoundationMoveController.getTopCardFromWaste();
		assertTrue(topCardFromWaste.isUncovered());
		
		Card movedCard = wasteToFoundationMoveController.move();
		
		assertEquals(sizeWaste - 1, wasteToFoundationMoveController.getSizeWaste());
		assertEquals(topCardFromWaste, movedCard);
		
		HashMap<Suit, Integer> sizeFoundationsStackAfter = wasteToFoundationMoveController.getSizeFoundationsStack();
		for(Suit suit : Suit.values()) {
			if(suit.equals(movedCard.getSuit())) {
				assertEquals(sizeFoundationsStackBefore.get(suit).intValue() + 1, sizeFoundationsStackAfter.get(suit).intValue());
			} else {
				assertEquals(sizeFoundationsStackBefore.get(suit).intValue(), sizeFoundationsStackAfter.get(suit).intValue());
			}
		}
		
		assertEquals(movedCard, wasteToFoundationMoveController.getFoundationsStack().get(movedCard.getSuit()).peek());
	}

}
