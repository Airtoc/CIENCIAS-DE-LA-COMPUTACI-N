package determinante.model;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph {
    private JFreeChart graficador;
    private XYSeriesCollection datos;
    private String titulo,labelX,labelY;

    public Graph(String titulo,String labelX,String labelY){
        
        this.titulo = titulo;
        this.labelX = labelX;
        this.labelY = labelY;
        this.datos = new XYSeriesCollection();

        this.graficador = ChartFactory.createXYLineChart(titulo,labelX,labelY,datos,PlotOrientation.VERTICAL,true,false,false);
     
    }

    public void agregarGrafica(String id,ArrayList<Double> x, ArrayList<Double> y){
        
        XYSeries a = new XYSeries(id);
        for(int i = 0; i < x.size(); i++){
            a.add(x.get(i),y.get(i));
        }
        this.datos.addSeries(a);
        
    }

    public void crearGrafica(String id,ArrayList<Double> x, ArrayList<Double> y){
        
        datos.removeAllSeries();
        agregarGrafica(id,x,y);
        
    }

    public JPanel getGrafica(){
        
        return new ChartPanel(this.graficador);
        
    }

}