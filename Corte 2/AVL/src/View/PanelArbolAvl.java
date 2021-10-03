package View;

import Models.ArbolAvl;
import Models.NodoAvl;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelArbolAvl extends JPanel {
    
    private ArbolAvl arbol;
    private static int ancho = 100, diametro = 40, radio = diametro / 2;
    //Diametro de los nodos, radio, ancho de separación entre los nodos

    public PanelArbolAvl(ArbolAvl arbol) {
        this.arbol = arbol;
    }

    public void setArbol(ArbolAvl arbol) {
        this.arbol = arbol;
        repaint();
    }

    public void pintar(Graphics g, int x, int y, NodoAvl raiz) {
        if (raiz != null) {
            int extra = raiz.nodosComletos(raiz) * (ancho /2); //Espacio extra para que los nodos no queden pegados
            g.drawRect(x, y, 100, 50);
            
            g.drawString(raiz.getEstudiante().getNombre(), x+5, y + 18); //Dibujar Nombre del estudiante
            g.drawString(String.valueOf(raiz.getEstudiante().getTelefono()), x+5, y + 35); //Dibujar ódigo del estidiante
            g.setColor(Color.RED);
            g.drawString(String.valueOf(raiz.getBalance()), x+50, y + 18);
            g.setColor(Color.BLACK);
            
            //Dibujar lineas izquierda y derecha
            if (raiz.getIzquierda()!= null) {
                g.drawLine(x+radio, y+radio, x - ancho - extra + radio, y + ancho + radio);
            }
            if (raiz.getDerecha()!= null) {
                g.drawLine(x + radio, y + radio, x + ancho + extra + radio, y + ancho + radio);
            }
            
            //Llamadas recursivas para dibujar a los hijos
            pintar(g, x - ancho - extra, y + ancho, raiz.getIzquierda());
            pintar(g, x + ancho + extra, y + ancho, raiz.getDerecha());
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, (getWidth() / 2), 20, arbol.getRaiz());
    }
    
}
