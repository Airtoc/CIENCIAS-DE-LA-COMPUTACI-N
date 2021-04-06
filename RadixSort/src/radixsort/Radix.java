package radixsort;

public class Radix {

    public int contador;
    private int maximo;

    public void radixSort(int[] arreglo) {
        
        contador = 0;

        int N = arreglo.length;
       
        maximo = arreglo.length;
        //contador += 2;

        //contador += 2;
        for (int i = 1; i < N; i++) { // 4(N-1)+4
            //contador += 4;
            if (arreglo[i] > maximo) {
                //contador += 2;
                maximo = arreglo[i];
            }
        }

        contador += 3; // Formulas sumadas * K
        for (int exp = 1; maximo / exp > 0; exp = exp*10) {
            System.out.println("Hola: "+(maximo/exp));
            contador += 4;

            int output[] = new int[N];
            int i;
            int count[] = new int[10];

            for (i = 0; i < N; i++) { // 7N + 2
                count[(arreglo[i] / exp) % 10]++;
                contador += 7;
            }
            contador += 2;

            for (i = 1; i < 10; i++) { // 65
                count[i] += count[i - 1];
                contador += 7;
            }
            contador += 2;

            for (i = N - 1; i >= 0; i--) { // 15N - 12 //15+3
                output[count[(arreglo[i] / exp) % 10] - 1] = arreglo[i];
                count[(arreglo[i] / exp) % 10]--;
                contador += 15;
            }
            contador += 3;

            for (i = 0; i < N; i++) { // 5N + 2 
                arreglo[i] = output[i]; // Accede, asigna, accede. 5 OE
                contador += 5;
            }
            contador += 2;
        }

    }


    public int getContador(){
        return contador;
    }

    public int getMaximo(){
        return maximo;
    }
}