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
	private JButton btnMath, btnShow, btnClean;
	private JTextPane txtMathA, txtMathB, txtMathProductAB;
	private JScrollPane scrollMathA, scrollMathB, scrollMathAB;
	private JLabel lblTitle, lblMatrixA, lblMatrixB;
	private boolean checkDataMatrixA, checkDataMatrixB = false;
	private Matriz a, b, r;
	private int MaxColA, MaxColB, MaxFilA, MaxFilB;

	public Window(String title) {
		a = new Matriz("a");
		b = new Matriz("b");
		r = new Matriz("resultado");
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

		lblMatrixA = new JLabel("Matriz A (Fila, Columna, Valor)");
		lblMatrixA.setBounds(10, 10, 380, 40);
		lblMatrixA.setFont(new Font("courier", Font.BOLD, 20));
		optionsPanel.add(lblMatrixA);

		txtMathA = new JTextPane();
		optionsPanel.add(txtMathA);

		scrollMathA = new JScrollPane(txtMathA);
		scrollMathA.setBounds(10, 40, 380, 80);
		optionsPanel.add(scrollMathA);

		lblMatrixB = new JLabel("Matriz B (Fila, Columna, Valor)");
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

		btnShow = new JButton("Imprimir");
		btnShow.setFocusable(false);
		btnShow.setBounds(380, 500, 380, 50);
		btnShow.addActionListener(this);
		optionsPanel.add(btnShow);

		txtMathProductAB = new JTextPane();
		optionsPanel.add(txtMathProductAB);

		scrollMathAB = new JScrollPane(txtMathProductAB);
		scrollMathAB.setBounds(400, 10, 380, 480);
		optionsPanel.add(scrollMathAB);

		add(optionsPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public void cleanData() {
		a = new Matriz("a");
		b = new Matriz("b");
		r = new Matriz("r");
		txtMathA.setText("");
		txtMathB.setText("");
		txtMathProductAB.setText("");
	}

	public void addA(int fila, int columna, int valor) {

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

	public void addB(int fila, int columna, int valor) {

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

	public void addResultado(int fila, int columna, int valor) {

		NodoColumna col = new NodoColumna(columna);
		NodoFila fil = new NodoFila(fila, valor);

		if (r.getInicio() == null) {
			// si no hay un nodo inicial , se convierte en el primero
			r.setInicio(col);
			col.setCabeza(fil);
		} else {
			// Añade el nodo
			r.addNodoColumna(col, r.getInicio(), fil);

		}

	}

	public void max() {
		MaxColA = a.nColumnas(a.getInicio());
		MaxColB = b.nColumnas(b.getInicio());
		MaxFilA = a.nFilas(a.getInicio().getCabeza());
		MaxFilB = b.nFilas(b.getInicio().getCabeza());
		System.out.println("Matriz A -> MaxCol: " + MaxColA + " MaxFil: " + MaxFilA);
		System.out.println("Matriz B -> MaxCol: " + MaxColB + " MaxFil: " + MaxFilB);
	}

	public void showData() {
		a.mostrarlista(a.getInicio());
		b.mostrarlista(b.getInicio());
		r.mostrarlista(r.getInicio());
		txtMathProductAB.setText("Matriz A: \n" + a.getListaString() + "\n Matriz B: \n" + b.getListaString()
				+ "\n Matriz A*B" + ": \n" + r.getListaString());
	}

	public void enviarMatriz() {
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

				boolean aux = false;
				while (aux != true) {
					// Fila,columna,valor
					addA(Integer.parseInt(tempValuesMatrixA[1]), Integer.parseInt(tempValuesMatrixA[0]),
							Integer.parseInt(tempValuesMatrixA[2]));
					aux = true;
				}
				// si metemos el crear nodo aca, sera que se rompe? // R: Ya vamos a ver
			}

			// Send data for MatrixB.
			for (int i = 0; i < splitMatrixB.length; i++) {
				splitMatrixB[i] = splitMatrixB[i].replace("(", "");
				splitMatrixB[i] = splitMatrixB[i].replace(")", "");
				String[] tempValuesMatrixB = splitMatrixB[i].split(",");
				boolean aux = false;
				while (aux != true) {
					// Fila,columna,valor
					addB(Integer.parseInt(tempValuesMatrixB[1]), Integer.parseInt(tempValuesMatrixB[0]),
							Integer.parseInt(tempValuesMatrixB[2]));
					aux = true;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMath) {
			enviarMatriz();
			max();
			if (MaxColA == MaxFilB) {
				/*
				 * 2x3-3x2->2x2 fila-columna columnas A = filas B
				 */
				NodoColumna inicioColB = b.getInicio();
				NodoFila inicioFilB = inicioColB.getCabeza();// Fila 1B
				NodoColumna inicioColA = a.getInicio();// Columna 1A
				NodoFila inicioFilA = inicioColB.getCabeza();// Fila 1B
				NodoFila auxA = a.getInicio().getCabeza();
				NodoColumna columna2 = a.getInicio();
				NodoFila fila2 = a.getInicio().getCabeza();
				System.out.println(MaxColA + "--" + MaxColB);

					System.out.println("Hola");
					int fila = 0;
					int columna = 0;
					int valor = 0;
					//r21-r22
					while (auxA != null) {
						inicioColB = b.getInicio();
						inicioFilB = inicioColB.getCabeza();
						inicioColA = a.getInicio();
						inicioFilA = inicioColB.getCabeza();
						//r11-r12
						while (inicioColB != null) {
							columna = inicioColA.getCol();
							fila = inicioFilB.getFila();
							valor = r.multiplicar(inicioColA, inicioFilB);
							System.out.println("fila: " + fila2.getFila() + " Columna: " + columna2.getCol() + " Valor: " + valor+"\n");
							addResultado(fila2.getFila(), columna2.getCol(), valor);
							
							System.out.println("Valor de a2: " + inicioColA.getCabeza().getValor());
							r.setVal(0);//reset val r
							
							inicioColB = inicioColB.getSiguiente();
							if(inicioColB!=null) {
								inicioFilB = inicioColB.getCabeza();
								columna2 = inicioColA.getSiguiente();
								/*if(r.getItr()>=1) {
									fila2 = inicioFilA.getAbajo();
								}*/
								
							}								
						}
						//Baja una fila 
						
						r.setItr(r.getItr() + 1);	
						fila2 = inicioFilA.getAbajo();
						columna2 = a.getInicio();
						//fila2 = a.getInicio().getCabeza();
						auxA = auxA.getAbajo();
					}

				/*
				 * int columna = a2.getCol() ; int fila = b1.getFila(); int valor =
				 * r.multiplicar(a2,b1); addResultado(columna,fila,valor);
				 */

			} else {
				JOptionPane.showMessageDialog(null, "Los tamaños de las matrices no son compatibles");
			}

			// Show the information in Sout.
		} else if (e.getSource() == btnShow) {
			// TODO
			// showc();
			showData();

		} else if (e.getSource() == btnClean) {
			// TODO
			cleanData();
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

	public JTextPane getTxtMathProductAB() {
		return txtMathProductAB;
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