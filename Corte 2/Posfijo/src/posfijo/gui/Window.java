package posfijo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import posfijo.logic.InfixPostfix;

public class Window extends JFrame implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private JLabel lblMath, lblPostfix, lblResult;
    private JTextPane txtMath, txtPostfix, txtResult;
    private JScrollPane scrollMath, scrollPostfix, scrollResult;
    private JPanel contentPane;
    private JButton btnMAth;

    public Window(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadComponents() {
        contentPane = new JPanel(null);
        setContentPane(contentPane);

        lblMath = new JLabel("Digite SIN ESPACIOS + - / * ^ ( )");
        lblMath.setBounds(5,10, WIDTH,20);
        lblMath.setFont(new Font("consolas", Font.BOLD, 20));

        txtMath = new JTextPane();
        txtMath.setEditable(true);
        scrollMath = new JScrollPane(txtMath);
        scrollMath.setBounds(5, 40, 770, 50);

        lblPostfix = new JLabel("Posfijo");
        lblPostfix.setBounds(5, 100, WIDTH, 20);
        lblPostfix.setFont(new Font("consolas", Font.BOLD, 20));

        txtPostfix = new JTextPane();
        txtPostfix.setEditable(false);
        scrollPostfix = new JScrollPane(txtPostfix);
        scrollPostfix.setBounds(5, 130, 770, 50);

        lblResult = new JLabel("Resultado");
        lblResult.setBounds(5,190, WIDTH, 20);
        lblResult.setFont(new Font("consolas", Font.BOLD, 20));

        txtResult = new JTextPane();
        txtResult.setEditable(false);
        scrollResult = new JScrollPane(txtResult);
        scrollResult.setBounds(5, 220, 770, 50);

        btnMAth = new JButton("Calcular");
        btnMAth.setBounds(10 , 300, 765, 50);
        btnMAth.setFocusable(false);
        btnMAth.addActionListener(this);
        btnMAth.setFont(new Font("consolas", Font.BOLD, 40));

        contentPane.add(lblMath);
        contentPane.add(scrollMath);
        contentPane.add(lblPostfix);
        contentPane.add(scrollPostfix);
        contentPane.add(lblResult);
        contentPane.add(scrollResult);
        contentPane.add(btnMAth);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Math.
        if (e.getSource() == btnMAth){
            InfixPostfix converter = new InfixPostfix();
            System.out.println("Calculando...");
            String infix = getTxtMath().getText();
            String postfix = converter.infixToPostfix(infix);
            System.out.println(postfix);
            int resultValue = converter.evaluatePostfix(postfix);
            getTxtPostfix().setText(postfix);
            getTxtResult().setText(String.valueOf(resultValue));
        }

    }

    public JTextPane getTxtMath() {
        return txtMath;
    }

    public JTextPane getTxtResult() {
        return txtResult;
    }

    public JTextPane getTxtPostfix() {
        return txtPostfix;
    }
}