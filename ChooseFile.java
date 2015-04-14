
import java.io.File;

import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;


public class ChooseFile implements MouseListener {
	
	private StyledText pathFile;
	private StyledText txtTimeSrc;
	private StyledText txtTimeTree;
	private StyledText txtTimeDecode;
	private Button btnTxt;
	private Button btnTree;
	private Button btnDecode;
	private StyledText fileSize;
	private StyledText fileComprSize;
	private StyledText amountCompr;
	
	public ChooseFile(StyledText pathFile, StyledText txtTimeSrc, StyledText txtTimeTree, StyledText txtTimeDecode, 
						Button btnTxt, Button btnTree, Button btnDecode, StyledText fileSize, StyledText fileComprSize, StyledText amountCompr) {
		this.pathFile = pathFile;
		this.txtTimeSrc = txtTimeSrc;
		this.txtTimeTree = txtTimeTree;
		this.txtTimeDecode = txtTimeDecode;
		this.btnTxt = btnTxt;
		this.btnTree = btnTree;
		this.btnDecode = btnDecode;
		this.fileSize = fileSize;
		this.fileComprSize = fileComprSize;
		this.amountCompr = amountCompr;
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
		JFileChooser fileC = new JFileChooser(".");
		Filter filter = new Filter("Fichier Texte", ".txt");
		String path;
		
		int valFileSize = 0;
		double compression = 0;
		
		fileC.addChoosableFileFilter(filter);
		fileC.setAcceptAllFileFilterUsed(false);
		fileC.setDialogTitle("Texte à encoder");
		fileC.setFileFilter(filter);
		
		// Lancement de tous les processus (centre nerveux)
		if(fileC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			pathFile.setText(fileC.getSelectedFile().getAbsolutePath());
			
			// Comptage des itérations
			ReadFile r = new ReadFile(fileC.getSelectedFile());
			txtTimeSrc.setText(r.algo1());
			
			for(char c = 0; c < r.getChars().length; c++) {
				valFileSize += r.getChars()[c].getOcu();
			}
			
			valFileSize *= 8;
			
			fileSize.setText(String.valueOf(valFileSize));
			
			// Construction de l'arbre
			TreeBuilder t = new TreeBuilder(r.getChars());
			txtTimeTree.setText(t.algo1());
			
			path = FilesBuilder.treeFile(t);
			if(!btnTree.isListening(SWT.MouseUp)) {
				btnTree.addMouseListener(new FileOpener(path));
			}
			
			// Encode le fichier
			TextEncoder encode = new TextEncoder(t.getTree().getTreeCharKey(), fileC.getSelectedFile());
			path = FilesBuilder.encodeFile(encode.algo1());
			if(!btnTxt.isListening(SWT.MouseUp)) {
				btnTxt.addMouseListener(new FileOpener(path));
			}
			
			fileComprSize.setText(String.valueOf(encode.getSizeText()));
			
			compression = (1 - ((double)encode.getSizeText() / (double)valFileSize)) * 100;
			
			amountCompr.setText(String.valueOf(compression));
			
			// Decode le fichier
			TextDecoder decode = new TextDecoder(t.getTree().getTreeBinaryKey(), new File(path));
			txtTimeDecode.setText(decode.algo1());
			path = FilesBuilder.decodeFile(decode.getStr());
			if(!btnDecode.isListening(SWT.MouseUp)) {
				btnDecode.addMouseListener(new FileOpener(path));
			}
		}
	}

}
