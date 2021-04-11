package determinante;

public class Main {

    public static void main(String[] args) {
        
        // Determinante - GAUSS.
        double [][]matriz = {
            {3,5,2,3},
            {5,8,9,1},
            {1,0,7,3},
            {4,3,5,2}
        };
        
        Determinante determinante = new Determinante();
        double N = matriz.length;
        double formula = (16*(Math.pow(N,2)-(2*N)+1+(((N-2)*(N-1))*((2*N)-3))/6))+5*((Math.pow(N,2)-N-(N*(N-1)/2)))+(5*(N-1))+2;
        determinante.calcularDeterminante(matriz);
        System.out.println("Por contador: " + determinante.getContador());
        System.out.println("Por formula: " + formula);
   
    }
    
}