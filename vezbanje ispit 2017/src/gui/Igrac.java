//Igrac.java
package gui;
import java.awt.Color;
import java.awt.Graphics;
public class Igrac extends Aktivna {
 private int w, h, dy = 1;
 public Igrac(Scena s, int x, int y, Color b,
int t, int ww, int hh) {
 super(s, x, y, b, t); w = ww; h = hh;
 nit.start();
 }
 public int dohvSir() { return w; }
 public int dohvVis() { return h; }
 @Override
 protected void azurirajPolozaj() {
 Figura f = null;
 for (int i = 0;
 (f = scena.dohvatiFig(i)) != null; i++)
 if (f.vrsta() == 'P') break;
 if (f == null) return;
 Pak p = (Pak) f;
 // ako pak ide prema igracu
 if(p.dohvX() > x && p.dohvDx() < 0 ||
p.dohvX() < x && p.dohvDx() > 0){
 // igrac poravnava svoj y polozaj sa pakom
 if(y < p.dohvY()) dy = 1;
 else if(y > p.dohvY()) dy = -1;
 }
 y += dy;
 if (y - h / 2 <= 0){ y = h/2; dy = -dy; }
 else if (y + h / 2 >= scena.getHeight()){
 y = scena.getHeight() - h/2; dy = -dy;
 }
 }
 @Override
public void crtaj() {
 Graphics g = scena.getGraphics();
 g.setColor(boja);
 g.fillRect((int)x-w/2, (int)y-h/2, w, h);
 }
 @Override
public char vrsta() { return 'I'; } }