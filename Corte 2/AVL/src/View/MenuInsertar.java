package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Controllers.ArbolAvlController;

public class MenuInsertar extends JFrame {
    
    private final int ancho,alto;
    private JTextField inputNombre,inputCodigo;
    private JLabel txtNombre,txtCodigo,title;
    private JButton btnCreate;
    private ArbolAvlController controller;
    
    public MenuInsertar(){
        ancho = 600;
        alto = 400;
        controller = ArbolAvlController.getInstance();
    }
    
    
    private void initComponents(){
        title = new JLabel("<html><head><meta charset='UTF-8'></head><body>Añadir estudiante</body></html>");
        title.setSize(new Dimension(ancho,30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 27));
        title.setForeground(Color.WHITE);
        title.setLocation((getWidth()-title.getWidth())/2, 10);
        add(title);
        
        txtNombre = new JLabel("<html><head><meta charset='UTF-8'></head><body>Nombre: </body></html>");
        txtNombre.setSize(new Dimension(200,30));
        txtNombre.setHorizontalAlignment(JLabel.CENTER);
        txtNombre.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 25));
        txtNombre.setForeground(Color.WHITE);
        txtNombre.setLocation((getWidth()-txtNombre.getWidth())/2-160, 95);
        add(txtNombre);
        
        txtCodigo = new JLabel("<html><head><meta charset='UTF-8'></head><body>Telefono: </body></html>");
        txtCodigo.setSize(new Dimension(200,30));
        txtCodigo.setHorizontalAlignment(JLabel.CENTER);
        txtCodigo.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 25));
        txtCodigo.setForeground(Color.WHITE);
        txtCodigo.setLocation((getWidth()-txtCodigo.getWidth())/2-160, 195);
        add(txtCodigo);
        
        inputNombre = new JTextField();
        inputNombre.setSize(new Dimension(300,30));
        inputNombre.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 25));
        inputNombre.setLocation((getWidth()-inputNombre.getWidth())/2+50, 100);
        add(inputNombre);
        
        inputCodigo = new JTextField();
        inputCodigo.setSize(new Dimension(300,30));
        inputCodigo.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 25));
        inputCodigo.setLocation((getWidth()-inputNombre.getWidth())/2+50, 200);
        add(inputCodigo);
        
        btnCreate = new JButton("<html><head><meta charset='UTF-8'></head><body>Crear estudiante</body></html>");
        btnCreate.setSize(new Dimension(300,30));
        btnCreate.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnCreate.setLocation((getWidth()-btnCreate.getWidth())/2, 300);
        btnCreate.setFocusable(false);
        btnCreate.setBackground(Color.WHITE);
        add(btnCreate);
    }
    
    private void initListeners(){
        btnCreate.addActionListener((event) -> {
            try{
                String nombre = inputNombre.getText();
                long codigo = Long.parseLong(inputCodigo.getText());
                
                if(codigo < 0){
                    throw  new NullPointerException("Telefono erroneos");
                }
                
                controller.add(nombre, codigo);
                inputCodigo.setText("");
                inputNombre.setText("");
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            }catch(Exception a){
                JOptionPane.showMessageDialog(null, a.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    public void initTemplate(){
        setLayout(null);
        setTitle("Insertar estudiante");
        setSize(new Dimension(ancho,alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //getContentPane().setBackground(new Color(245,255,250));
        getContentPane().setBackground(new Color(44, 47, 51));
        initComponents();
        initListeners();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
    }
    
}
