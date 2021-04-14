package GUI;

import Algoritmos.BusquedaBi;
import Algoritmos.Euclides;
import Algoritmos.Funciones;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class window extends JFrame {

    private JPanel contentPane;
    private JButton BusquedaBi, Euclides, Raices;
    private JLabel titulo;

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
            String funcion = JOptionPane.showInputDialog(null, "Inserte la Expresion");
            Funciones fun = new Funciones(funcion);
            fun.algoritmo();
        });
        contentPane.add(Raices);

        //Busqueda Binaria
        BusquedaBi = new JButton("Busqueda Binaria");
        BusquedaBi.setFocusable(false);
        BusquedaBi.setSize(420, 40);
        BusquedaBi.setLocation(40, 350);

        BusquedaBi.addActionListener((event) -> {
            BusquedaBi Bus = new BusquedaBi();

            int[] vector = {1, 4, 7, 8, 9, 14, 23, 47, 56, 60, 61, 63, 65, 66, 68, 69, 70, 73, 76, 77, 79, 80, 82};
            int valorBuscado = 69;
            Bus.busquedaBinaria(vector, valorBuscado);
        });
        contentPane.add(BusquedaBi);

        add(contentPane);

    }
}
