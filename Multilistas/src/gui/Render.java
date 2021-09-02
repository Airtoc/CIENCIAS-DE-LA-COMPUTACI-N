package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Render extends DefaultTableCellRenderer {
    private JLabel labelSearch = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        if("search".equals(value)){
            labelSearch.setIcon(new ImageIcon("images/search.png"));
            labelSearch.setHorizontalAlignment(JLabel.CENTER);
            return labelSearch;
        }
        return this;
    }
}
