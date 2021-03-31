
package Models;


public class Burbuja {
    private int cont;
    
    public void burbuja(int[]A){
         int i, j, aux;
         cont=0;
         cont++;
        // i=0
        for (i = 0; i < A.length - 1; i++) {
            cont += 4;
            //3 comparacion, resta , suma
            //1 J=0
            for (j = 0; j < A.length - i - 1; j++) {
                cont +=8;
                    //4 comparacion, resta, resta , suma
                    //4 del if
                if (A[j + 1] < A[j]) {
                    cont += 9;
                    aux = A[j + 1]; //3 accede asigna suma
                    A[j + 1] = A[j]; //4 , accede,suma,asigna,accede
                    A[j] = aux; // 2,accede agrega
                }
                cont++; // 1 false
            }
            cont++;//1 false
        }
        cont++;//1 false
    }
    

    public int getCont() {
        return cont;
    }
    
    
}
