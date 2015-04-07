import java.util.ArrayList;


public class DeckToWasteMoveController {

	private int sizeDeck;
	
	DeckToWasteMoveController() {
		// en este movimiento, el deck puede tener de 0 a 24 cartas
		sizeDeck = (int) (Math.random()*25);		
	}
	
	public int sizeWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Integer> sizeFoundations() {
		// TODO Auto-generated method stub
		return null;
	}

	public void move() {
		// TODO Auto-generated method stub
		sizeDeck -= 3;
	}

	public int getSizeDeck() {
		return sizeDeck;
	}

	public void setSizeDeck(int sizeDeck) {
		this.sizeDeck = sizeDeck;
	}

}
