package determinante;

public class Determinante {
    
    private int contador;
    
    public double calcularDeterminante(double[][] matriz){
        
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
    
}