package determinante.model;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public interface IGUIFactory {
    
    public Button createButtonFlat(String name, int posX, int posY, int width, int height, ActionListener action);
    
    public Graph createGraph(String title, String titleX, String titleY);
     
}