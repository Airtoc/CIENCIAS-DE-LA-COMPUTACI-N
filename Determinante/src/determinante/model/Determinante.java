package determinante.model;

public class Determinante {
    
    private int contador;
    private double formula;
    private double[][] matriz;
    private double size;
    
    public double calcularDeterminante(double[][] matriz){
        this.matriz = matriz;
        size = matriz.length;
        
        contador = 0;
        contador += 2; // i, False.
        
        for (int i = 0; i < (matriz.length - 1) ; i++) {
            
            contador += 3; // <, ++, -.
            contador += 2; // Asginación y suma.
            //contador ++; // False.
            
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
        
        System.out.println(traza);
        
        return 0;
    }

    public int getContador() {
        
        return contador;
        
    }

    public double getFormula() {
        
        return formula = (16*(Math.pow(size,2)-(2*size)+1+(((size-2)*(size-1))*((2*size)-3))/6))+5*((Math.pow(size,2)-size-(size*(size-1)/2)))+(5*(size-1))+2;
        
    }
    
    
    
}