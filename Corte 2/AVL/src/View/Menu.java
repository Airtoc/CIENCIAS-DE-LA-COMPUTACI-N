package View;

import Controllers.ArbolAvlController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame {

    private final int ancho, alto;
    private JButton btnInsertar, btnRetirar, btnDibujar, btnInorden, btnBuscarAlumno,btnReset,btnPosorden,btnNivel;
    private JLabel title;
    private JPanel backGroundTitle;

    public Menu() {
        ancho = 600;
        alto = 400;
    }

    private void initComponents() {

        backGroundTitle = new JPanel(null);
        backGroundTitle.setSize(new Dimension(ancho, 60));
        backGroundTitle.setBackground(new Color(35, 39, 42));
        backGroundTitle.setLocation(0, 0);

        title = new JLabel("<html><head><meta charset='UTF-8'></head><body>Arboles AVL</body></html>");
        title.setSize(new Dimension(ancho, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 27));
        title.setLocation(20, (backGroundTitle.getHeight() - title.getHeight()) / 2);
        backGroundTitle.add(title);
        add(backGroundTitle);

        btnInsertar = new JButton("<html><head><meta charset='UTF-8'></head><body>Insertar Estudiante</body></html>");
        btnInsertar.setSize(new Dimension(250, 30));
        btnInsertar.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnInsertar.setLocation(20, 130);
        btnInsertar.setFocusable(false);
        //btnInsertar.setBackground(new Color(176,196,222));
        btnInsertar.setBackground(Color.WHITE);
        add(btnInsertar);

        btnRetirar = new JButton("<html><head><meta charset='UTF-8'></head><body>Retirar Estudiante</body></html>");
        btnRetirar.setSize(new Dimension(250, 30));
        btnRetirar.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnRetirar.setLocation(20, 180);
        btnRetirar.setFocusable(false);
        btnRetirar.setBackground(Color.WHITE);
        add(btnRetirar);

        btnDibujar = new JButton("<html><head><meta charset='UTF-8'></head><body>Dibujar Arbol</body></html>");
        btnDibujar.setSize(new Dimension(250, 30));
        btnDibujar.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnDibujar.setLocation(20, 230);
        btnDibujar.setFocusable(false);
        btnDibujar.setBackground(Color.WHITE);
        add(btnDibujar);
        
        btnNivel = new JButton("<html><head><meta charset='UTF-8'></head><body>Recorrido Niveles</body></html>");
        btnNivel.setSize(new Dimension(250, 30));
        btnNivel.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnNivel.setLocation(20, 280);
        btnNivel.setFocusable(false);
        btnNivel.setBackground(Color.WHITE);
        add(btnNivel);

        btnInorden = new JButton("<html><head><meta charset='UTF-8'></head><body>Recorrido Inorden</body></html>");
        btnInorden.setSize(new Dimension(250, 30));
        btnInorden.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnInorden.setLocation(300, 130);
        btnInorden.setFocusable(false);
        btnInorden.setBackground(Color.WHITE);
        add(btnInorden);
        
        btnPosorden = new JButton("<html><head><meta charset='UTF-8'></head><body>Recorrido Posorden</body></html>");
        btnPosorden.setSize(new Dimension(250, 30));
        btnPosorden.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnPosorden.setLocation(300, 180);
        btnPosorden.setFocusable(false);
        btnPosorden.setBackground(Color.WHITE);
        add(btnPosorden);

        btnBuscarAlumno = new JButton("<html><head><meta charset='UTF-8'></head><body>Buscar Estudiante</body></html>");
        btnBuscarAlumno.setSize(new Dimension(250, 30));
        btnBuscarAlumno.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnBuscarAlumno.setLocation(300, 230);
        btnBuscarAlumno.setFocusable(false);
        btnBuscarAlumno.setBackground(Color.WHITE);
        add(btnBuscarAlumno);
        
        btnReset = new JButton("<html><head><meta charset='UTF-8'></head><body>Limpiar Arbol</body></html>");
        btnReset.setSize(new Dimension(250, 30));
        btnReset.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 20));
        btnReset.setLocation(300, 280);
        btnReset.setFocusable(false);
        btnReset.setBackground(Color.WHITE);
        add(btnReset);
    }

    private void initListeners() {
        btnInsertar.addActionListener((event) -> {
            MenuInsertar menuInsertar = new MenuInsertar();
            menuInsertar.initTemplate();
        });
        
        btnDibujar.addActionListener((event) -> {
            Dibujo dibujo = new Dibujo();
            dibujo.initTemplate();
        });
        
        btnRetirar.addActionListener((event) -> {
            MenuRetirar menu = new MenuRetirar();
            menu.initTemplate();
        });
        
        
        btnInorden.addActionListener((event) -> {
            ArbolAvlController controller = ArbolAvlController.getInstance();
            String[] columns = {"Factor de Balance", "Nombre","Telefono"};
            MenuInorden menu = new MenuInorden();
            menu.initTemplate(controller.showIn(), columns);
        });
        
        btnPosorden.addActionListener((event) -> {
           ArbolAvlController controller = ArbolAvlController.getInstance();
           String[] columns = {"Factor de Balance", "Nombre","Telefono"};
           MenuPosorden menu = new MenuPosorden();
           menu.initTemplate(controller.showPos(), columns);
        });
        
        btnNivel.addActionListener((event) -> {
            ArbolAvlController controller = ArbolAvlController.getInstance();
            String[] columns = {"Balance", "Nombre","Telefono"};
            MenuNiveles menu = new MenuNiveles();
            menu.initTemplate(controller.showNiv(), columns);
        });
        
        btnBuscarAlumno.addActionListener((event) -> {
            MenuBuscar menu = new MenuBuscar();
            menu.initTemplate();
        });
        
        btnReset.addActionListener((event) -> {
            ArbolAvlController controller = ArbolAvlController.getInstance();
            controller.getArbol().setRaiz(null);
            controller.getArbol().setIn(new ArrayList<>());
            JOptionPane.showMessageDialog(null, "La lista de estudiantes se ha limpiado correctamente");
        });
    }

    public void initTempalte() {
        setLayout(null);
        setTitle("Arboles Avl");
        setSize(new Dimension(ancho, alto));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(44, 47, 51));
        initComponents();
        initListeners();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
