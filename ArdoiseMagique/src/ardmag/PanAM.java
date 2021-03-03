package ardmag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanAM extends JPanel {
	private static int L=20;
	private int posx=50,posy=50;
	private Color CouleurP = Color.RED;
	private String FormeP="rond";
	private boolean effacer = true;
	private SuiviSourie sl = new SuiviSourie();
	private SuiviSourie2 sl2 = new SuiviSourie2();
	private ArrayList<Pointeur> point= new ArrayList<Pointeur>();
	
	public PanAM() {
		this.addMouseListener(sl);
		this.addMouseMotionListener(sl2);
	}
	
	//--------------------------------------------------------------
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(effacer==false)
			dessein(g);
		else
			this.effacer=false;
	}

	private void dessein(Graphics g) {
		for (Pointeur p : this.point) {
			g.setColor(p.getCouleurPointeur());
			if(p.getFormePointeur().equals("rond"))
				g.fillOval(p.getPosX(), p.getposY(), L, L);
			else
				g.fillRect(p.getPosX(), p.getposY(), L, L);
		}
	}

	//---------------------------------------------------------
	public void setEffacer() {
		this.effacer=true;
		this.point=new ArrayList<Pointeur>();
		repaint();
	}
	
	public void setCouleurPointeur(Color c) {
		this.CouleurP=c;
	}
	
	public void setFormePointeur(String str) {
		this.FormeP=str;
	}
	
	public boolean getEffacer() {
		return this.effacer;
	}
	
	public Color getCouleurPointeur() {
		return this.CouleurP;
	}
	
	public String getFormePointeur() {
		return this.FormeP;
	}
	
	//---------------------------------------------------------
	class SuiviSourie extends MouseAdapter{
		public void souriPressee(MouseEvent e) {
			int x=e.getX()-L/2;
			int y=e.getY()-L/2;
			
			point.add(new Pointeur(x, y, L, FormeP, CouleurP));
			repaint();
		}
	}
	
	class SuiviSourie2 implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			int x=e.getX()-L/2;
			int y=e.getY()-L/2;
			
			point.add(new Pointeur(x, y, L, FormeP, CouleurP));
			repaint();
		}
		public void mouseMoved(MouseEvent e) {}
	}
	
}