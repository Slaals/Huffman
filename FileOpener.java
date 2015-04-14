import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.eclipse.swt.events.MouseListener;


public class FileOpener implements MouseListener  {
	
	private String path;

	public FileOpener(String path) {
		this.path = path;
	}

	@Override
	public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
		Desktop desk = Desktop.getDesktop();
		
		try {
			desk.open(new File(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}


}
