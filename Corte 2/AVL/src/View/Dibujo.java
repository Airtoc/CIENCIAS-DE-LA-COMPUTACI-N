package View;

import Controllers.ArbolAvlController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Dibujo extends JFrame {

    private PanelArbolAvl panel;
    private final int ancho, alto;
    private ArbolAvlController controller;
    private JScrollPane jsp;

    public Dibujo() {
        ancho = 1000;
        alto = 600;
        controller = ArbolAvlController.getInstance();

    }

    private void initComponents() {
        panel = new PanelArbolAvl(controller.getArbol());
        panel.setPreferredSize(new Dimension(2000, 2000));

        jsp = new JScrollPane(panel);
        jsp.setSize(new Dimension(ancho, alto-35));
        jsp.setLocation(0, 0);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp);

    }

    public PanelArbolAvl getPanel() {
        return panel;
    }

    public void initTemplate() {
        setLayout(null);
        setTitle("Grafica arbol AVL");
        setSize(new Dimension(ancho, alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //getContentPane().setBackground(new Color(245,255,250));
        getContentPane().setBackground(new Color(224, 255, 255));
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

}
