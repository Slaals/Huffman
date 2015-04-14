
import java.nio.charset.Charset;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.StyledText;




public class Menu {
	
	private Shell shell;
	public static Display DISPLAY = new Display();
	
	public Menu() {
		this.shell = new Shell();
		
		initComposant();
		
		afficher();
	}
	
	public void afficher() {
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!DISPLAY.readAndDispatch()) {
				DISPLAY.sleep();
			}
		}
	}
	
	public void initComposant() {
		Display.getDefault();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setSize(638, 378);
		shell.setText("Codage de Huffman");	
		
		Button btnFile = new Button(shell, SWT.NONE);
		btnFile.setBounds(10, 26, 94, 43);
		btnFile.setText("Texte \u00E0 coder");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 188, 94, 64);
		
		String img = "/img/file.png";
		
		Button btnImgTxt = new Button(composite, SWT.NONE);
		btnImgTxt.setImage(SWTResourceManager.getImage(Menu.class, img));
		btnImgTxt.setBounds(0, 0, 94, 64);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 96, 547, 2);
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setBounds(226, 188, 94, 64);
		
		Button btnImgTree = new Button(composite_1, SWT.NONE);
		btnImgTree.setImage(SWTResourceManager.getImage(Menu.class, img));
		btnImgTree.setBounds(0, 0, 94, 64);
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setBounds(463, 188, 94, 64);
		
		Button btnImgDecode = new Button(composite_2, SWT.NONE);
		btnImgDecode.setImage(SWTResourceManager.getImage(Menu.class, img));
		btnImgDecode.setBounds(0, 0, 94, 64);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(164, 135, 2, 178);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_2.setBounds(385, 135, 18, 178);
		
		Label lblLectureDuFichier = new Label(shell, SWT.NONE);
		lblLectureDuFichier.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblLectureDuFichier.setFont(SWTResourceManager.getFont("Tekton Pro", 12, SWT.NORMAL));
		lblLectureDuFichier.setBounds(10, 104, 121, 15);
		lblLectureDuFichier.setText("Lecture du texte :");
		
		Label lblCrationDeLarbre = new Label(shell, SWT.NONE);
		lblCrationDeLarbre.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblCrationDeLarbre.setFont(SWTResourceManager.getFont("Tekton Pro", 12, SWT.NORMAL));
		lblCrationDeLarbre.setBounds(226, 104, 137, 15);
		lblCrationDeLarbre.setText("Cr\u00E9ation de l'arbre :");
		
		Label lblCodageDuFichier = new Label(shell, SWT.NONE);
		lblCodageDuFichier.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblCodageDuFichier.setFont(SWTResourceManager.getFont("Tekton Pro", 12, SWT.NORMAL));
		lblCodageDuFichier.setBounds(463, 104, 137, 15);
		lblCodageDuFichier.setText("Decodage du texte :");
		
		Label lblNewLabel = new Label(shell, SWT.CENTER);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(110, 145, 37, 30);
		lblNewLabel.setText("ms");
		
		Label label_3 = new Label(shell, SWT.CENTER);
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_3.setEnabled(false);
		label_3.setText("ms");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		label_3.setAlignment(SWT.CENTER);
		label_3.setBounds(326, 145, 37, 30);
		
		Label label_4 = new Label(shell, SWT.CENTER);
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_4.setEnabled(false);
		label_4.setText("ms");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		label_4.setAlignment(SWT.CENTER);
		label_4.setBounds(563, 145, 37, 30);
		
		Label lblBits = new Label(shell, SWT.CENTER);
		lblBits.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblBits.setEnabled(false);
		lblBits.setText("bits");
		lblBits.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblBits.setAlignment(SWT.CENTER);
		lblBits.setBounds(110, 283, 37, 30);
		
		Label lblBits2 = new Label(shell, SWT.CENTER);
		lblBits2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblBits2.setEnabled(false);
		lblBits2.setText("bits");
		lblBits2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblBits2.setAlignment(SWT.CENTER);
		lblBits2.setBounds(326, 264, 37, 30);
		
		Label percent = new Label(shell, SWT.CENTER);
		percent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		percent.setEnabled(false);
		percent.setText("%");
		percent.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		percent.setAlignment(SWT.CENTER);
		percent.setBounds(326, 302, 37, 30);
		
		StyledText txtTimeTree = new StyledText(shell, SWT.BORDER | SWT.READ_ONLY | SWT.SINGLE);
		txtTimeTree.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		txtTimeTree.setTopMargin(10);
		txtTimeTree.setDoubleClickEnabled(false);
		txtTimeTree.setAlignment(SWT.CENTER);
		txtTimeTree.setEditable(false);
		txtTimeTree.setEnabled(false);
		txtTimeTree.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtTimeTree.setBounds(226, 132, 94, 43);
		
		StyledText fileSize = new StyledText(shell, SWT.BORDER | SWT.READ_ONLY | SWT.SINGLE);
		fileSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		fileSize.setTopMargin(10);
		fileSize.setDoubleClickEnabled(false);
		fileSize.setAlignment(SWT.CENTER);
		fileSize.setEditable(false);
		fileSize.setEnabled(false);
		fileSize.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		fileSize.setBounds(10, 270, 94, 43);
		
		StyledText fileComprSize = new StyledText(shell, SWT.BORDER | SWT.READ_ONLY | SWT.SINGLE);
		fileComprSize.setRightMargin(0);
		fileComprSize.setLeftMargin(0);
		fileComprSize.setBottomMargin(0);
		fileComprSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		fileComprSize.setTopMargin(0);
		fileComprSize.setDoubleClickEnabled(false);
		fileComprSize.setAlignment(SWT.CENTER);
		fileComprSize.setEditable(false);
		fileComprSize.setEnabled(false);
		fileComprSize.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		fileComprSize.setBounds(226, 270, 94, 22);
		
		StyledText amountCompr = new StyledText(shell, SWT.BORDER | SWT.READ_ONLY | SWT.SINGLE);
		amountCompr.setBottomMargin(0);
		amountCompr.setLeftMargin(0);
		amountCompr.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		amountCompr.setTopMargin(0);
		amountCompr.setDoubleClickEnabled(false);
		amountCompr.setAlignment(SWT.CENTER);
		amountCompr.setEditable(false);
		amountCompr.setEnabled(false);
		amountCompr.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		amountCompr.setBounds(226, 308, 94, 22);
		
		StyledText txtTimeSrc = new StyledText(shell, SWT.BORDER | SWT.SINGLE);
		txtTimeSrc.setAlignment(SWT.CENTER);
		txtTimeSrc.setTopMargin(10);
		txtTimeSrc.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		txtTimeSrc.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtTimeSrc.setDoubleClickEnabled(false);
		txtTimeSrc.setEditable(false);
		txtTimeSrc.setEnabled(false);
		txtTimeSrc.setBounds(10, 132, 94, 43);
		
		StyledText txtFile = new StyledText(shell, SWT.BORDER | SWT.SINGLE);
		txtFile.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		txtFile.setTopMargin(8);
		txtFile.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtFile.setDoubleClickEnabled(false);
		txtFile.setBounds(110, 26, 447, 43);
		
		StyledText txtTimeDecode = new StyledText(shell, SWT.BORDER | SWT.SINGLE);
		txtTimeDecode.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtTimeDecode.setTopMargin(10);
		txtTimeDecode.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		txtTimeDecode.setAlignment(SWT.CENTER);
		txtTimeDecode.setDoubleClickEnabled(false);
		txtTimeDecode.setEditable(false);
		txtTimeDecode.setEnabled(false);
		txtTimeDecode.setBounds(463, 132, 94, 43);
		
		btnFile.addMouseListener(new ChooseFile(txtFile, txtTimeSrc, txtTimeTree, txtTimeDecode,
												btnImgTxt, btnImgTree, btnImgDecode, fileSize, fileComprSize, amountCompr));

		
		
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		new Menu();
	}
	
}
