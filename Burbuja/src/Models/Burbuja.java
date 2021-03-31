
package Models;


public class Burbuja {
    private int cont,peor,mejor,mixto;
    
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
    
    public void bubble(int[]A){
        int n = A.length;
        int t ;
        cont = 0;
        int x = 0;
        
        cont+=2;
        for(int i= 0;i<(n-1);i++){
            cont += 6;
            for(int j = i+1; j<n ; j++){
                cont += 6;
                if(A[i]<A[j]){
                    x++;
                    cont +=7;
                    t = A[i];
                    A[i]=A[j];
                    A[j]=t;
                }
            }
        }
       mixto = 2+(x*7)+6*(n-1)+6*((n*n-n)/2);
       peor = 2+6*(n-1)+13*((n*n-n)/2);
       mejor = 2+6*(n-1)+6*((n*n-n)/2);
    }
    public int getCont() {
        return cont;
    }

    public int getPeor() {
        return peor;
    }

    public int getMejor() {
        return mejor;
    }

    public int getMixto() {
        return mixto;
    }
    
    
    
}
