
package Algoritmos;

import javax.swing.JOptionPane;

public class Euclides {
       private int a,b;
    
    public void euclides(int a, int b){
        int temp = 0;

        while(a%b != 0){
            System.out.println(a+"--"+b+"--"+a%b);
            temp = b;
            b = a%b;
            a = temp;
        }
        JOptionPane.showMessageDialog(null,"El MCD es : "+b);
    }   
}
