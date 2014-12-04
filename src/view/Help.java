package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class Help extends JDialog{

	private JTextPane jTextPane = null;
	private JScrollPane jScrollPane1 = null;
	private JPanel panelPrincipal=null;
	
	public Help(){
		super();
		initialize();
	}

	
	private void initialize(){
		
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		   int hauteur = (int)(tailleEcran.getHeight()*0.8);
		   int largeur = (int)(tailleEcran.getWidth()*0.5);
		   
		   this.setTitle("Moteur de recherches");
		   this.setContentPane(getPrincipale());
		   
	       this.setSize(largeur, hauteur);
	       this.setVisible(true);
	       this.setLocationRelativeTo(null);
	       this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	       this.setAlwaysOnTop(true);
	       
	       
	}
	
	private JPanel getPrincipale(){
		
		if(panelPrincipal==null){
			panelPrincipal=new JPanel(new BorderLayout());
			panelPrincipal.add(getJScrollPane(),BorderLayout.CENTER);
			
		}
		
		return panelPrincipal;
	}
	
	private  JTextPane jTextPane() {
		
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setEditable(false);
			
			StyledDocument Doc = (StyledDocument)jTextPane.getDocument();
	        Style defaut = jTextPane.getStyle("default");
	        Style style1 = jTextPane.addStyle("style1", defaut);
	        StyleConstants.setFontFamily(style1, "Comic sans MS");
	        StyleConstants.setFontSize(style1, 22);
	        Style style2 = jTextPane.addStyle("style2", style1);
	        StyleConstants.setForeground(style2, Color.BLUE);
	        StyleConstants.setFontSize(style2, 25);
	        
	        try {
				Doc.insertString(Doc.getLength(),"Recherche par mots-cl�s dans des donn�es RDF\n\n", style2);
				
				String objectif="L�objectif de ce projet est de r�aliser une application pour l�interrogation de donn�es RDF par des motscl�s.\n"+
						"Ce sujet d�crit les fonctionnalit�s attendues sans toutefois en imposer tous les d�tails. Quand ce n�est pas\n"+
						"explicitement impos� par l��nonc�, vous avez toute latitude de d�cider du choix le plus pertinent pour votre"+
						"impl�mentation.";
				
				Doc.insertString(Doc.getLength(),objectif, style1);
				
				
				Doc.insertString(Doc.getLength(),"\n\nL'equipe de developement :\n\n", style2);
				
				String equipe="Le projet est supervis� par Mr Stephane Lopez.\n"+
						"le groupe de projet est compos� de :\n"+
						"BELEM Souleymane\n"+
						"CORPINOT  JEREMIE\n"+
						"N'DRI Ange Marie\n"+
						"HAMEG  MOHAMED\n"+
						"FALL  Sokhna\n"+
						"CHAFIA  YOUNESS\n"+
						"KATIR Somia\n";
				Doc.insertString(Doc.getLength(),equipe, style1);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
		}
		return jTextPane;
	}


	private JScrollPane getJScrollPane() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(jTextPane());
		}
		return jScrollPane1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Help();
	}

}
