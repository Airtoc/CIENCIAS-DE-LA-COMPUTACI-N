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
    private JButton btnMejorC;
    private JButton btnPeorC;
    private JButton btnPromedio;
    private JPanel graphPanel;
    private Graph graficador = new Graph("Ecuacion Complejidad Burbuja", "complex", "variable");

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

        btnMejorC = new JButton("Mejor caso");
        btnMejorC.setFocusable(false);
        btnMejorC.setSize(250, 30);
        btnMejorC.setLocation((contentPane.getWidth() - btnMejorC.getWidth()) / 2, 100);

        btnMejorC.addActionListener((event) -> {
            
            //Algoritmo
            Burbuja array = new Burbuja();
            int[]Lista2 = {1,2,3,4,5,6,7,8}; //Mejor caso
            
            System.out.println("Mejor Caso");
            array.burbujaMejor(Lista2);
            for(int i=0;i<Lista2.length;i++){
                System.out.println(Lista2[i]);
            }
            String text = "por contador= "+array.getCont()+"\n"+
                    "por formula = "+array.getformula();          
            JOptionPane.showMessageDialog(null,text);
            
            
            //Grafica
            ArrayList<Double> x = new ArrayList<>(),y = new ArrayList<>();
            for(double i = 0; i< 100;i++){
                x.add(i);
                y.add(2*((5)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.crearGrafica("Peor", x, y);
           
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add((5)*(i*i-(i-1)*(i/2)-i)+5*i+2);
            }
            graficador.agregarGrafica("promedio", x, y);
            
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add(0.5*((5)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.agregarGrafica("Mejor", x, y);
            
            repaint();
        });

        contentPane.add(btnMejorC);
        
        btnPeorC = new JButton("Peor");
        btnPeorC.setFocusable(false);
        btnPeorC.setSize(250, 30);
        btnPeorC.setLocation((contentPane.getWidth() - btnMejorC.getWidth()) / 2, 200);

        btnPeorC.addActionListener((event) -> {
            
            //Algoritmo
            Burbuja array = new Burbuja();
            int[]Lista3 = {8,7,6,5,4,3,2,1}; //Peor caso
            
            System.out.println("Peor Caso");
            array.burbujaPeor(Lista3);
            for(int i=0;i<Lista3.length;i++){
                System.out.println(Lista3[i]);
            }
            String text = "por contador= "+array.getCont()+"\n"+
                    "por formula = "+array.getformula();          
            JOptionPane.showMessageDialog(null,text);
            
            
            //Grafica
            ArrayList<Double> x = new ArrayList<>(),y = new ArrayList<>();
            for(double i = 0; i< 100;i++){
                x.add(i);
                y.add(2*((5+7)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.crearGrafica("Peor", x, y);
           
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add(((5+7)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.agregarGrafica("Promedio", x, y);
            
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add(0.5*(((5+7)*(i*i-(i-1)*(i/2)-i)+5*i+2)));
            }
            graficador.agregarGrafica("Mejor", x, y);
            
            repaint();
        });

        contentPane.add(btnPeorC);
        
        btnPromedio = new JButton("Caso promedio");
        btnPromedio.setFocusable(false);
        btnPromedio.setSize(250, 30);
        btnPromedio.setLocation((contentPane.getWidth() - btnMejorC.getWidth()) / 2, 300);

        btnPromedio.addActionListener((event) -> {
            //Algoritmo
            Burbuja array = new Burbuja();
            int[]Lista = {1,3,2,4,7,5,6,8};
            
            System.out.println("Caso Promedio");
            array.burbujaMixto(Lista);
            for(int i=0;i<Lista.length;i++){
                System.out.println(Lista[i]);
            }
            String text = "por contador= "+array.getCont()+"\n"+
                    "por formula = "+array.getformula();          
            JOptionPane.showMessageDialog(null,text); 
            
            
            //Grafica
            ArrayList<Double> x = new ArrayList<>(),y = new ArrayList<>();
            for(double i = 0; i< 100;i++){
                x.add(i);
                y.add(2*((5+7/2)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.crearGrafica("Peor", x, y);
           
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add((5+7/2)*(i*i-(i-1)*(i/2)-i)+5*i+2);
            }
            graficador.agregarGrafica("Promedio", x, y);
            
            x.clear();
            y.clear();
             //obtener valores cota superior
            for(double i = 0; i < 100; i++){
                x.add(i);
                y.add(0.5*((5+7/2)*(i*i-(i-1)*(i/2)-i)+5*i+2));
            }
            graficador.agregarGrafica("Mejor", x, y);
            
            repaint();
        });

        contentPane.add(btnPromedio);
        repaint();
        graphPanel = graficador.getGrafica();
        graphPanel.setSize(900, 550);
        graphPanel.setLocation(contentPane.getWidth(), 0);
        add(graphPanel);
        //contentPane.add(btnRespuesta);
    }
}
