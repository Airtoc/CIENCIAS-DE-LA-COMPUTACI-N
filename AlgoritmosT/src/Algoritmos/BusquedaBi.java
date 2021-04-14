
package Algoritmos;

public class BusquedaBi {
    private int centro;
    
    public void busquedaBinaria(int vector[], int dato) {
        int n = vector.length;
        int inf = 0, sup = n - 1;
        Boolean conf = false;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector[centro] == dato) {
                System.out.println("El numero se encuentra en la posicion"+centro);
                conf = true;
                break;
            } else if (dato < vector[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        if(conf !=true){
        System.out.println("El numero no se encuentra en el array");
        }
    }
}
