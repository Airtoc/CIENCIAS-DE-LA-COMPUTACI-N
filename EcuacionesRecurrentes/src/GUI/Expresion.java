package GUI;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Expresion extends JPanel {

    private JTextField[] polinomio, valorN, valorFn;
    private JLabel txtCoeficiente, txtFN, txtN;
    private double[] coeficientes,n,fn;
    private int gradop;

    public Expresion(int grado) {
        coeficientes = new double[grado+1];
        n = new double[grado];
        fn = new double[grado];
        polinomio = new JTextField[grado+1];
        valorN = new JTextField[grado];
        valorFn = new JTextField[grado];
        txtCoeficiente = new JLabel("Coeficientes");
        txtFN = new JLabel("Valores de Fn");
        txtN = new JLabel("Valores de N");
        gradop = grado;
        
    }

    public void initInputElements() {
        txtCoeficiente.setSize(new Dimension(150, 25));
        txtCoeficiente.setLocation(0, 0);
        txtCoeficiente.setVisible(true);
        txtCoeficiente.setFont(new Font("Agency FB", Font.PLAIN, 20));
        add(txtCoeficiente); 
        
        //Genera campos para añadir los coeficientes del polinomio
        for (int i = 0; i < polinomio.length; i++) {
            polinomio[i] = new JTextField();
            polinomio[i].setBounds(i * 50 + 6, 30, 40, 30);
            polinomio[i].setHorizontalAlignment(JLabel.CENTER);
            polinomio[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
            add(polinomio[i]);
        }
        //Genera campos para añadir los valores iniciales de n 
        txtN.setSize(new Dimension(150, 25));
        txtN.setLocation(0, 70);
        txtN.setVisible(true);
        txtN.setFont(new Font("Agency FB", Font.PLAIN, 20));
        add(txtN);

        for (int i = 0; i < valorN.length; i++) {
            valorN[i] = new JTextField();
            //valorN[1].setBounds(i, i, WIDTH, HEIGHT);
            valorN[i].setBounds(i*50+6,100, 40,30);
            valorN[i].setHorizontalAlignment(JLabel.CENTER);
            valorN[i].setFont(new Font("Agency FB", Font.PLAIN, 15));
            add(valorN[i]);
        }
        // Genera campos para añadir los valores iniciales de fn
        txtFN.setSize(new Dimension(100, 25));
        txtFN.setLocation(0, 140);
        txtFN.setVisible(true);
        txtFN.setFont(new Font("Agency FB", Font.PLAIN, 20));
        add(txtFN);

        for (int i = 0; i < valorFn.length; i++) {
            valorFn[i] = new JTextField();
            valorFn[i].setBounds(i*50+6, 170, 40, 30);
            valorFn[i].setHorizontalAlignment(JLabel.CENTER);
            valorFn[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
            add(valorFn[i]);
        }

        repaint();

    }

    public void removeInputElements() {
        removeAll();
        repaint();
    }

    public double[] getCoeficientes() {
        //Retorna los coeficientes de el polinomio
        for (int i = 0; i < polinomio.length; i++) {
            coeficientes[i] = Double.parseDouble(polinomio[i].getText());
        }
        return coeficientes;
    }    
    
    public double[] getFn() {
        //Retorna los coeficientes de el polinomio
        for (int i = 0; i < valorFn.length; i++) {
            fn[i] = Double.parseDouble(valorFn[i].getText());
        }
        return fn;
    } 
    public double[] getNvalues() {
        //Retorna los coeficientes de el polinomio
        for (int i = 0; i < valorN.length; i++) {
            n[i] = Double.parseDouble(valorN[i].getText());
        }
        return n;
    } 
    

}
