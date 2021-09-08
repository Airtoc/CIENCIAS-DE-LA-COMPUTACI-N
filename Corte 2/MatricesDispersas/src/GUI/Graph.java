package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Graph extends JComponent {

    private int[] valuesColumns;
    private int[][] valuesRows;
    private Rectangle2D.Double[] valuesBoxes;

    public Graph(int[] valuesColumns) {
        super();
        this.valuesColumns = valuesColumns;
        this.valuesRows = valuesRows;
        valuesBoxes = new Rectangle2D.Double[valuesColumns.length];
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw: Config.
        super.paintComponent(g);
        Graphics2D graph2d = (Graphics2D) g;
        graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int a = 1;
        // Draw: Boxes.
        if(a == 1){
            // Draw: ColumnsBoxes.
            for (int i = 0; i < valuesColumns.length; i++) {
                valuesBoxes[i] = new Rectangle2D.Double();
                valuesBoxes[i].setRect(i*40, 10, 30, 30);
                graph2d.setColor(Color.BLACK);
                graph2d.draw(valuesBoxes[i]);
			}
            // Draw: RowBoxes.
        }
    }
}