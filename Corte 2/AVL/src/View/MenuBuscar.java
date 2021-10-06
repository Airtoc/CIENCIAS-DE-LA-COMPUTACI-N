package View;

import Controllers.ArbolAvlController;
import Models.Estudiante;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class MenuBuscar extends JFrame {
    
    private final int ancho,alto;
    private JLabel lblTelefono,lblFinal;
    private JTextField inputTelefono;
    private ArbolAvlController controller;
    private JButton btnBuscar,btnEstado;
    
    public MenuBuscar(){
        ancho =500;
        alto=300;
        controller = ArbolAvlController.getInstance();
    }
    
    public void initComponents(){
        lblTelefono = new JLabel("Telefono: ");
        lblTelefono.setSize(new Dimension(200,30));
        lblTelefono.setLocation(100,25);
        lblTelefono.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        lblTelefono.setForeground(Color.WHITE);
        add(lblTelefono);
        
        inputTelefono = new JTextField();
        inputTelefono.setSize(new Dimension(150,20));
        inputTelefono.setLocation(200,30);
        inputTelefono.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        add(inputTelefono);
        
        lblFinal = new JLabel();
        lblFinal.setSize(new Dimension(450,100));
        lblFinal.setLocation((getWidth()-lblFinal.getWidth())/4,100);
        lblFinal.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        lblFinal.setHorizontalAlignment(JLabel.CENTER);
        lblFinal.setForeground(Color.WHITE);
        lblFinal.setBorder(BorderFactory.createLineBorder(Color.black));
        add(lblFinal);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(new Dimension(180,30));
        btnBuscar.setLocation(20,220);
        btnBuscar.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        add(btnBuscar);
        
        btnEstado = new JButton("Cambiar Estado");
        btnEstado.setSize(new Dimension(200,30));
        btnEstado.setLocation(220,220);
        btnEstado.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        add(btnEstado);
        
        
    }
    
    
    public void initListeners(){
        btnBuscar.addActionListener((event) -> {
            try {
                Estudiante estudiante = controller.getEstudiante(Long.parseLong(inputTelefono.getText()));
                lblFinal.setText("<html><body><p>Nombre: "+estudiante.getNombre()+"<br> Telefono: "+estudiante.getTelefono()+"<br> Estado: "+ estudiante.getSestado()+"</body></html>");
                repaint();
            } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            } catch( NullPointerException e){
               JOptionPane.showMessageDialog(null, "Estudiante no encontrado","Error",JOptionPane.WARNING_MESSAGE);
            } 
        });
        
        btnEstado.addActionListener((event) -> {
            try{
                Estudiante estudiante = controller.getEstudiante(Long.parseLong(inputTelefono.getText()));
                if(estudiante.getEstado() ==false){
                    estudiante.setEstado(true);
                }else{
                    estudiante.setEstado(false);
                }
                JOptionPane.showMessageDialog(null, "Se ha cambiado satisfactoriamente el estado del estudiante");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            } catch( NullPointerException e){
               JOptionPane.showMessageDialog(null, "Estudiante no encontrado","Error",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    public void initTemplate() {
        setLayout(null);
        setTitle("Info Estudiante");
        setSize(new Dimension(ancho, alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(44, 47, 51));
        initComponents();
        initListeners();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
}
