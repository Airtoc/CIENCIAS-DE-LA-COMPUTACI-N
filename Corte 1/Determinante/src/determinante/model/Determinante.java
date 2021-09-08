package determinante.model;

import javax.swing.JOptionPane;

public class Determinante {
    
    private int contador;
    private String formula;
    private double[][] matriz;
    private double size;
    private boolean isNan = false;
     
    public double calcularDeterminante(double[][] matriz){
        this.matriz = matriz;
        size = matriz.length;
        
        contador = 0;
        contador += 2; // i, False.
        
        for (int i = 0; i < (matriz.length - 1) ; i++) {
            
            contador += 3; // <, ++, -.
            contador += 2; // Asginación y suma.
            //contador ++; // False.
            
            // Intercambiar columnas.
            int iterador = i + 1;
            while (matriz[i][i] == 0 && iterador < matriz.length) {
                if (hayColumnasCeros(matriz,i,i)) {
                    isNan = true;
                    break;
                }
                double[] temp = matriz[i];
                matriz[i] = matriz[iterador];
                matriz[iterador] = temp;
                iterador++;

            }
            
            for (int j = i+1; j < (matriz.length); j++) {
                
                contador += 2; // <, ++.
                contador += 2; // Asginación y suma.
                contador ++; // False.
                
                for (int k = i+1; k < (matriz.length); k++) {
                    
                    contador += 2; // <, ++.
                    contador += 14; // ABAJO
                    matriz[j][k] = matriz[j][k]-matriz[j][i]*matriz[i][k]/matriz[i][i];
                    
                }
                
            }
            
        }
        
        // Para imprimir.
        double traza = 1;
        
        for (int i = 0; i < matriz.length; i++) {
            
            traza = traza*matriz[i][i];
            
        }
        
        if (Double.isNaN(traza)){
            
            JOptionPane.showMessageDialog(null,"No se puede calcular determinante: 0");
            
        }else {
            
             JOptionPane.showMessageDialog(null,"El determinante es : "+ traza);
             
        }
        
        return 0;
    }

    public int getContador() {
        
        return contador;
        
    }

    public String getFormula() {
        
        double formulaTemp = (16*(Math.pow(size,2)-(2*size)+1+(((size-2)*(size-1))*((2*size)-3))/6))+5*((Math.pow(size,2)-size-(size*(size-1)/2)))+(5*(size-1))+2;
   
        return formula = Double.toString(formulaTemp);
  
    }
    
    public boolean hayColumnasCeros(double[][] ref, int row, int col) {
        
        int contadorColumnasCeros = 0;
        for (int i = row + 1; i < ref.length; i++) {
            if (ref[i][col] == 0) {
                contadorColumnasCeros++;
            }
        }
        
        return contadorColumnasCeros == ((ref.length - 1) - row);
    }
    
}