import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class TextEncoder {
	
	private HashMap<Character, String> tree;
	private File file;
	private int sizeText = 0;

	public TextEncoder(HashMap<Character, String> tree, File file) {
		this.tree = tree;
		this.file = file;
	}
	
	public String algo1() {
		String a;
		String str = "";
		
		try {
			Scanner sc = new Scanner(new FileReader(this.file));
			while(sc.hasNextLine()) {
				a = sc.nextLine();

				for(int i = 0; i < a.length(); i++) {
					char character = a.charAt(i);
					
					// Toujours le problème d'encodage
					if(character < 256) {
						str += tree.get(character);
						sizeText += tree.get(character).length();
					}
				}
				
				str += tree.get((char)10);
				

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return str;
	}

	
	public int getSizeText() {
		return this.sizeText;
	}
}
