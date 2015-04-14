
public class Occurrence {
	
	private int ocu;
	private char character;
	
	public Occurrence(int ocu, char character) {
		this.ocu = ocu;
		this.character = character;
	}

	public int getOcu() {
		return ocu;
	}

	public void setOcu() {
		this.ocu++;
	}
	
	public void setOcu(int v) {
		this.ocu = v;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

}
