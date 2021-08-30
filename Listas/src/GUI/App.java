package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import Logic.Listas;
import Logic.Nodo;;

public class App extends JFrame implements ActionListener {

    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private JLabel lblTitle;
    private JPanel optionsPanel, mainPanel;
    private JScrollPane scrollPanel;
    private JTable table;
    private JButton btnAdd, btnDelete, btnEdit, btnClean;
    private String name;
    private int codigo;
    private Listas lista;
    // --Tipos para manipular el Table.
    
    
    public App() {
        setTitle("Listas");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        //setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents (){
        // -MainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, 100);
        mainPanel.setBackground(new Color(92, 219, 149));
        add(mainPanel);
            // --ScrollPanel
        scrollPanel = new JScrollPane();
        scrollPanel.setBounds(0, 100, WIDTH/2, HEIGHT-100);
        add(scrollPanel);
            // --Table
        String[] columnas = { "Código", "Nombre"};
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        table = new JTable(tableModel) {
           boolean[] columnEditables = new boolean[] { false, false };
    
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        scrollPanel.setViewportView(table);
            // --Title
        lblTitle = new JLabel ("Listas");
        lblTitle.setFont(new Font("consolas", Font.BOLD + Font.ITALIC, 80));
        lblTitle.setForeground(new Color(5, 56, 107));
        mainPanel.add(lblTitle);

        // -OptionsPanel
        optionsPanel = new JPanel(null);
        optionsPanel.setBounds(WIDTH/2, 100, WIDTH/2, HEIGHT-100);
        optionsPanel.setBackground(new Color(92, 219, 149));
        add(optionsPanel);
            // --btnAdd
        btnAdd = new JButton("Agregar Nodo");
        btnAdd.setBounds(10, 0, 365, 30);
        btnAdd.setBackground(new Color(5, 56, 107));
        btnAdd.setForeground(new Color(237 ,245 ,225));
        btnAdd.setFont(new Font("consolas", Font.BOLD, 20));
        btnAdd.setFocusable(false);
        optionsPanel.add(btnAdd);
            // --btnDelete
        btnDelete = new JButton("Eliminar Nodo");
        btnDelete.setBounds(10, 40, 365, 30);
        btnDelete.setBackground(new Color(5, 56, 107));
        btnDelete.setForeground(new Color(237 ,245 ,225));
        btnDelete.setFont(new Font("consolas", Font.BOLD, 20));
        optionsPanel.add(btnDelete);
            // --btnEdit
        btnEdit = new JButton("Buscar Nodo");
        btnEdit.setBounds(10, 80, 365, 30);
        btnEdit.setBackground(new Color(5, 56, 107));
        btnEdit.setForeground(new Color(237 ,245 ,225));
        btnEdit.setFont(new Font("consolas", Font.BOLD, 20));
        optionsPanel.add(btnEdit);
            // --btnClean
        btnClean = new JButton("Limpiar");
        btnClean.setBounds(10, 120, 365, 30);
        btnClean.setBackground(new Color(5, 56, 107));
        btnClean.setForeground(new Color(237 ,245 ,225));
        btnClean.setFont(new Font("consolas", Font.BOLD, 20));
        optionsPanel.add(btnClean);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // --AddEvent
        if(event.getSource() == btnAdd){
            try {
                String nombre = JOptionPane.showInputDialog(null, "inserte el nombre");
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "inserte el Codigo"));
                Nodo nodo = new Nodo(codigo,nombre);
                if(lista.getCabeza() == null){
                    //si no hay un nodo inicial , se convierte en el primero
                    lista.setCabeza(nodo);
                }else{
                    //Añade el nodo
                    lista.addNodo(nodo, lista.getCabeza());
                }

            } catch (Exception e) {
                System.out.println("La embarramos #001");
            }
        }
        // --DeleteEvent
        if(event.getSource() == btnDelete){
            try {
                
            } catch (Exception e) {
                System.out.println("La embarramos #002");
            }
        }
        // --EditEvent
        if(event.getSource() == btnEdit){
            try {
                
            } catch (Exception e) {
                System.out.println("La embarramos #003");
            }
        }
        // --CleanEvent
        if(event.getSource() == btnClean){
            try {
                lista = new Listas();
            } catch (Exception e) {
                System.out.println("La embarramos #004");
            }
        }
    }

}