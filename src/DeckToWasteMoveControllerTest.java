import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DeckToWasteMoveControllerTest {
	
	private DeckToWasteMoveController deckToWasteMoveController;
	
	//private int sizeWaste;
	//private ArrayList<Integer> sizeFoundations;
	private int sizeDeck;
	
	@Before
	public void before() {
		deckToWasteMoveController = new DeckToWasteMoveController();
		//sizeWaste = deckToWasteMoveController.sizeWaste();
		//sizeFoundations = deckToWasteMoveController.sizeFoundations();
		sizeDeck = deckToWasteMoveController.getSizeDeck();
	}
	
	@Test
	public void moveTest() {
		deckToWasteMoveController.move();
		assertEquals(sizeDeck - 3, deckToWasteMoveController.getSizeDeck());
	}

}
