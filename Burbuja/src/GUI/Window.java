package GUI;

import java.awt.Color;
import java.util.ArrayList;
import Models.Burbuja;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

import Models.Burbuja;

public class Window extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnGraph;
    private JButton btnRespuesta;
    private JPanel graphPanel;
    private Graph graficador = new Graph("Ecuacion Complejidad Matrices", "complex", "variable");

    public Window() {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        

        contentPane = new JPanel(null);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.setSize(300, 1000);
        contentPane.setLocation(0, 0);
        add(contentPane);

        // Componentes
        //? ? Tratemos de usar variables con nombres así claros, lo siento xd es que a veces me atrofio
        // cuando veo variables tipo btnXda2  ya esta libre? ya acabo in gles
        // ok
        btnGraph = new JButton("Ver Graficas");
        btnGraph.setFocusable(false);
        btnGraph.setSize(250, 30);
        btnGraph.setLocation((contentPane.getWidth() - btnGraph.getWidth()) / 2, 100);

        btnGraph.addActionListener((event) -> {
            //obtener valores cota superior
            ArrayList<Double> x = new ArrayList<>(),y = new ArrayList<>();
            for(double i = 0; i< 100;i++){
                x.add(i);
                y.add(24*Math.pow(i, 3));
            }
            graficador.agregarGrafica("Superior-Peor tiempo", x, y);
           
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add((13*Math.pow(i, 3)+4*Math.pow(i, 2)+4*i+3));
            }
            graficador.agregarGrafica("Formula base", x, y);
            
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add(4.8*Math.pow(i, 3));
            }
            graficador.agregarGrafica("Inferior-Mejor tiempo", x, y);
            
            repaint();
            //Peor caso
            //Mejor Caso
        });

        contentPane.add(btnGraph);

        btnRespuesta = new JButton("Operaciones elementales");
        btnRespuesta.setFocusable(false);
        btnRespuesta.setSize(250, 30);
        btnRespuesta.setLocation((contentPane.getWidth() - btnRespuesta.getWidth()) / 2, 200);

        btnRespuesta.addActionListener((event) -> {
            
            Burbuja array = new Burbuja();
            int[]Lista2 = {1,2,3,4,5,6,7,8}; //Mejor caso
            int[]Lista = {1,3,2,4,7,5,6,8}; //Caso mixto
            int[]Lista3 = {8,7,6,5,4,3,2,1}; //Peor caso
            
            System.out.println("Caso mixto");
            array.bubble(Lista);
            for(int i=0;i<Lista.length;i++){
                System.out.println(Lista[i]);
                
            }
            System.out.println("por contador= "+array.getCont());
            System.out.println("por formula = "+array.getMixto()); 
            
            System.out.println("Caso Mejor");
            array.bubble(Lista2);
            for(int i=0;i<Lista.length;i++){
                System.out.println(Lista[i]);
                
            }
            System.out.println("por contador= "+array.getCont());
            System.out.println("por formula = "+array.getMixto());
            
            System.out.println("Caso Peor");
            array.bubble(Lista3);
            for(int i=0;i<Lista.length;i++){
                System.out.println(Lista[i]);
                
            }
            System.out.println("por contador= "+array.getCont());
            System.out.println("por formula = "+array.getMixto());
             
        });
        contentPane.add(btnRespuesta);
        repaint();

        
        graphPanel = graficador.getGrafica();
        graphPanel.setSize(900, 550);
        graphPanel.setLocation(contentPane.getWidth(), 0);
        add(graphPanel);
        //contentPane.add(btnRespuesta);
    }
}
