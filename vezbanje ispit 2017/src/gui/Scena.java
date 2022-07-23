package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class Scena extends Canvas {

	private static final long serialVersionUID = 1L;
	private ArrayList<Figura> figure = new ArrayList<Figura>();
	
	 public synchronized Scena dodaj(Figura f) {
		 figure.add(f); 
		 return this;
	 }
	 
	 public synchronized Figura dohvatiFig(int ind) {
		 if (ind < 0 || ind >= figure.size()) return null;
	 		return figure.get(ind);
	 }
	 
	 @Override
	 public synchronized void paint(Graphics g) {
		 for (Figura f: figure)
			 if (f != null) f.crtaj();
	 }
	 
	 public synchronized void kreni() {
		 for (Figura f: figure)
			 if (f != null && f instanceof Aktivna)
				 ((Aktivna) f).kreni();
	 }
	 
	 public synchronized void stani() {
		 for (Figura f: figure)
			 if (f != null && f instanceof Aktivna)
				 ((Aktivna) f).stani();
	 }
	 
	 public synchronized void prekini() {
		 for (Figura f: figure)
			 if (f != null && f instanceof Aktivna)
				 ((Aktivna) f).prekini();
	 }
	 
}