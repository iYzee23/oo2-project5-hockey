package gui;

import java.awt.Color;

public abstract class Figura {
	
	protected Scena scena;
	protected double x, y;
	protected Color boja;
	
	protected Figura(Scena s, int xx, int yy, Color b) {
		 scena = s; 
		 x = xx; 
		 y = yy; 
		 boja = b; 
	}
	
	public double dohvX() { 
		return x; 
	}
	
	public double dohvY() { 
		return y; 
	}
	
	public abstract void crtaj();
	
	public abstract char vrsta();
	
}