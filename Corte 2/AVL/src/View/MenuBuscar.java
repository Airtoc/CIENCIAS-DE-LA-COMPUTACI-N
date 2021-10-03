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
    private JLabel lblCodigo,lblFinal;
    private JTextField inputCodigo;
    private ArbolAvlController controller;
    private JButton btnBuscar;
    
    public MenuBuscar(){
        ancho =400;
        alto=300;
        controller = ArbolAvlController.getInstance();
    }
    
    public void initComponents(){
        lblCodigo = new JLabel("Telefono: ");
        lblCodigo.setSize(new Dimension(200,30));
        lblCodigo.setLocation(100,25);
        lblCodigo.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        lblCodigo.setForeground(Color.WHITE);
        add(lblCodigo);
        
        inputCodigo = new JTextField();
        inputCodigo.setSize(new Dimension(150,20));
        inputCodigo.setLocation(200,30);
        inputCodigo.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        add(inputCodigo);
        
        lblFinal = new JLabel();
        lblFinal.setSize(new Dimension(350,100));
        lblFinal.setLocation((getWidth()-lblFinal.getWidth())/2,100);
        lblFinal.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        lblFinal.setHorizontalAlignment(JLabel.CENTER);
        lblFinal.setForeground(Color.WHITE);
        lblFinal.setBorder(BorderFactory.createLineBorder(Color.black));
        add(lblFinal);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(new Dimension(200,30));
        btnBuscar.setLocation((getWidth()-btnBuscar.getWidth())/2,220);
        btnBuscar.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 20));
        add(btnBuscar);
        
        
    }
    
    
    public void initListeners(){
        btnBuscar.addActionListener((event) -> {
            try {
                Estudiante estudiante = controller.getEstudiante(Long.parseLong(inputCodigo.getText()));
                lblFinal.setText("<html><body><p>Nombre: "+estudiante.getNombre()+"</body></html>");
                repaint();
            } catch (NumberFormatException ex) {
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
