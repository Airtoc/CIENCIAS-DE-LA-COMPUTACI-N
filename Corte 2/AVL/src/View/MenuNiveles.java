package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MenuNiveles extends JFrame {
    
    public final int ancho,alto;
    private JTable table;
    
    public MenuNiveles(){
        ancho = 400;
        alto = 400;
    }
    
    private void initComponents(String[][] rows,String[] colums){
        table = new JTable(rows, colums);
        table.setSize(new Dimension(1000,1000));
        
        JScrollPane jsp = new JScrollPane(table);
        
        jsp.setSize(new Dimension(ancho, alto-35));
        jsp.setLocation(0, 0);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp);
        jsp.updateUI();
        
    }
    
    public void initTemplate(String[][] rows,String[] colums){
        setLayout(null);
        setTitle("Niveles");
        setSize(new Dimension(ancho,alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(44, 47, 51));
        initComponents(rows,colums);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
    }
    
}
