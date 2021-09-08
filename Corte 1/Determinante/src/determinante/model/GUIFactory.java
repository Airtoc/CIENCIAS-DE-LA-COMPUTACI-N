package determinante.model;

import java.awt.Color;
import java.awt.event.ActionListener;

public class GUIFactory implements IGUIFactory {

    @Override
    public Graph createGraph(String title, String titleX, String titleY) {
        
        Graph graph = new Graph(title, titleX, titleY);
        
        return graph;
        
    }

    @Override
    public Button createButtonFlat(String name, int posX, int posY, int width, int height, ActionListener action) {
        
        ButtonFlat buttonFlat = new ButtonFlat(name , posX, posY, width, height, Color.black, Color.white, action);
        
        return buttonFlat;
        
    }
    
}