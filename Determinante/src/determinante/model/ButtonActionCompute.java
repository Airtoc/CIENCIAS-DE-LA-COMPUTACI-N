package determinante.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonActionCompute implements ActionListener {
   
    private Determinante determinante;
   
    
    public ButtonActionCompute(Determinante determinante) {
        
        this.determinante = determinante;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
   
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamañano de la matriz N x N, N: "));
        
        double[][] matrix = new double[(int) n][(int) n];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la fila ["+i+"] y la columna ["+j+"]"));
                }
            }
            determinante.calcularDeterminante(matrix);
        } catch (NullPointerException error) {
            System.out.println("No se puede calcular");
        } catch (ArithmeticException error) {
            System.out.println("No se puede calcular");
        }
        
        System.out.println("Por contador: " + determinante.getContador()+", por formula: " + determinante.getFormula());
        
    }
    
}