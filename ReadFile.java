
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ReadFile {
	
	private File file;
	private final int NB_CHARS = 256;
	private Occurrence[] charsOcu = new Occurrence[NB_CHARS];
	
	public ReadFile(File file) {
		this.file = file;
		
		// Init. le tableau de caractères
		for(char i = 0; i < NB_CHARS; i++) {
			charsOcu[i] = new Occurrence(0, i);
		}
		
		charsOcu[10].setOcu(-1);
	}
	
	public String read() throws IOException {
		String str = "";
		
		/*
		 * Choix du scanner :
		 * Buffer de 1ko contre 8ko pour FileReader.
		 * Même temps d'exécution que FileReader. <Voir la complexité>
		 * Le temps en deuxième et + lecture est plus court :
		 * - Supposition : le buffer connait déjà le fichier
		 */
		try {
			FileReader file = new FileReader(this.file);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				str += sc.nextLine();
				
				// Ajout de la nouvelle ligne
				str += "\n";
			}
			sc.close();
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return str;
	}
	
	public String algo1() {	
		long t1 = System.currentTimeMillis();
		
		String str = "";
		
		try {
			str = this.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Fin de chrono après comptage
		long t2 = System.currentTimeMillis() - t1;

		for(Character charSelect : str.toCharArray()) {
			/*
			 *  Clause qui empêche le bug selon l'encodage
			 *  En l'occurence l'encodage de Windows qui lit différents tirets (dont l'un qui possède la valeur 8211)
			 *  Valeur qui va au delà de l'ASCII étendu !
			 */
			if(charSelect < 256)
				this.charsOcu[(int)charSelect].setOcu();
		}
		

		return String.valueOf(t2);

	}
	
	// Compte les /n (New line)
	/*public String algo2() {
		int add = 0;
		// Chrono
		
		long t1 = System.currentTimeMillis();
		
		try {
			FileReader file = new FileReader(this.file);
			
			int c = file.read();
			
			while(c != -1) {
				// Evite l'offset en cas de caractères formatés, le tableau ne prévoit que 256 slots
				if(c > 255) {
					if(this.chars.containsKey(c)){
						add = this.chars.get((char)c) + 1;
					} else {
						this.chars.put((char)c, 0);
					}
				}
				add = this.chars.get((char)c) + 1;
				this.chars.put((char)c, add);
				
				c = file.read();

			}
			
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Fin de chrono après comptage
		long t2 = System.currentTimeMillis() - t1;
		
		

		return String.valueOf(t2);
	}*/

	public Occurrence[] getChars() {
		return this.charsOcu;
	}

}
