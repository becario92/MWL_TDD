import org.junit.Before;

public class DeckToWasteMoveControllerTest {
	
	private DeckToWasteMoveController deckToWasteMoveController;
	
	private int sizeWaste;
	
	@Before
	public void before() {
		deckToWasteMoveController = new DeckToWasteMoveController();
		sizeWaste = deckToWasteMoveController.sizeWaste();
	}

}
