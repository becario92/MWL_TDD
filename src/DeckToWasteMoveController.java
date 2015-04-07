import java.util.ArrayList;


public class DeckToWasteMoveController {

	private int sizeDeck;
	private int sizeWaste;
	
	DeckToWasteMoveController() {
		// en este movimiento, el deck puede tener de 0 a 24 cartas
		sizeDeck = (int) (Math.random()*25);
		// no necesariamente tendrá ese número de cartas, pero para los test es suficiente
		sizeWaste = 24 - sizeDeck;
	}

	public ArrayList<Integer> sizeFoundations() {
		// TODO Auto-generated method stub
		return null;
	}

	public void move() {
		// TODO Auto-generated method stub
		sizeDeck -= 3;
		sizeWaste += 3;
	}

	public int getSizeDeck() {
		return sizeDeck;
	}

	public void setSizeDeck(int sizeDeck) {
		this.sizeDeck = sizeDeck;
	}

	public int getSizeWaste() {
		return sizeWaste;
	}

	public void setSizeWaste(int sizeWaste) {
		this.sizeWaste = sizeWaste;
	}

}
