package ardmag;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class FenArdMag extends JFrame {
	private Thread t = new Thread();
	
	
	//PANNEAUX :
	private JPanel conteneur = new JPanel();
	private PanAM Pdessin = new PanAM();
	private JPanel Pnord = new JPanel();
	private JPanel Pcontour1= new JPanel();
	private JPanel Pcontour2= new JPanel();
	private JPanel Pcontour3= new JPanel();
	private BorderLayout bl = new BorderLayout();
	
	//DIMENSIONS :
	private Dimension dimT = new Dimension();
	//Panneaux
	private Dimension dimM = new Dimension();
	private Dimension dimB = new Dimension();
	private Dimension dimN = new Dimension();
	
	//COULEURS :
	private Color noir = Color.BLACK;
	private Color blanc = Color.WHITE;
	private Color rouge = Color.RED;
	private Color bleu = Color.BLUE;
	private Color vert = Color.GREEN;
	
	//MENU PRINCIPAL :
	private JMenuBar menuBar = new JMenuBar();
	//Sous-menus
	private JMenu SousMenuFichier = new JMenu("FICHIER");
	private JMenu SousMenuEdition = new JMenu("EDITION");
	private JMenu EditionSousMenuPointeurForme = new JMenu("Forme du pointeur");
	private JMenu EditionSousMenuPointeurCouleur = new JMenu("Couleur du pointeur");
	//Éléments des sous-menus
	private JMenuItem MIeffacer = new JMenuItem("Effacer");
	private JMenuItem MIquitter = new JMenuItem("Quitter");
	private JMenuItem MIrond = new JMenuItem("Rond");
	private JMenuItem MIcarre = new JMenuItem("Carré");
	private JMenuItem MIrouge = new JMenuItem("Rouge");
	private JMenuItem MIvert = new JMenuItem("Vert");
	private JMenuItem MIbleu = new JMenuItem("Bleu");
	
	//BARRE D'OUTILS :
	private JToolBar barreOutils = new JToolBar();
	//Boutons
	private ImageIcon ICN = new ImageIcon("C://Users//Pierre//Desktop//Projet alpha//src//ArdoiseMagique//src//CN.jpg");
	private ImageIcon IRN = new ImageIcon("C://Users//Pierre//Desktop//Projet alpha//src//ArdoiseMagique//src//RN.jpg");
	private ImageIcon ICR = new ImageIcon("C://Users//Pierre//Desktop//Projet alpha//src//ArdoiseMagique//src//CR.jpg");
	private ImageIcon ICB = new ImageIcon("C://Users//Pierre//Desktop//Projet alpha//src//ArdoiseMagique//src//CB.jpg");
	private ImageIcon ICV = new ImageIcon("C://Users//Pierre//Desktop//Projet alpha//src//ArdoiseMagique//src//CV.jpg");
	private JButton boutonCN = new JButton(ICN);
	private JButton boutonRN = new JButton(IRN);
	private JButton boutonCR = new JButton(ICR);
	private JButton boutonCB = new JButton(ICB);
	private JButton boutonCV = new JButton(ICV);
	
	//PROGRAMMATION ACTION :
	//Programmation des éléments du menu et de la barre
	private AcionFichierEffacer actionEf = new AcionFichierEffacer();
	private AcionFichierQuitter actionQt = new AcionFichierQuitter();
	private AcionEditionFormePointeurRond actionPRond = new AcionEditionFormePointeurRond();
	private AcionEditionFormePointeurCarre actionPCarre = new AcionEditionFormePointeurCarre();
	private AcionEditionCouleurPointeurRouge actionPRouge = new AcionEditionCouleurPointeurRouge();
	private AcionEditionCouleurPointeurVert actionPVert = new AcionEditionCouleurPointeurVert();
	private AcionEditionCouleurPointeurBleu actionPBleu = new AcionEditionCouleurPointeurBleu();
	
	//**************
	//CONSTRUCTEUR :
	public FenArdMag() {
		dimT=new Dimension(1000,800);
	    this.setTitle("Ardoise magique");
	    this.setSize(dimT);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    //ACTIONS :
	    initActions();
	    //MENU :
	    intMenu();
	    //BARRE :
	    initBarre();
	    //INITIALISATION PANNEAUX :
	    initPanneaux();
	    
	    this.setContentPane(conteneur);
	    this.setVisible(true);
	}
	
	//-------------------------------------------
	//INITIALISATION :
	private void initActions() {
	    //Ajout des actions au éléments du menu
	    MIbleu.addActionListener(actionPBleu);
	    MIvert.addActionListener(actionPVert);
	    MIrouge.addActionListener(actionPRouge);
	    MIcarre.addActionListener(actionPCarre);
	    MIrond.addActionListener(actionPRond);
	    MIeffacer.addActionListener(actionEf);
	    MIquitter.addActionListener(actionQt);
	    //Ajout des actions à la barre
	    boutonCB.addActionListener(actionPBleu);
	    boutonCV.addActionListener(actionPVert);
	    boutonCR.addActionListener(actionPRouge);
	    boutonCN.addActionListener(actionPCarre);
	    boutonRN.addActionListener(actionPRond);
	}

	private void initPanneaux() {
	    //Panneau de dessinage
	    Dimension dimD = new Dimension(this.getWidth(),3*this.getHeight()/10);
	    Pdessin.setPreferredSize(dimD);
	    
	    //Finalisation de l'affichage
	    dimN = new Dimension(this.getWidth(),150);
	    Pnord.add(menuBar);
	    Pnord.add(barreOutils);
	    Pnord.setPreferredSize(dimN);
	    Pnord.setBackground(noir);
	    Pdessin.setBackground(blanc);
	    Pcontour1.setBackground(noir);
	    Pcontour2.setBackground(noir);
	    Pcontour3.setBackground(noir);
	    conteneur.setPreferredSize(dimT);
	    conteneur.setLayout(bl);
	    conteneur.setBackground(noir);
	    conteneur.add(Pnord,BorderLayout.NORTH);
	    conteneur.add(Pdessin,BorderLayout.CENTER);
	    conteneur.add(Pcontour1,BorderLayout.WEST);
	    conteneur.add(Pcontour2,BorderLayout.EAST);
	    conteneur.add(Pcontour3,BorderLayout.SOUTH);
	}

	private void initBarre() {
	    boutonCN.setBackground(noir);
	    boutonRN.setBackground(noir);
	    boutonCR.setBackground(noir);
	    boutonCB.setBackground(noir);
	    boutonCV.setBackground(noir);
	    barreOutils.add(boutonCN);
	    barreOutils.add(boutonRN);
	    barreOutils.addSeparator();
	    barreOutils.add(boutonCR);
	    barreOutils.add(boutonCB);
	    barreOutils.add(boutonCV);
	    dimB = new Dimension(96*this.getWidth()/100,100);
	    barreOutils.setPreferredSize(dimB);
	    barreOutils.setBackground(noir);
	}

	private void intMenu() {
	    //Ajout des éléments au sous-menu Fichier
	    MIeffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
	    MIquitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
	    SousMenuFichier.setForeground(rouge);
	    SousMenuEdition.setForeground(vert);
	    SousMenuFichier.add(MIeffacer);
	    SousMenuFichier.addSeparator();
	    SousMenuFichier.add(MIquitter);
	    //Ajout des éléments au sous-menu Edition
	    EditionSousMenuPointeurForme.add(MIrond);
	    EditionSousMenuPointeurForme.add(MIcarre);
	    EditionSousMenuPointeurCouleur.add(MIrouge);
	    EditionSousMenuPointeurCouleur.add(MIvert);
	    EditionSousMenuPointeurCouleur.add(MIbleu);
	    SousMenuEdition.add(EditionSousMenuPointeurForme);
	    SousMenuEdition.addSeparator();
	    SousMenuEdition.add(EditionSousMenuPointeurCouleur);
	    //Finalisation du menu
	    menuBar.setBackground(noir);
	    menuBar.add(SousMenuFichier);
	    menuBar.add(SousMenuEdition);
	    dimM = new Dimension(96*this.getWidth()/100,30);
	    menuBar.setPreferredSize(dimM);
	}

	//*********************************************************
	//			Actions du sous-menu Fichier
	class AcionFichierEffacer implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setEffacer();
		}
	}
	
	class AcionFichierQuitter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	//-------------------------------------------------------------
	//			Actions du sous-menu Edition	
	//Action Forme du pointeur
	class AcionEditionFormePointeurRond implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setFormePointeur("rond");
		}
	}
	
	class AcionEditionFormePointeurCarre implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setFormePointeur("carre");
		}
	}
	
	//Action Couleur du pointeur
	class AcionEditionCouleurPointeurRouge implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setCouleurPointeur(rouge);
		}
	}
	
	class AcionEditionCouleurPointeurVert implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setCouleurPointeur(vert);
		}
	}
	
	class AcionEditionCouleurPointeurBleu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Pdessin.setCouleurPointeur(bleu);
		}
	}
	
	
}
