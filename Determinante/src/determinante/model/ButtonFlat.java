package determinante.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ButtonFlat extends Button  {
    
    public ButtonFlat(String name, int posX, int posY, int width, int height, Color colorForeground, Color colorBackground, ActionListener action) {
        
        super(name, posX, posY, width, height);
        setBackground(colorBackground);
        setForeground(colorForeground);
        setFocusable(false);
        setFont(new Font("impact", Font.PLAIN, 20));
        addActionListener(action);
        
    }
    
}
