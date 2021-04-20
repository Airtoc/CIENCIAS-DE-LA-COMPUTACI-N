package View;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class EntradaArticulo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField[][] articulos;
    private JLabel pesos,valores;

    public EntradaArticulo(int numeroArticulos) {
        articulos = new JTextField[2][numeroArticulos];
        pesos = new JLabel("Peso del articulo");
        valores = new JLabel("valor del articulo");

    }

    public void initInputElements() {
        pesos.setSize(new Dimension(800, 25));
        pesos.setLocation(10, 0);
        pesos.setVisible(true);
        pesos.setFont(new Font("Arial", Font.BOLD, 25));
        add(pesos);
        
        valores.setSize(new Dimension(800, 25));
        valores.setLocation(10, 150);
        valores.setVisible(true);
        valores.setFont(new Font("Arial", Font.BOLD, 25));
        add(valores);
        
        for (int i = 0; i < articulos.length; i++) {
            for (int j = 0; j < articulos[i].length; j++) {
                articulos[i][j] = new JTextField();
                articulos[i][j].setBounds(j * 60 + 6, i * 60 + 28, 50, 50);
                articulos[i][j].setHorizontalAlignment(JLabel.CENTER);
                articulos[i][j].setFont(new Font("Arial",Font.BOLD,15));
                add(articulos[i][j]);
            }
        }
        
        repaint();
    }

    public void removeInputElements() {
        removeAll();
        repaint();
    }

    public JTextField[][] getArticulos(){
        return articulos;
    }

    
}
