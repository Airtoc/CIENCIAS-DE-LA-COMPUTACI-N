package determinante.model;

import javax.swing.JButton;

public abstract class Button extends JButton {
    
    public Button(String name, int posX, int posY, int width, int height) {
        
        setLocation(posX, posY);
        setSize(width, height);
        setText(name);
        
    }
    
}