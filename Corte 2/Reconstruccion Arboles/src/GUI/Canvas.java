package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import Logic.Node;
import Logic.Tree;

public class Canvas extends JPanel{
	private Tree arbol;
	public static final int Diametro = 30;
	public static final int Radio = Diametro/2;
	public static final int Ancho = 50;
	
	public void setArbol(Tree arb) {
		this.arbol = arb;
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		pintar(g,getWidth()/2,20,arbol.getRaizT());
		System.out.println("pinto: "+arbol.getRaizT().getName());
	}
	
	private void pintar(Graphics g, int x, int y, Node n) {
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (Ancho / 2);
            g.drawOval(x, y, Diametro, Diametro);
            g.drawString(n.getName(), x + 12, y + 18);
            if (n.getIzq() != null)
                g.drawLine(x+Radio, y+Radio+15, x-Ancho-EXTRA+Radio+15, y+Ancho+Radio);
            if (n.getDer() != null)
                g.drawLine(x+Radio, y+Radio+15, x+Ancho+EXTRA+Radio-15, y+Ancho+Radio);
            pintar(g,x-Ancho-EXTRA,y+Ancho,n.getIzq());
            pintar(g,x+Ancho+EXTRA,y+Ancho,n.getDer());
        }
    }
	
}
