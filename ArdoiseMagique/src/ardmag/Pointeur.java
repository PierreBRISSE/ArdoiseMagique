package ardmag;

import java.awt.Color;

public class Pointeur {
	private Color CouleurP = Color.RED;
	private int t=20;
	private int posx=50,posy=50;
	private String FormeP="rond";
	
	public Pointeur(int px, int py, int pt, String pforme, Color pcouleur) {
		this.posx=px;
		this.posy=py;
		this.t=pt;
		this.FormeP=pforme;
		this.CouleurP=pcouleur;
	}
	
	//------------------------------------------
	public void setCouleurPointeur(Color c) {
		this.CouleurP=c;
	}
	
	public void setFormePointeur(String str) {
		this.FormeP=str;
	}
	
	public void setPosX(int x) {
		this.posx=x;
	}

	public void setPosY(int y) {
		this.posy=y;
	}
	
	public void setTpointeur(int t) {
		this.t=t;
	}
	
	//-------------------------------------
	public Color getCouleurPointeur() {
		return this.CouleurP;
	}
	
	public String getFormePointeur() {
		return this.FormeP;
	}
	
	public int getPosX() {
		return this.posx;
	}
	
	public int getposY() {
		return this.posy;
	}
	
	public int getTpointeur() {
		return this.t;
	}
	
}
