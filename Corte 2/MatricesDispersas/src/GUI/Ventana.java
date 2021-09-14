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
	private JPanel contentPanel, graphPanel;
	private Matriz a, b;

	public Ventana(String title) {
		a = new Matriz("a");
		b = new Matriz("b");
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		loadComponents();
	}

	public void addA() {
		// Action listener A
		int columna = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte la columna").trim());
		int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte la fila").trim());
		int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el valor").trim());
		// Añade la columna
		NodoColumna col = new NodoColumna(columna);
		NodoFila fil = new NodoFila(fila, valor);

		if (a.getInicio() == null) {
			// si no hay un nodo inicial , se convierte en el primero
			a.setInicio(col);
			col.setCabeza(fil);
		} else {
			// Añade el nodo
			a.addNodoColumna(col, a.getInicio(), fil);

		}

	}

	public void addB() {
		// Action listener B
		int columna = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte la columna").trim());
		int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte la fila").trim());
		int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el valor").trim());
		// Añade la columna
		NodoColumna col = new NodoColumna(columna);
		NodoFila fil = new NodoFila(fila, valor);

		if (b.getInicio() == null) {
			// si no hay un nodo inicial , se convierte en el primero
			b.setInicio(col);
			col.setCabeza(fil);
		} else {
			// Añade el nodo
			b.addNodoColumna(col, b.getInicio(), fil);

		}
	}

	public void loadComponents() {
		// Panel: ContentPanel.
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 76, 81, -16);
		contentPanel.add(btnNewButton);

		JButton btnMarizA = new JButton("Add A");
		btnMarizA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Action listener matriz A
				addA();
			}
		});
		btnMarizA.setBounds(24, 61, 89, 23);
		contentPanel.add(btnMarizA);

		JButton btnMatizB = new JButton("Add B");
		btnMatizB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Action listener matriz B
				addB();
			}
		});
		btnMatizB.setBounds(24, 134, 89, 23);
		contentPanel.add(btnMatizB);

		JButton btnOperation = new JButton("Multiplicar");
		btnOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("to be defined");
				/*
				 * 2x3-3x2->
				 * fila-columna 
				 * columnas A = filas B
				 */
				int MaxColA = a.nColumnas(a.getInicio());
				int MaxColB = b.nColumnas(b.getInicio());
				int MaxFilA = a.nFilas(a.getInicio().getCabeza());
				int MaxFilB = b.nFilas(b.getInicio().getCabeza());
				System.out.println("Matriz A -> MaxCol: "+MaxColA+" MaxFil: "+MaxFilA);
				System.out.println("Matriz B -> MaxCol: "+MaxColB+" MaxFil: "+MaxFilB);
			}
		});
		btnOperation.setBounds(24, 200, 89, 23);
		contentPanel.add(btnOperation);

		JButton btnShow = new JButton("Imprimir");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				System.out.println("Matriz A");
				a.mostrarlista(a.getInicio());
				System.out.println("Matriz B");
				b.mostrarlista(b.getInicio());
				// action listener imprimir
			}
		});
		btnShow.setBounds(24, 264, 89, 23);
		contentPanel.add(btnShow);
		setVisible(true);

		// Panel: GraphPanel.

		// PRUEBA!!!
		int values[] = { 1, 2, 3, 4, 5 };
		graphPanel = new JPanel();
		graphPanel.add(new Graph(values));
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}
}