package radixsort;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame {

    // Variables.
    private double valorContador;
    private double valorEcuacion;
    int[]lista = {1,3,4,2,7,6,5,8};

    // Panel principal.
    private JPanel contentPane;
    // Panel de gráficas.
    private JPanel graphPanel;

    // Array con botones.
    private JButton[] buttons = new JButton[3];

    private final int WIDTH, HEIGHT;

    // Graficadora.
    private Graph grapher = new Graph("Radix Sort", "Complex", "Variable");

    public GUI() {

        // Configuración de la ventana.
        WIDTH = 1200;
        HEIGHT = 600;

        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        // Configuración panel principal.
        contentPane = new JPanel(null);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.setSize(300, 1000);
        contentPane.setLocation(0, 0);
        add(contentPane);

        /*
    Buttons:
    -Button[0]: Informe del coste algoritmico tanto por ecuación como por contador.
    -Button[1]: Imprime las gráficas (Menú).
    -Button[2]: Cerrar.
         */
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFocusable(false);
            buttons[i].setSize(250, 30);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
            contentPane.add(buttons[i]);
        }

        // Button[0]: Ecuaciones
        buttons[0].setText("Resultado: Ecuación y contador");
        buttons[0].setLocation((contentPane.getWidth() - buttons[0].getWidth()) / 2, 100);
        buttons[0].addActionListener((event) -> {
            System.out.println("Calculando...");

            // Imprime.
            
            Radix radixTest = new Radix();
            radixTest.radixSort(lista);
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
            // (85*lista.length) + (231)
            valorContador = radixTest.getContador();
            JOptionPane.showMessageDialog(null, "Por ecuación: " + (27*lista.length+79) + "\n" + "Por contador: " + valorContador);

        });

        // Button[1]: Graficar
        buttons[1].setText("Ver: Gráficas");
        buttons[1].setLocation((contentPane.getWidth() - buttons[1].getWidth()) / 2, 200);
        buttons[1].addActionListener((event) -> {
            // Acciones.
            System.out.println("Graficando...");
            
            // Elementos necesarios.
            ArrayList<Double> posX = new ArrayList<>();
            ArrayList<Double> posY = new ArrayList<>();
            
            // Graficando..
            
            /*
            RADIX SORT.
            Ecuación: 27*n+79
            
            */
            for (double i = 0; i < 100; i++) {
                
                posX.add(i);
                posY.add(27*i+79);
                
            }
            
            grapher.agregarGrafica("Gráfica", posX, posY);
            posX.clear();
            posY.clear();
            
            repaint();
            
        });

        // Button[2]: Salir.
        buttons[2].setText("Cerrar y salir");
        buttons[2].setLocation((contentPane.getWidth() - buttons[2].getWidth()) / 2, 300);
        buttons[2].addActionListener((event) -> {
            // Acciones.
            System.out.println("Cerrando...");
            System.exit(0);
        });

        // Configuración panel con gráficas.
        graphPanel = grapher.getGrafica();
        graphPanel.setSize(900, 550);
        graphPanel.setLocation(contentPane.getWidth(), 0);
        add(graphPanel);

    }

}
