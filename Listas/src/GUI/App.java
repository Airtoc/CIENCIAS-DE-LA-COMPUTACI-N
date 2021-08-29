package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Logic.Listas;
import Logic.Nodo;;

public class App extends JFrame implements ActionListener {

    private static int WIDTH = 1200;
    private static int HEIGHT = 900;
    private JLabel lblTitle;
    private JPanel optionsPanel, mainPanel;
    private JScrollPane scrollPanel;
    private JTable table;
    private JButton btnAdd, btnDelete, btnEdit, btnClean;
    private String name;
    private int codigo;
    private Listas lista;
    // --Tipos para manipular el Table.
    private String[] columnNames;
    private Object[][] data;
    
    public App() {
        setTitle("Listas");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents (){
        // -MainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, 100);
        mainPanel.setBackground(new Color(92, 219, 149));
        add(mainPanel);
            // --Table
        columnNames = {
            "Código",
            "Nombre"
        };
        
        table = new JTable();
            // --ScrollPanel
        scrollPanel = new JScrollPanel();

        // -OptionsPanel
        optionsPanel = new JPanel(null);
        optionsPanel.setBounds(WIDTH/2, 100, (WIDTH/2)-200, HEIGHT-100);
        optionsPanel.setBackground(new Color(92, 219, 149));
            // --btnAdd
        btnAdd = new JButton("Agregar Nodo");
        btnAdd.setBounds(x, y, width, height);
        btnAdd.setBackground(new Color(5, 56, 107));
        btnAdd.setForeground(new Color(237 ,245 ,225));
        optionsPanel.add(btnAdd);
            // --btnDelete
        btnDelete = new JButon("Eliminar Nodo");
        btnDelete.setBounds(x, y, w, h);
        btnDelete.setBackground(new Color(5, 56, 107));
        btnDelete.setForeground(new Color(237 ,245 ,225));
        optionsPanel.add(btnDelete);
            // --btnEdit
        btnEdit = new JButton("Buscar Nodo");
        btnEdit.setBounds(x, y, w, h);
        btnEdit.setBackground(new Color(5, 56, 107));
        btnEdit.setForeground(new Color(237 ,245 ,225));
        optionsPanel.add(btnEdit);
            // --btnClean
        btnClean = new JButton("Limpiar");
        btnClean.setBounds(x, y, w, h);
        btnClean.setBackground(new Color(5, 56, 107));
        btnClean.setForeground(new Color(237 ,245 ,225));
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