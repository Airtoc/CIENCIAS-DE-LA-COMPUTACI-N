import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    private static int WIDTH = 1280;
    private static int HEIGHT = 720;
    private JPanel contentPane, graphPanel;
    private JScrollPane scrollPane;
    private JTextField[] columns;
    private JTextField[] rows, rowsValues;

    public Window(String title) {
        setSize(WIDTH, HEIGHT);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadComponents() {
        JPanel panel = new JPanel();
        JTextField[] fields = new JTextField[15];
        for (int i = 0; i < 15; i++) {
            fields[i] = new JTextField();
            fields[i].setBounds(i*30,10,20,10);
            panel.add(fields[i]);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);
        contentPane = new JPanel(null);
        contentPane.add(scrollPane);
        setContentPane(contentPane);
        setVisible(true);

    }

    public void createColumns(int[] valuesColumns) {
        this.columns = new JTextField[valuesColumns.length];

        for (int i = 0; i < valuesColumns.length; i++) {
            columns[i] = new JTextField();
            columns[i].setEditable(false);
            columns[i].setBounds(10, i*40+10, 30, 20);
            columns[i].setFont(new Font("Helvetica", Font.BOLD, 12));
            columns[i].setBackground(Color.CYAN);
            int data = valuesColumns[i];
            columns[i].setText(Integer.toString(data));
            graphPanel.add(columns[i]);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
