package GUI;

import Algoritmos.BusquedaBi;
import Algoritmos.Euclides;
import Algoritmos.Funciones;
import Algoritmos.Raices;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.*;

public class window extends JFrame {

    private JPanel contentPane;
    private JButton BusquedaBi, Euclides, Raices;
    private JLabel titulo;
    int num, i,numeros[],a,b;    
    String operaciones[];

    public window() {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(null);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.setSize(500, 500);
        contentPane.setLocation(0, 0);
        add(contentPane);

        titulo = new JLabel("Algoritmos");
        titulo.setFont(new Font("Monospaced", Font.PLAIN, 40));
        titulo.setSize(420, 40);
        titulo.setLocation(150, 100);
        contentPane.add(titulo);

        //Botones
        //Euclides
        Euclides = new JButton("Euclides (MCD)");
        Euclides.setFocusable(false);
        Euclides.setSize(420, 40);
        Euclides.setLocation(40, 250);

        Euclides.addActionListener((event) -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte primer digito"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte primer digito"));
            Euclides eu = new Euclides();
            eu.euclides(a, b);

        });
        contentPane.add(Euclides);

        //Busqueda de raiz
        Raices = new JButton("Encontrar Raices");
        Raices.setFocusable(false);
        Raices.setSize(420, 40);
        Raices.setLocation(40, 300);

        Raices.addActionListener((event) -> {
            datos();
            Raices cal = new Raices(num,numeros,operaciones,a,b);
            cal.raiz();
            if(cal.isCalcular()){
                JOptionPane.showMessageDialog(null,String.valueOf(cal.m));
            }else{
                JOptionPane.showMessageDialog(null,"No hay raiz en el intervalo");
            }
            
            //Funciones fun = new Funciones();
            //fun.algoritmo();
        });
        contentPane.add(Raices);

        //Busqueda Binaria
        BusquedaBi = new JButton("Busqueda Binaria");
        BusquedaBi.setFocusable(false);
        BusquedaBi.setSize(420, 40);
        BusquedaBi.setLocation(40, 350);

        BusquedaBi.addActionListener((event) -> {
            BusquedaBi Bus = new BusquedaBi();
            int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el tamaño del arreglo"));
            double[] arreglo = new double[size];
            for (int i = 0; i < size; i++) {
                arreglo[i] = Math.floor(Math.random() * (size - 0 + 1) + (0));
            }
            Arrays.sort(arreglo);
            for (int i = 0; i < size; i++) {
                System.out.println(arreglo[i]);
            }
            double valorBuscado = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserte el numero a buscar"));
            Bus.busquedaBinaria(arreglo, valorBuscado);
            ///int[] vector = {1, 4, 7, 8, 9, 14, 23, 47, 56, 60, 61, 63, 65, 66, 68, 69, 70, 73, 76, 77, 79, 80, 82};
        });
        contentPane.add(BusquedaBi);

        add(contentPane);

    }
    private void datos(){
        
        num = Integer.parseInt(JOptionPane.showInputDialog("¿De qué grado es tu polinómio?"));
        operaciones = new String[(num)];
        numeros = new int[(num+1)];
        for(i = 0; i < (num+1); i++){
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número x^"+(num-i)));
            if( i != num){
                operaciones[i] = JOptionPane.showInputDialog("Ingresa una suma o resta.");
            }
            
        }
        a = Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es el extremo izquierdo del intervalo?"));
        b = Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es el extremo derecho del intervalo?"));
    }
}
