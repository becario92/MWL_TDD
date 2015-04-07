import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DeckToWasteMoveControllerTest {
	
	private DeckToWasteMoveController deckToWasteMoveController;
	
	private int sizeDeck;
	private int sizeWaste;
	private ArrayList<Integer> sizeFoundations;
	
	@Before
	public void before() {
		deckToWasteMoveController = new DeckToWasteMoveController();
		sizeDeck = deckToWasteMoveController.getSizeDeck();
		sizeWaste = deckToWasteMoveController.getSizeWaste();
		sizeFoundations = deckToWasteMoveController.getSizeFoundations();
	}
	
	@Test
	public void moveTest() {
		deckToWasteMoveController.move();
		assertEquals(sizeDeck - 3, deckToWasteMoveController.getSizeDeck());
		assertEquals(sizeWaste + 3, deckToWasteMoveController.getSizeWaste());
		assertEquals(sizeFoundations, deckToWasteMoveController.getSizeFoundations());
	}

}
