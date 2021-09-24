package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Logic.Node;
import Logic.Tree;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frmReforestar;
	private JTextField txtPreorder1;
	private JTextField txtInorder1;
	private JTextField txtInorder2;
	private JTextField txtPosOrder1;
	private Tree a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmReforestar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		a = new Tree();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReforestar = new JFrame();
		frmReforestar.setTitle("Reforestar");
		frmReforestar.setBounds(100, 100, 894, 462);
		frmReforestar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmReforestar.getContentPane().setLayout(springLayout);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		springLayout.putConstraint(SpringLayout.NORTH, dataPanel, 0, SpringLayout.NORTH,
				frmReforestar.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dataPanel, 0, SpringLayout.WEST, frmReforestar.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dataPanel, 0, SpringLayout.SOUTH,
				frmReforestar.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dataPanel, 409, SpringLayout.WEST,
				frmReforestar.getContentPane());
		frmReforestar.getContentPane().add(dataPanel);

		JPanel graphPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, graphPanel, 0, SpringLayout.NORTH,
				frmReforestar.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, graphPanel, 6, SpringLayout.EAST, dataPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, graphPanel, 0, SpringLayout.SOUTH, dataPanel);
		springLayout.putConstraint(SpringLayout.EAST, graphPanel, -10, SpringLayout.EAST,
				frmReforestar.getContentPane());
		graphPanel.setToolTipText("Grafica");
		graphPanel.setBorder(new TitledBorder(null, "Grafica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reconstruccion de Arboles");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 310, 29);
		dataPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Preorder e Inorder");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 61, 140, 14);
		dataPanel.add(lblNewLabel_1);

		txtPreorder1 = new JTextField();
		txtPreorder1.setBounds(10, 110, 300, 20);
		dataPanel.add(txtPreorder1);
		txtPreorder1.setColumns(10);

		txtInorder1 = new JTextField();
		txtInorder1.setColumns(10);
		txtInorder1.setBounds(10, 165, 300, 20);
		dataPanel.add(txtInorder1);

		JButton btnPreIn = new JButton("Reconstruir");
		btnPreIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Action listener 1
				String[] pre = txtPreorder1.getText().split("");
				String[] ino = txtInorder1.getText().split("");
				// Verificaciones
				if (ino.length == pre.length) {
					boolean rep = false;
					for (int i = 0; i < ino.length - 1; i++) {
						String caracterIn = ino[i];
						String caracterPos = pre[i];
						for (int j = i + 1; j < ino.length; j++) {
							if (ino[j].equals(caracterIn) || pre[j].equals(caracterPos)) {
								rep = true;
							}
						}
					}
					if (!rep) {
						if (igualdad(pre,ino) == false) {
							JOptionPane.showMessageDialog(null, "Los arboles no coinciden");
						} else {
							 if(ino[0].equals(pre[pre.length-1]) && ino[ino.length-1].equals(pre[0])){
				                    JOptionPane.showMessageDialog(null,"Los arboles no coinciden");
				                }else{
							// Inicio
							Node nodo = new Node(pre[0]);
							if (a.getRaizT() == null) {
								// si no hay un nodo inicial , se convierte en el primero
								a.setRaizT(nodo);
								a.setPre(pre);
								a.setIno(ino);
								a.subCadenaDer(ino, pre[0], a.getRaizT());
								a.subCadenaIzq(ino, pre[0], a.getRaizT());
								if (a.getRaizT().getBizq() == null) {
									a.addDer(a.getRaizT(), a.getRaizT().getBder());
								} else {
									a.addIzq(a.getRaizT(), a.getRaizT().getBizq());
								}
							} else {
							}
							// Graficar
							Canvas can = new Canvas();
							graphPanel.add(can);
							ControladorGraph obj = new ControladorGraph(can, a);
							obj.iniciar();
							graphPanel.repaint();
							JFrame ventana = new JFrame();
					        ventana.getContentPane().add(can);
					        ventana.setSize(600, 600);
					        ventana.setVisible(true);
					        ventana.setLocationRelativeTo(null);
						}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Letras repetidas");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tamaños incorrectos.");
				}
			}
		});
		btnPreIn.setBounds(266, 196, 133, 23);
		dataPanel.add(btnPreIn);

		JLabel lblNewLabel_2 = new JLabel("Cadena Preorder");
		lblNewLabel_2.setBounds(10, 86, 140, 14);
		dataPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Cadena Inorder");
		lblNewLabel_2_1.setBounds(10, 141, 170, 14);
		dataPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Inorder y Posorder");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 233, 140, 14);
		dataPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Cadena Inorder");
		lblNewLabel_2_2.setBounds(10, 258, 170, 14);
		dataPanel.add(lblNewLabel_2_2);

		txtInorder2 = new JTextField();
		txtInorder2.setColumns(10);
		txtInorder2.setBounds(10, 282, 300, 20);
		dataPanel.add(txtInorder2);

		JLabel lblNewLabel_2_1_1 = new JLabel("Cadena Posorder");
		lblNewLabel_2_1_1.setBounds(10, 313, 105, 14);
		dataPanel.add(lblNewLabel_2_1_1);

		txtPosOrder1 = new JTextField();
		txtPosOrder1.setColumns(10);
		txtPosOrder1.setBounds(10, 337, 300, 20);
		dataPanel.add(txtPosOrder1);

		JButton btnInPos = new JButton("Reconstruir");
		btnInPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Actionlistener2
				String[] ino = txtInorder2.getText().split("");
				String[] pos = txtPosOrder1.getText().split("");
				// Verificaciones
				if (ino.length == pos.length) {
					boolean rep = false;
					for (int i = 0; i < ino.length - 1; i++) {
						String caracterIn = ino[i];
						String caracterPos = pos[i];
						for (int j = i + 1; j < ino.length; j++) {
							if (ino[j].equals(caracterIn) || pos[j].equals(caracterPos)) {
								rep = true;
							}
						}
					}
					if (!rep) {
						if (igualdad(pos,ino) == false) {
							JOptionPane.showMessageDialog(null, "Los arboles no coinciden");
						} else {
							// Inicio
							if(ino[0].equals(pos[pos.length-1]) && ino[ino.length-1].equals(pos[0])){
			                    JOptionPane.showMessageDialog(null,"Los arboles no coinciden");
			                }else{
							Node nodo = new Node(pos[pos.length - 1]);
							if (a.getRaizT() == null) {
								a.setRaizT(nodo);
								a.setPos(pos);
								a.setIno(ino);
								a.subCadenaDer(ino, pos[pos.length - 1], a.getRaizT());
								a.subCadenaIzq(ino, pos[pos.length - 1], a.getRaizT());
								a.setJ(pos.length - 2);
								if (a.getRaizT().getBder() == null) {
									a.addIzqN(a.getRaizT(), a.getRaizT().getBizq());
								} else {
									a.addDerN(a.getRaizT(), a.getRaizT().getBder());
								}
							}
							// Graficar
							Canvas can = new Canvas();
                            graphPanel.add(can);
                            ControladorGraph obj = new ControladorGraph(can, a);
                            obj.iniciar();
                            graphPanel.repaint();	
                            JFrame ventana = new JFrame();
					        ventana.getContentPane().add(can);
					        ventana.setSize(600, 600);
					        ventana.setVisible(true);
					        ventana.setLocationRelativeTo(null);
                            }
							}

					} else {
						JOptionPane.showMessageDialog(null, "Letras repetidas");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tamaños incorrectos.");
				}

			}
		});
		btnInPos.setBounds(266, 368, 133, 23);
		dataPanel.add(btnInPos);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tree b = new Tree();
				a = b;
			}
		});
		btnLimpiar.setBounds(310, 243, 89, 23);
		dataPanel.add(btnLimpiar);
		frmReforestar.getContentPane().add(graphPanel);
	}
	public Boolean igualdad(String[] uno, String[] dos) {
		  List<String> list = Arrays.asList(uno);
		  List<String> list2 = Arrays.asList(dos);
		  if(list.containsAll(list2) && list2.containsAll(list)) {
			  return true;
		  }else {
			  return false;
		  }
	}
}
