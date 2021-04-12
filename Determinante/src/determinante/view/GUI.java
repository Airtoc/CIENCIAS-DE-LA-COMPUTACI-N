package determinante.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

    private final int WIDTH;
    private final int HEIGHT;
    
    private JPanel mainPanel;

    public GUI(int WIDTH, int HEIGHT) {

        // Configuración de la ventana.
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
       
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        
        mainPanel = new JPanel(null);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(300, 1000);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(mainPanel);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }  

}