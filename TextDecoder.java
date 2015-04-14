import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class TextDecoder {
	
	private LinkedHashMap<String, Character> tree;
	private File file;
	private String str;

	public TextDecoder(LinkedHashMap<String, Character> tree, File file) {
		this.tree = tree;
		this.file = file;
		this.str = "";
	}
	
	public String algo1() {
		String binaryStraight = "";
		String a;

		long t1 = System.currentTimeMillis();
		
		try {
			Scanner sc = new Scanner(new FileReader(this.file));
			while(sc.hasNextLine()) {
				a = sc.nextLine();
				
				a += "\n";
				
				// Comptage des occurences
				for(int i = 0; i < a.length(); i++) {
					binaryStraight += a.charAt(i);
					
					if(this.tree.get(binaryStraight) != null) {
						if(this.tree.get(binaryStraight) == (char)10) {
							this.str += "\r\n";
						} else {
							this.str += this.tree.get(binaryStraight);
						}
						
						binaryStraight = "";
					}
				}
				

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis() - t1;
		
		return String.valueOf(t2);
	}

	public String getStr() {
		return str;
	}
}
