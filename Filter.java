import java.io.File;

import javax.swing.filechooser.FileFilter;


public class Filter extends FileFilter {

	   private String description;
	   private String extension;

	   public Filter(String description, String extension){
	      if(description == null || extension == null){
	         throw new NullPointerException("La description (ou extension) ne peut �tre null.");
	      }
	      this.description = description;
	      this.extension = extension;
	   }

	   public boolean accept(File file){
	      if(file.isDirectory()) { 
	         return true; 
	      } 
	      String nomFichier = file.getName().toLowerCase(); 
	 
	      return nomFichier.endsWith(extension);
	   }
	   
	   public String getDescription(){
	      return description;
	   }

}
