import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
		int sizeWaste = wasteToFoundationMoveController.getSizeWaste();
		HashMap<Suit, Integer> sizeFoundations = wasteToFoundationMoveController.sizeFoundations();
		
		Card topCardFromWaste = wasteToFoundationMoveController.getTopCardFromWaste();
		assertTrue(topCardFromWaste.isUncovered());
		
		Card movedCard = wasteToFoundationMoveController.move();
		
		assertEquals(sizeWaste - 1, wasteToFoundationMoveController.getSizeWaste());
		assertEquals(topCardFromWaste, movedCard);
	}

}
