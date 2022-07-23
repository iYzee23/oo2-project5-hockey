package gui;

import java.awt.Color;

public abstract class Aktivna extends Figura implements Runnable {
	
	protected Thread nit = new Thread(this);
	private int tAzur;
	private boolean radi;
	
	public Aktivna(Scena s, int xx, int yy, Color b, int t) {
		super(s, xx, yy, b); 
		tAzur = t;
	}
	
	protected abstract void azurirajPolozaj();
	
	@Override
	public void run() {
		try {
			while (!nit.isInterrupted()) {
				synchronized (this) {
					while (!radi) wait();
				}
				azurirajPolozaj();
				scena.repaint();
				Thread.sleep(tAzur);
			}
		} catch (InterruptedException ie) {
			// bez efekta
		}
	}
	
	public synchronized void kreni() {
		radi = true; 
		notifyAll();
	}
	
	public synchronized void stani() { 
		radi = false;
		notifyAll();
	}
	
	public synchronized void prekini() {
		if (nit != null) nit.interrupt();
		while (nit != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// bez efekta
			}
		}
	}
	
}
