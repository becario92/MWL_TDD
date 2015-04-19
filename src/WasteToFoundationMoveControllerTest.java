import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

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
		int sizeWaste = wasteToFoundationMoveController.getWasteStack().size();
		HashMap<Suit, Integer> sizeFoundationsStackBefore = wasteToFoundationMoveController.getSizeFoundationsStack();
		
		Card topCardFromWaste = wasteToFoundationMoveController.getWasteStack().peek();
		assertTrue(topCardFromWaste.isUncovered());
		Card movedCard = wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack());
		Card topCardFromFoundationOfTopCardFromWasteSuit = wasteToFoundationMoveController.getFoundationsStack().get(topCardFromWaste.getSuit()).peek();
		assertTrue(topCardFromFoundationOfTopCardFromWasteSuit.isUncovered());
		
		assertEquals(sizeWaste - 1, wasteToFoundationMoveController.getWasteStack().size());
		HashMap<Suit, Integer> sizeFoundationsStackAfter = wasteToFoundationMoveController.getSizeFoundationsStack();
		for(Suit suit : Suit.values()) {
			if(suit.equals(movedCard.getSuit())) {
				assertEquals(sizeFoundationsStackBefore.get(suit).intValue() + 1, sizeFoundationsStackAfter.get(suit).intValue());
			} else {
				assertEquals(sizeFoundationsStackBefore.get(suit).intValue(), sizeFoundationsStackAfter.get(suit).intValue());
			}
		}
		
		assertEquals(topCardFromWaste, movedCard);
		assertEquals(movedCard, topCardFromFoundationOfTopCardFromWasteSuit);
		
		assertNull(wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack()));
	}

}
