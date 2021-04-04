package Models;

public class Burbuja {

    private int cont,formula;

    public void burbujaMixto(int[]a) {
        int i, N = a.length, j, temp;
        cont = 2;
        for (i = 0; i < N; i++) {
            cont += 5;
            for (j = i + 1; j < N; j++) {
                cont += 2;
                cont += 3;
                if (a[i] > a[j]) {
                    cont += 7;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            } 
        }
        formula = (5+7/2)*(N*N-(N-1)*(N/2)-N)+5*N+2;
    }
    
    public void burbujaMejor(int[]a) {
        int i, N = a.length, j, temp;
        cont = 2;
        for (i = 0; i < N; i++) {
            cont = cont + 5;
            for (j = i + 1; j < N; j++) {
                cont += 2;
                cont += 3;
                if (a[i] > a[j]) {
                    cont += 7;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            
        }
        
        formula = (5)*(N*N-(N-1)*(N/2)-N)+5*N+2;
    }
    
    public void burbujaPeor(int[]a) {
        int i, N = a.length, j, temp;
        cont=2;
        for (i = 0; i < N; i++) {
            cont += 5;
            for (j = i + 1; j < N; j++) {
                cont += 2;
                cont += 3;
                if (a[i] > a[j]) {
                    cont += 7;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
         }
        formula = (5+7)*(N*N-(N-1)*(N/2)-N)+5*N+2;
    }

    public int getCont() {
        return cont;
    }
    
    public int getformula() {
        return formula;
    }
}
