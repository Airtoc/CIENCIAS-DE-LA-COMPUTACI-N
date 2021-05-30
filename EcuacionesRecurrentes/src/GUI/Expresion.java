package GUI;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Expresion extends JPanel {

    private JTextField[] polinomio, valorN, valorFn;
    private JLabel txtCoeficiente,txtFN,txtN;

    public Expresion(int grado) {
        polinomio = new JTextField[grado];
        valorN = new JTextField[2];
        valorFn = new JTextField[2];
        txtCoeficiente = new JLabel("Coeficientes");
        txtFN = new JLabel("Valores de Fn");
        txtN = new JLabel("Valores de N");
        
    }

    public void initInputElements() {
        txtCoeficiente.setSize(new Dimension(150, 25));
        txtCoeficiente.setLocation(0,0);
        txtCoeficiente.setVisible(true);
        txtCoeficiente.setFont(new Font("Arial", Font.BOLD, 25));
        add(txtCoeficiente);
        
        for (int i = 0; i < polinomio.length; i++) {
            polinomio[i] = new JTextField();
            polinomio[i].setBounds(i * 50 + 6,30, 40, 30);
            polinomio[i].setHorizontalAlignment(JLabel.CENTER);
            polinomio[i].setFont(new Font("Arial", Font.ITALIC, 15));
            add(polinomio[i]);
        }
        
               
        txtN.setSize(new Dimension(150, 50));
        txtN.setLocation(0,90);
        txtN.setVisible(true);
        txtN.setFont(new Font("Arial", Font.PLAIN, 20));
        add(txtN);

        for (int i = 0; i < valorN.length; i++) {
            valorN[i] = new JTextField();
            valorN[i].setBounds(10,150 +( i * 50+6),40,40);
            valorN[i].setHorizontalAlignment(JLabel.CENTER);
            valorN[i].setFont(new Font("Arial", Font.PLAIN, 15));
            add(valorN[i]);
        }      
        
        txtFN.setSize(new Dimension(150, 50));
        txtFN.setLocation(150, 90);
        txtFN.setVisible(true);
        txtFN.setFont(new Font("Arial", Font.PLAIN, 20));
        add(txtFN);
        
        for (int i = 0; i < valorFn.length; i++) {
            valorFn[i] = new JTextField();
            valorFn[i].setBounds(150,150 +(i * 50 + 6),40,40);
            valorFn[i].setHorizontalAlignment(JLabel.CENTER);
            valorFn[i].setFont(new Font("Arial", Font.BOLD, 15));
            add(valorFn[i]);
        }
        
        repaint();

    }

    public void removeInputElements() {
        removeAll();
        repaint();
    }

    public JTextField[] getCoeficientes() {
        return polinomio;
    }

}
