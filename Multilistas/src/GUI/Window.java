package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private JTable bigTable, subTable;
    private JScrollPane scrollTable, scrollSubTable;
    private JPanel contentPanel;
    private JButton[] buttons;
    private JLabel lblTitle;

    public Window() {
        setTitle("Multi-Listas");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents() {
        // ContentPanel.
        contentPanel = new JPanel(null);
        setContentPane(contentPanel);
        // Title.
        lblTitle = new JLabel("Multi-Listas");
        contentPanel.add(lblTitle);
        // Table.

        // SubTable.





        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}