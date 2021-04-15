
package Algoritmos;

import javax.swing.JOptionPane;

public class Euclides {
       private int a,b,cont;
    
    public void euclides(int a, int b){
        int temp = 0;

        while(a%b != 0){
            cont += 4;
            System.out.println(a+"--"+b+"--"+a%b);
            temp = b;
            b = a%b;
            a = temp;
        }
        JOptionPane.showMessageDialog(null,"El MCD es : "+b +"\n y el algoritmo se ejecuta: "+cont+" Veces");
    }   
}
