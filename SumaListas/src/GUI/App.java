package GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    
    private static int WIDTH = 800;
    private static int HEIGHT = 300;
    private JPanel contentPanel;
    private JTextField txtA, txtB;
    private JLabel title;
    private JButton btnMath;
    private JTextArea txtResult;

    public App() {
        setTitle("Suma");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        // -ContentPanel
        contentPanel = new JPanel(null);
        contentPanel.setBackground(new Color(26, 26, 29));
        setContentPane(contentPanel);
        // --Title.
        title = new JLabel("Suma con listas doblemente enlazadas");
        title.setBounds(10, 10, 800, 50);
        title.setFont(new Font("courier", Font.BOLD + Font.ITALIC, 35));
        title.setForeground(new Color(195, 7, 63));
        contentPanel.add(title);
        // --Number A.
        txtA = new JTextField();
        txtA.setBounds(5, 70, 775, 30);
        txtA.setFont(new Font("courier", Font.BOLD, 12));
        txtA.setBackground(new Color(78, 78, 80));
        txtA.setForeground(Color.white);
        contentPanel.add(txtA);
        // --Number B.
        txtB = new JTextField();
        txtB.setBounds(5, 120, 775, 30);
        txtB.setFont(new Font("courier", Font.BOLD, 12));
        txtB.setBackground(new Color(78, 78, 80));
        txtB.setForeground(Color.white);
        contentPanel.add(txtB);
        // --Math.
        btnMath = new JButton("<html><center>Calcular</center></html>");
        btnMath.setBounds(5, 220, 775, 30);
        btnMath.setFont(new Font("courier", Font.BOLD + Font.ITALIC, 30));
        btnMath.setForeground(Color.white);
        btnMath.setBackground(new Color(78, 78, 80));
        btnMath.setVerticalAlignment(SwingConstants.CENTER);
        btnMath.addActionListener(this);
        btnMath.setFocusable(false);
        contentPanel.add(btnMath);
        // --Result.
        txtResult = new JTextArea("Resultado..");
        txtResult.setBounds(5,160,775,40);
        txtResult.setBackground(new Color(149, 7, 64));
        txtResult.setForeground(Color.white);
        txtResult.setEditable(false);
        txtResult.setFont(new Font("courier", Font.BOLD, 12));
        contentPanel.add(txtResult);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnMath) {
            try {
                System.out.println("Calculando..");


            } catch (Exception error) {
                System.out.println("Mal");
            }
        }
    }
}