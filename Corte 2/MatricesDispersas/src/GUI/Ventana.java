package GUI;

import javax.swing.*;

import Logic.Matriz;
import Logic.NodoColumna;
import Logic.NodoFila;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
	
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	private JPanel contentPanel, optionsPanel, graphPanel;
	private Matriz a,b;
	
	public Ventana(String title) {
		a = new Matriz("a");
		b = new Matriz("b");
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		loadComponents();
	}
	
	public void addA() {
		//Action listener A
		int fila = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la fila"));
		int columna = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la columna"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte el valor"));
		//Añade la columna
		NodoColumna col = new NodoColumna(columna);
		NodoFila fil = new NodoFila(fila,valor);
		
		if (a.getInicio() == null) {
            // si no hay un nodo inicial , se convierte en el primero
            a.setInicio(col);
            col.setCabeza(fil);
        } else {
            // Añade el nodo
            a.addNodoColumna(col, a.getInicio());
            
        }
        
	}
	public void addB() {
		//Action listener B
		int fila = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la fila"));
		int columna = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la columna"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte el valor"));
		//Añade la columna
		NodoColumna col = new NodoColumna(columna);
		NodoFila fil = new NodoFila(fila,valor);
		
		if (b.getInicio() == null) {
            // si no hay un nodo inicial , se convierte en el primero
            b.setInicio(col);
            col.setCabeza(fil);
        } else {
            // Añade el nodo
            b.addNodoColumna(col, b.getInicio());
            
        }
	}

	public void loadComponents() {
		// Panel: ContentPanel.
		contentPanel = new JPanel();
		setContentPane(contentPanel);

		// Panel: OptionsPanel.
		optionsPanel = new JPanel();
		contentPanel.add(optionsPanel);
		setVisible(true);

		// Panel: GraphPanel.

        // PRUEBA!!!
        int values[] = {1,2,3,4,5};
		graphPanel = new JPanel();
		graphPanel.add(new Graph(values));
	}

	@Override
    public void actionPerformed(ActionEvent event) {
       
    }
  
}