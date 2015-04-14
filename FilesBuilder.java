import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FilesBuilder {
	
	public static String charOcc(Occurrence[] chars) {
		String path = "occurences_caractères.txt";
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
		
		FileWriter writer = null;
		
		try{
			writer = new FileWriter(file, true);
			for(char c = 0; c < chars.length; c++) {
				writer.write((char)c + " => " + chars[c].getOcu() + System.getProperty("line.separator"));
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return path;
	}
	
	public static String treeFile(TreeBuilder t) {
		String path = "tree.txt";
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
		
		FileWriter writer = null;
		
		try{
			writer = new FileWriter(file, true);
			writer.write(t.getTree().toString());
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return path;
	}
	
	public static String encodeFile(String str) {
		String path = "texte_encode.txt";
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
		
		FileWriter writer = null;
		
		try{
			writer = new FileWriter(file, true);
			writer.write(str);
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return path;
	}
	
	public static String decodeFile(String str) {
		String path = "texte_decode.txt";
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
		
		FileWriter writer = null;
		
		try{
			writer = new FileWriter(file, true);
			writer.write(str);
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return path;
	}

}
