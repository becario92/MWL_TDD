import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class AllTest {

	private StartGameController startGameController;
	private DeckToWasteMoveController deckToWasteMoveController;
	private WasteToFoundationMoveController wasteToFoundationMoveController;
	private WasteToTableausMoveController wasteToTableausMoveController;

	@Before
	public void before() {
		startGameController = new StartGameController();
		deckToWasteMoveController = new DeckToWasteMoveController();
		wasteToFoundationMoveController = new WasteToFoundationMoveController();
		wasteToTableausMoveController = new WasteToTableausMoveController();
	}

	@Test
	public void startGameControllerTest() {
		assertEquals(0, startGameController.sizeWaste());

		ArrayList<Integer> sizeFoundations = startGameController.sizeFoundations();
		assertEquals(4, sizeFoundations.size());
		for (int sizeFoundation : sizeFoundations) {
			assertEquals(0, sizeFoundation);
		}

		assertEquals(24, startGameController.sizeDeck());

		ArrayList<Integer> sizeTableaus = startGameController.sizeCoveredCardsTableaus();
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = startGameController.uncoveredCardsStackTableaus();
		assertEquals(7, sizeTableaus.size());
		assertEquals(7, uncoveredCardsStackTableaus.size());
		for (int i = 0; i < sizeTableaus.size(); i++) {
			assertEquals(new Integer(i + 1), sizeTableaus.get(i));
		}
		for (Stack<Card> uncoveredCardsStack : uncoveredCardsStackTableaus) {
			assertEquals(1, uncoveredCardsStack.size());
			assertTrue(uncoveredCardsStack.peek().isUncovered()); //cima
		}
	}

	@Test
	public void deckToWasteMoveControllerTest() {
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

		//se presupone que en este punto, waste no tiene cartas
		assertNull(deckToWasteMoveController.move(deckToWasteMoveController.getDeckStack(), deckToWasteMoveController.getWasteStack()));
	}

	@Test
	public void wasteToFoundationMoveControllerTest() {
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

		//se mueven el resto de cartas de waste para probar el caso de que se quede vacío
		wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack());
		wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack());
		wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack());
		assertNull(wasteToFoundationMoveController.move(wasteToFoundationMoveController.getWasteStack(), wasteToFoundationMoveController.getFoundationsStack()));
	}

	@Test
	public void wasteToTableausMoveControllerTest() {
		int sizeWaste = wasteToTableausMoveController.getWasteStack().size();
		int sizeTableauToMove = wasteToTableausMoveController.getTableausStack().get(0).size();

		Card topCardFromWaste = wasteToTableausMoveController.getWasteStack().peek();
		assertTrue(topCardFromWaste.isUncovered());
		Card movedCard = wasteToTableausMoveController.move(wasteToTableausMoveController.getWasteStack(), wasteToTableausMoveController.getTableausStack(), 0);
		Card topCardFromTableausToMove = wasteToTableausMoveController.getTableausStack().get(0).peek();
		assertTrue(topCardFromTableausToMove.isUncovered());

		assertEquals(sizeWaste - 1, wasteToTableausMoveController.getWasteStack().size());
		assertEquals(sizeTableauToMove + 1, wasteToTableausMoveController.getTableausStack().get(0).size());

		assertEquals(topCardFromWaste, movedCard);
		assertEquals(movedCard, topCardFromTableausToMove);

		//mover carta que no cumple criterios de valor y/o color
		assertNull(wasteToTableausMoveController.move(wasteToTableausMoveController.getWasteStack(), wasteToTableausMoveController.getTableausStack(), 0));
		assertNull(wasteToTableausMoveController.move(wasteToTableausMoveController.getWasteStack(), wasteToTableausMoveController.getTableausStack(), 0));
		
		//mover carta a tableau vacío
		assertNotNull(wasteToTableausMoveController.move(wasteToTableausMoveController.getWasteStack(), wasteToTableausMoveController.getTableausStack(), 1));
		
		//se presupone que en este punto, waste no tiene cartas
		assertNull(wasteToTableausMoveController.move(wasteToTableausMoveController.getWasteStack(), wasteToTableausMoveController.getTableausStack(), 0));
	}

}
