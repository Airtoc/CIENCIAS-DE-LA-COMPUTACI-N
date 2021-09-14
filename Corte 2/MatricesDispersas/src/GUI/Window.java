package GUI;

import javax.swing.*;

import Logic.Matriz;
import Logic.NodoColumna;
import Logic.NodoFila;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Window extends JFrame implements ActionListener {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private JPanel optionsPanel, mathPanel;
	private JButton btnMath;
	private JTextPane txtMathA, txtMathB;
	private JScrollPane scrollMathA, scrollMathB;
	private JLabel lblTitle, lblMatrixA, lblMatrixB;
	private boolean checkDataMatrixA, checkDataMatrixB = false;
	private Matriz a, b;

	public Window(String title) {
		a = new Matriz("a");
		b = new Matriz("b");
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void loadComponents() {
		
		optionsPanel = new JPanel(null);
		// optionsPanel.setBounds(0,0,400,600);
		optionsPanel.setBackground(Color.gray);
		add(optionsPanel, BorderLayout.CENTER);

		// mathPanel = new JPanel();
		// contentPanel.add(mathPanel);

		lblMatrixA = new JLabel("Matriz A");
		lblMatrixA.setBounds(10, 10, 380, 40);
		lblMatrixA.setFont(new Font("courier", Font.BOLD, 20));
		optionsPanel.add(lblMatrixA);

		txtMathA = new JTextPane();
		optionsPanel.add(txtMathA);

		scrollMathA = new JScrollPane(txtMathA);
		scrollMathA.setBounds(10, 40, 380, 80);
		optionsPanel.add(scrollMathA);

		lblMatrixB = new JLabel("Matriz B");
		lblMatrixB.setBounds(10, 170, 380, 40);
		lblMatrixB.setFont(new Font("courier", Font.BOLD, 20));
		optionsPanel.add(lblMatrixB);

		txtMathB = new JTextPane();
		optionsPanel.add(txtMathB);

		scrollMathB = new JScrollPane(txtMathB);
		scrollMathB.setBounds(10, 200, 380, 80);
		optionsPanel.add(scrollMathB);

		btnMath = new JButton("Enviar Matrices");
		btnMath.setFocusable(false);
		btnMath.setBounds(10, 500, 380, 50);
		btnMath.addActionListener(this);
		optionsPanel.add(btnMath);
		add(optionsPanel, BorderLayout.CENTER);

		setVisible(true);
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

	public void max() {
		int MaxColA = a.nColumnas(a.getInicio());
		int MaxColB = b.nColumnas(b.getInicio());
		int MaxFilA = a.nFilas(a.getInicio().getCabeza());
		int MaxFilB = b.nFilas(b.getInicio().getCabeza());
		System.out.println("Matriz A -> MaxCol: " + MaxColA + " MaxFil: " + MaxFilA);
		System.out.println("Matriz B -> MaxCol: " + MaxColB + " MaxFil: " + MaxFilB);
	}

	public void showc() {
		System.out.println("Matriz A");
		a.mostrarlista(a.getInicio());
		System.out.println("Matriz B");
		b.mostrarlista(b.getInicio());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMath) {
			System.out.println("Datos enviados: Calculando...");

			// Get data.
			Validation validate = new Validation();

			String stringMatrixA = getTxtMathA().getText();
			System.out.println(stringMatrixA);
			String[] splitMatrixA = stringMatrixA.split(";");

			String stringMatrixB = getTxtMathB().getText();
			System.out.println(stringMatrixB);
			String[] splitMatrixB = stringMatrixB.split(";");

			// Check data for MatrixA.
			for (int i = 0; i < splitMatrixA.length; i++) {

				if (validate.isValidFormat(splitMatrixA[i]) == false) {
					checkDataMatrixA = false;
					i = splitMatrixA.length;
				} else {
					checkDataMatrixA = true;
				}
			}

			// Check data for MatrixB.
			for (int i = 0; i < splitMatrixB.length; i++) {
				if (validate.isValidFormat(splitMatrixB[i]) == false) {
					checkDataMatrixB = false;
					i = splitMatrixB.length;
				} else {
					checkDataMatrixB = true;
				}
			}
			System.out.println(checkDataMatrixA + " <-Matrix A - Matrix B-> " + checkDataMatrixB);

			// Send data.
			if (checkDataMatrixB && (checkDataMatrixA)) {
				System.out.println("Datos correctos: Calculando...");

				// Send data for MatrixA.
				for (int i = 0; i < splitMatrixA.length; i++) {
					splitMatrixA[i] = splitMatrixA[i].replace("(", "");
					splitMatrixA[i] = splitMatrixA[i].replace(")", "");
					String[] tempValuesMatrixA = splitMatrixA[i].split(",");
					for (int b = 0; b < splitMatrixA.length; b++) {
						System.out.println(splitMatrixA[b]+"---");
					}
									
					// si metemos el crear nodo aca, sera que se rompe?

				}
				
				// Send data for MatrixB.
				for (int i = 0; i < splitMatrixB.length; i++) {
					splitMatrixB[i] = splitMatrixB[i].replace("(", "");
					splitMatrixB[i] = splitMatrixB[i].replace(")", "");
				}
			}
		}
	}

	// Getters, Setters.
	public JPanel getOptionsPanel() {
		return optionsPanel;
	}

	public void setOptionsPanel(JPanel optionsPanel) {
		this.optionsPanel = optionsPanel;
	}

	public JPanel getMathPanel() {
		return mathPanel;
	}

	public void setMathPanel(JPanel mathPanel) {
		this.mathPanel = mathPanel;
	}

	public JButton getBtnMath() {
		return btnMath;
	}

	public void setBtnMath(JButton btnMath) {
		this.btnMath = btnMath;
	}

	public JTextPane getTxtMathA() {
		return txtMathA;
	}

	public void setTxtMathA(JTextPane txtMathA) {
		this.txtMathA = txtMathA;
	}

	public JTextPane getTxtMathB() {
		return txtMathB;
	}

	public void setTxtMathB(JTextPane txtMathB) {
		this.txtMathB = txtMathB;
	}

	public JScrollPane getScrollMathA() {
		return scrollMathA;
	}

	public void setScrollMathA(JScrollPane scrollMathA) {
		this.scrollMathA = scrollMathA;
	}

	public JScrollPane getScrollMathB() {
		return scrollMathB;
	}

	public void setScrollMathB(JScrollPane scrollMathB) {
		this.scrollMathB = scrollMathB;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JLabel getLblMatrixA() {
		return lblMatrixA;
	}

	public void setLblMatrixA(JLabel lblMatrixA) {
		this.lblMatrixA = lblMatrixA;
	}

	public JLabel getLblMatrixB() {
		return lblMatrixB;
	}

	public void setLblMatrixB(JLabel lblMatrixB) {
		this.lblMatrixB = lblMatrixB;
	}
}