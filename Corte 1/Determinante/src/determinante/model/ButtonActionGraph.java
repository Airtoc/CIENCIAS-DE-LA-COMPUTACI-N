package determinante.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonActionGraph implements ActionListener {
    
    private Graph grapher;
    private Determinante determinante;
    private ArrayList<Double> posX = new ArrayList<>();
    private ArrayList<Double> posY = new ArrayList<>();
    
    public ButtonActionGraph(Graph grapher, Determinante determinante) {
        
        this.grapher = grapher;
        this.determinante = determinante;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        for (double i = 0; i < 100; i++) {
            
            posX.add(i);
            posY.add((16*(Math.pow(i,2)-(2*i)+1+(((i-2)*(i-1))*((2*i)-3))/6))+5*((Math.pow(i,2)-i-(i*(i-1)/2)))+(5*(i-1))+2);
            
        }
        
        grapher.agregarGrafica("Gráfica principal", posX, posY);
        
        posX.clear();
        posY.clear();
        
        for (double i = 0; i < 100; i++) {
            
            posX.add(i);
            posY.add(2*Math.pow(i,3));
            
        }
        
        grapher.agregarGrafica("Cota inferior", posX, posY);
        
        posX.clear();
        posY.clear();
        
        for (double i = 0; i < 100; i++){
            
            posX.add(i);
            posY.add((5*7/8)*Math.pow(i,3));
            
        }
        
        grapher.agregarGrafica("Cota superior", posX, posY);
        
    }
    
}