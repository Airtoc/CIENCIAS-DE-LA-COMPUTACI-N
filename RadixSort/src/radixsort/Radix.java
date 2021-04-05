package radixsort;

import java.util.Arrays;

public class Radix {

    // Variables de contadores.
    public int contadorMax = 0;
    public int contadorSort = 0;
    public int contadorRadixSort = 0;

    // Se obtiene el valor máximo del array.
    public int getMax(int arr[], int n) {
    
        int mx = arr[0];
        contadorMax = contadorMax +2;//asignacion y acceso array
        contadorMax = contadorMax + 2;//i=1,false del for
        for (int i = 1; i < n; i++) {
            contadorMax = contadorMax + 2;//comparacion y i++
            contadorMax = contadorMax + 2;//array y comparacion
            if (arr[i] > mx) {
                contadorMax += 2;//acceso array y asignacion
                mx = arr[i];
            }
        }
        contadorMax ++; // Return: Queda pendiente.
        return mx; 
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.

    public void countSort(int arr[], int n, int exp) {

        int output[] = new int[n]; // Output array, array de salida.
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);


        // Almacena el número de  occurriencias en count[].

        contadorSort += 1; // i = 0.
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++; // ++?
        }

        // Cambia count[i] asi que count[i] ahora posee
        // la actual posición del digito en output[]
        
        contadorSort += 1; // i = 1.
        for (i = 1; i < 10; i++) {

            count[i] += count[i - 1];

        }

        // Construye el array de salida.

        contadorSort += 2; // i = n - 1.
        for (i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;

        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit

        contadorSort += 1; // i = 0, inicializa variable.
        for (i = 0; i < n; i++) { // i < n, i++.

            contadorSort += 2+3; 
            arr[i] = output[i]; // Accede, asigna, accede.

        }

    }


    /*
    *Funcion principal que organiza el array de tamaño n usando radix
    */
    public void radixsort(int arr[], int n) {
        //Busca el numero mayor para hallar el numero de digitos
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number

        contadorRadixSort += 1; // exp = 1;
        for (int exp = 1; m / exp > 0; exp *= 10) {
            
            countSort(arr, n, exp);
        }
    }

    // Funcion que imprime un Array (se puede borrar)
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}