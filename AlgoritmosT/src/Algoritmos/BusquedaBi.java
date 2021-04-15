
package Algoritmos;

import javax.swing.JOptionPane;

public class BusquedaBi {
    private int centro;
    
    public void busquedaBinaria(double vector[], double dato) {
        int n = vector.length;
        int inf = 0, sup = n - 1;
        Boolean conf = false;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector[centro] == dato) {
                JOptionPane.showMessageDialog(null,"El numero se encuentra en la posicion "+ centro);
                conf = true;
                break;
            } else if (dato < vector[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        if(conf !=true){
        JOptionPane.showMessageDialog(null,"El numero no se encuentra en el array");
        }
    }
}
