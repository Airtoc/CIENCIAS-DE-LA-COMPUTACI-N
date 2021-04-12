package determinante.controller;

import determinante.model.*;
import determinante.view.*;
import javax.swing.JPanel;

public class ControllerGUI extends Controller {

    @Override
    public void start() {
        
        final int WIDTH = 1200;
        final int HEIGHT = 600;

        System.out.println(this.getClass().getSimpleName()+" loaded.");
        
        // Iniciando GUI.
       
        // Componentes.
        GUIFactory fabrica = new GUIFactory();
        GUI gui = new GUI(WIDTH, HEIGHT);
        Graph grapher = fabrica.createGraph("Determinante GAUSS", "Complex", "Variable");
        Determinante determinante = new Determinante();
        
        JPanel graphPanel = grapher.getGrafica();
        graphPanel.setSize(885, HEIGHT-40);
        graphPanel.setLocation(300, 0);
        
        int widthButton = ((gui.getMainPanel().getWidth())-250)/2;
        int positionButton = 100;
        
        gui.getMainPanel().add(fabrica.createButtonFlat("Ver gráficas", widthButton, positionButton, 300, 30, new ButtonActionGraph(grapher, determinante)));
        gui.getMainPanel().add(fabrica.createButtonFlat("Formula", widthButton, positionButton*2, 300, 30, new ButtonActionCompute(determinante)));
        gui.getMainPanel().add(fabrica.createButtonFlat("Cerrar y salir", widthButton, positionButton*3, 300, 30, new ButtonActionClose()));
        gui.add(graphPanel);
        gui.setVisible(true);
        
    }
    
}