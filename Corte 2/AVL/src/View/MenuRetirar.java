package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import Controllers.ArbolAvlController;
import javax.swing.JOptionPane;

public class MenuRetirar extends JFrame {
    
     private final int ancho,alto;
     private JButton btnEliminar;
     private JTextField inputCodigo;
     private JLabel lblCodigo;
     private ArbolAvlController controller;
    
     public MenuRetirar(){
        ancho = 320;
        alto=200;
        controller = ArbolAvlController.getInstance();
    }
    
    
    private void initComponents(){
        
        lblCodigo = new JLabel("Codigo: ");
        lblCodigo.setSize(new Dimension(200,30));
        lblCodigo.setLocation((getWidth()-lblCodigo.getWidth())/2-50,25);
        lblCodigo.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        lblCodigo.setForeground(Color.WHITE);
        add(lblCodigo);
        
        inputCodigo = new JTextField();
        inputCodigo.setSize(new Dimension(150,30));
        inputCodigo.setLocation((getWidth()-inputCodigo.getWidth())/2+50,30);
        inputCodigo.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 25));
        add(inputCodigo);
        
        btnEliminar = new JButton("<html><head><meta charset='UTF-8'></head><body>Eliminar estudiante</body></html>");
        btnEliminar.setSize(new Dimension(300,30));
        btnEliminar.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnEliminar.setLocation((getWidth()-btnEliminar.getWidth())/2, 100);
        btnEliminar.setFocusable(false);
        btnEliminar.setBackground(Color.WHITE);
        add(btnEliminar);
    }
    
    private void initListeners(){
        btnEliminar.addActionListener((event) -> {
            try{
                controller.remove(Long.valueOf(inputCodigo.getText()));
                dispose();
            }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    public void initTemplate(){
        setLayout(null);
        setTitle("Eliminar estudiante");
        setSize(new Dimension(ancho,alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(44, 47, 51));
        initComponents();
        initListeners();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
    }
    
}
