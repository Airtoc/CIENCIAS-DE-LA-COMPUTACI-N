package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import Logic.Listas;
import Logic.Nodo;
import java.util.Map;

public class App extends JFrame implements ActionListener {

    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private JLabel lblTitle;
    private JPanel optionsPanel, mainPanel;
    private JScrollPane scrollPanel;
    private JTable table;
    private JButton btnAdd, btnDelete, btnSearch, btnNew, btnShow;
    private String name;
    private int codigo;
    private Listas lista;
    private DefaultTableModel tableModel;
    // --Tipos para manipular el Table.

    public App() {
        setTitle("Listas");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        // setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        // -MainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, 100);
        mainPanel.setBackground(new Color(92, 219, 149));
        add(mainPanel);
        // --ScrollPanel
        scrollPanel = new JScrollPane();
        scrollPanel.setBounds(0, 100, WIDTH / 2, HEIGHT - 100);
        add(scrollPanel);
        // --Table
        String[] columnas = { "Nombre", "Codigo" };
        tableModel = new DefaultTableModel(columnas, 0);
        table = new JTable(tableModel) {
            boolean[] columnEditables = new boolean[] { false, false };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        scrollPanel.setViewportView(table);
        // --Title
        lblTitle = new JLabel("Listas");
        lblTitle.setFont(new Font("consolas", Font.BOLD + Font.ITALIC, 80));
        lblTitle.setForeground(new Color(5, 56, 107));
        mainPanel.add(lblTitle);

        // -OptionsPanel
        optionsPanel = new JPanel(null);
        optionsPanel.setBounds(WIDTH / 2, 100, WIDTH / 2, HEIGHT - 100);
        optionsPanel.setBackground(new Color(92, 219, 149));
        add(optionsPanel);
        // --btnAdd
        btnAdd = new JButton("Agregar Nodo");
        btnAdd.setBounds(10, 0, 365, 30);
        btnAdd.setBackground(new Color(5, 56, 107));
        btnAdd.setForeground(new Color(237, 245, 225));
        btnAdd.setFont(new Font("consolas", Font.BOLD, 20));
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(this);
        optionsPanel.add(btnAdd);
        // --btnDelete
        btnDelete = new JButton("Eliminar Nodo");
        btnDelete.setBounds(10, 40, 365, 30);
        btnDelete.setBackground(new Color(5, 56, 107));
        btnDelete.setForeground(new Color(237, 245, 225));
        btnDelete.setFont(new Font("consolas", Font.BOLD, 20));
        btnDelete.addActionListener(this);
        optionsPanel.add(btnDelete);
        // --btnSearch
        btnSearch = new JButton("Buscar Nodo");
        btnSearch.setBounds(10, 80, 365, 30);
        btnSearch.setBackground(new Color(5, 56, 107));
        btnSearch.setForeground(new Color(237, 245, 225));
        btnSearch.setFont(new Font("consolas", Font.BOLD, 20));
        btnSearch.addActionListener(this);
        optionsPanel.add(btnSearch);
        // --btnNew
        btnNew = new JButton("Nueva Lista");
        btnNew.setBounds(10, 120, 365, 30);
        btnNew.setBackground(new Color(5, 56, 107));
        btnNew.setForeground(new Color(237, 245, 225));
        btnNew.setFont(new Font("consolas", Font.BOLD, 20));
        btnNew.addActionListener(this);
        optionsPanel.add(btnNew);
        // --btnNew
        btnShow = new JButton("Mostrar Lista");
        btnShow.setBounds(10, 160, 365, 30);
        btnShow.setBackground(new Color(5, 56, 107));
        btnShow.setForeground(new Color(237, 245, 225));
        btnShow.setFont(new Font("consolas", Font.BOLD, 20));
        btnShow.addActionListener(this);
        optionsPanel.add(btnShow);
    }

    public void eliminar(){
        int rowCount = tableModel.getRowCount();
            // Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                tableModel.removeRow(i);
            }
    }
    public void imprimir(){
        lista.setLista("");
                lista.mostrarlista(lista.getCabeza());
                Object[] fila = new Object[2];
                Map<String, Integer> a = lista.getMap();
                for (String i : a.keySet()) {
                    fila[0] = i;
                    fila[1] = a.get(i);
                    tableModel.addRow(fila);
                }
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        // --AddEvent
        if (event.getSource() == btnAdd) {
            try {
                name = JOptionPane.showInputDialog(null, "inserte el nombre");
                codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el Codigo"));
                Nodo nodo = new Nodo(codigo, name);
                if (lista.getCabeza() == null) {
                    // si no hay un nodo inicial , se convierte en el primero
                    lista.setCabeza(nodo);
                } else {
                    // Añade el nodo
                    lista.addNodo(nodo, lista.getCabeza());
                    
                }
                eliminar();
                //imprimir();
                JOptionPane.showMessageDialog(null, "Se ha añadido el nodo correctamente");
            } catch (Exception e) {
                System.out.println("La embarramos #001");
                System.out.println(e);
            }
        }
        // --DeleteEvent
        if (event.getSource() == btnDelete) {
            try {
                codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el Codigo"));
                lista.eliminarNodo(lista.getCabeza(), codigo);
                JOptionPane.showMessageDialog(null, "se ha eliminado el nodo de la lista");
                eliminar();
                imprimir();
                tableModel.fireTableDataChanged();
                System.out.println("cambios hechos");
                
            } catch (Exception e) {
                System.out.println("La embarramos #002");
            }
        }
        // --SearchEvent
        if (event.getSource() == btnSearch) {
            try {
                codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el Codigo a buscar"));
                lista.buscarNodo(lista.getCabeza(), codigo);
            } catch (Exception e) {
                System.out.println("La embarramos #003");
            }
        }
        // --NewEvent
        if (event.getSource() == btnNew) {
            eliminar();
            try {
                lista = new Listas();
                JOptionPane.showMessageDialog(null, "Se ha creado una lista vacia");
            } catch (Exception e) {
                System.out.println("La embarramos #004");
            }
        }
        // --ShowEvent
        if (event.getSource() == btnShow) {
            try {
                eliminar();
                imprimir();

            } catch (Exception e) {
                System.out.println("La embarramos #004");
            }
        }
    }

}