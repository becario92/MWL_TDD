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
		deckToWasteMoveController.move();
		assertEquals(sizeDeck - 3, deckToWasteMoveController.getSizeDeck());
		assertEquals(sizeWaste + 3, deckToWasteMoveController.getSizeWaste());
		assertEquals(sizeFoundations, deckToWasteMoveController.getSizeFoundations());
	}

}
