package GUI;

import Gauss.Gauss;
import Newton.Newton;
import Newton.Raices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {

    private JLabel title, description, result;
    private JPanel mainPanel, mathPanel;
    private JButton generateFields, calculate;
    private JTextField grade;
    private Expresion panel;
    static int WIDTH = 800;
    static int HEIGHT = 600;
    
    public Ventana() {
        mainPanel = new JPanel(null);
        mathPanel = new JPanel(null);
        title = new JLabel("Ecuaciones en Recurrencia");
        description = new JLabel("Inserte el grado del polinomio:");
        result = new JLabel();
        generateFields = new JButton("Generar campos");
        calculate = new JButton("Calcular");
        grade = new JTextField();
    }

    public void initComponentsA(){
        // Config: Main Panel.
        add(mainPanel);
        mainPanel.setBackground(new Color(23, 62, 67));
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT/4);

        // -Title:
        title.setSize(new Dimension(WIDTH, 40));
        title.setLocation(mainPanel.getWidth()/6, 0);
        title.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 40));
        title.setForeground(new Color(250, 229, 150));
        mainPanel.add(title);

        // -Description:
        description.setSize(new Dimension(WIDTH, 40));
        description.setLocation(0, mainPanel.getHeight()-60);
        description.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 20));
        description.setForeground(new Color(221, 223, 212));
        mainPanel.add(description);

        // -Buttons.
        // --GenerateFields:
        generateFields.setSize(150, 40);
        generateFields.setLocation(WIDTH-200, mainPanel.getHeight()-60);
        generateFields.addActionListener(this);
        generateFields.setForeground(Color.BLACK);
        generateFields.setFocusable(false);
        generateFields.setFont(new Font("Helvetica", Font.BOLD, 12));
        generateFields.setBackground(new Color(221,223,212));
        mainPanel.add(generateFields);

        // --Calculate:
        calculate.setSize(150, 40);
        calculate.setLocation(WIDTH-350, mainPanel.getHeight()-60);
        calculate.addActionListener(this);
        calculate.setFocusable(false);
        calculate.setFont(new Font("Helvetica", Font.BOLD, 12));
        calculate.setBackground(new Color(221,223,212));
        mainPanel.add(calculate);

        // --Grade:
        grade.setSize(new Dimension(50, 40));
        grade.setLocation(WIDTH-500, mainPanel.getHeight()-60);
        grade.setFont(new Font("Helvetica", Font.BOLD, 20));
        mainPanel.add(grade);

        // --Result
        result.setLocation(0, HEIGHT-150);
        result.setSize(new Dimension(800, 60));
        result.setFont(new Font("Helvetica", Font.BOLD, 20));
        add(result);
    }
    

    public void initComponents() {
        title.setSize(new Dimension(800, 40));
        title.setLocation(0, 20);
        title.setFont(new Font("Agency FB", Font.BOLD, 40));
        add(title);

        description.setSize(new Dimension(800, 40));
        description.setLocation(10, 80);
        description.setFont(new Font("Agency FB", Font.BOLD, 25));
        add(description);

        grade.setSize(new Dimension(90, 30));
        grade.setLocation(15, 120);
        add(grade);

        generateFields.setSize(150, 30);
        generateFields.setLocation(450, 120);
        generateFields.addActionListener(this);
        generateFields.setForeground(Color.WHITE);
        generateFields.setBackground(Color.BLACK);
        add(generateFields);

        calculate.setSize(150, 30);
        calculate.setLocation(610, 120);
        calculate.addActionListener(this);
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(Color.BLACK);
        add(calculate);

        result.setLocation(0, 300);
        result.setSize(new Dimension(800, 60));
        result.setFont(new Font("Agency FB", Font.BOLD, 18));
        add(result);
    }

    public void initTemplate() {
        setLayout(null);
        //setBackground(new Color(39,224,196));
        //setForeground(new Color(39,224,196));
        setTitle("Recurrencia");
        setSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //initComponents();
        initComponentsA();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == generateFields) {

            try {
                int n = Integer.parseInt(grade.getText());
                panel = new Expresion(n);
                panel.removeInputElements();
                panel.initInputElements();
                panel.setBounds(0, HEIGHT/4, WIDTH, (3*HEIGHT)/4);
                add(panel);
                repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == calculate) {

            try {
                
                double[] coeficientes = panel.getCoeficientes();
                Raices ra = new Raices(coeficientes);
                //Se obtienen las raices usando Newton
               /*Newton raiz = new Newton(panel.getCoeficientes());
                double[] raices = raiz.getRaices();
                double aux;
                //se invierten las raices 
                for (int i = 0; i < raices.length / 2; i++) {
                    aux = raices[i];
                    raices[i] = raices[raices.length - 1 - i];
                    raices[raices.length - 1 - i] = aux;
                }
                //Se imprimen las raices en consola
                for (int i = 0; i < raices.length; i++) {
                    System.out.println(raices[i]);
                }*/
                //Crea una sistema de ecuaciones 
                double[] raices = ra.getRaices();
                Gauss ga = new Gauss(raices, panel.getFn(), panel.getNvalues());
                int[] multiplicidad = ga.getCont();
                for (int i = 0; i < raices.length; i++) {
                    System.out.println(multiplicidad[i]);
                }
                
                //Soluciona el sistema de ecuaciones
                double[] soluciones = ga.obtenerMatriz();
                
                //Imprime la ecuacion en consola y en la pantalla
                
                String valores = "";
                for (int i = 0; i < soluciones.length; i++) {
                    if(i!=soluciones.length-1){
                        valores += "(" + Math.round(soluciones[i]*1000.0)/1000.0 + ")</br> (" + Math.round(raices[i]*1000.0)/1000.0 + ")ⁿ (n^"+ multiplicidad[i]+") +";
                    }else{
                        valores += "(" + Math.round(soluciones[i]*1000.0)/1000.0 + ")</br> (" +Math.round(raices[i]*1000.0)/1000.0 + ")ⁿ (n^"+ multiplicidad[i]+")";
                    }
                }
                valores += "</html>";

                System.out.println("<html>la ecuacion completa es: fn = " + valores);

                result.setText("<html>La ecuacion completa es: fn = " + valores);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
