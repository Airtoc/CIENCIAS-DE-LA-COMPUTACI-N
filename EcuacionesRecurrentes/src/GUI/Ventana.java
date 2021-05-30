
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener{
    private JLabel titulo,descripcion;
    private JButton generarC, calcular;
    private JTextField grado;
    private Expresion panel;
    
    public Ventana(){
        titulo = new JLabel("Ecuaciones de Recurrencia");
        descripcion = new JLabel("Inserte el grado del polinomio:");
        grado = new JTextField();
        generarC = new JButton("Generar campos");
        calcular  = new JButton("Calcular");
  
    }
    
    public void initComponents(){
        titulo.setSize(new Dimension(800, 40));
        titulo.setLocation(250,20);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        add(titulo);
        
        descripcion.setSize(new Dimension(800,20));
        descripcion.setLocation(10, 90);
        descripcion.setFont(new Font("Arial", Font.PLAIN,20));
        add(descripcion);
        
        grado.setSize(new Dimension(70,20));
        grado.setLocation(10, 120);
        add(grado);
        
        generarC.setSize(150,30);
        generarC.setLocation(100,120);
        generarC.addActionListener(this);
        add(generarC);
                
    }
    
    public void initTemplate() {
        setLayout(null);
        setTitle("Recurrencia");
        setSize(new Dimension(800, 500));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
         if (event.getSource() == generarC) {

            try{
                int n = Integer.parseInt(grado.getText());
                panel = new Expresion(n);
                panel.initInputElements();
                //panel.setOpaque(true);
                //panel.setBackground(Color.red);
                panel.setSize(new Dimension(700, 290));
                panel.setLocation(10, 160);
                //panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                add(panel);
                repaint();
            }catch(NumberFormatException  e){
                JOptionPane.showMessageDialog(null, "Por favor ingrese un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    }
    
}
