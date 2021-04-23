package Logic;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class subsecuencia {

    private String cadena1, cadena2, sol1,sol2;
    private JTable tabla;

    public subsecuencia(String cadenaA, String cadenaB, JTable t) {
        cadena1 = cadenaA;
        cadena2 = cadenaB;
        tabla = t;

    }

    public void calcular() {
        char[] ejex = (cadena1.toCharArray());
        char[] ejey = (cadena2.toCharArray());

        char[] auxejex = (" " + cadena1).toCharArray();
        char[] auxejey = (" " + cadena2).toCharArray();

        int[][] c = new int[50][50];

        int[][] b = getLength(auxejex, auxejey);
        int[][] d = getLength(auxejey, auxejex);
        //Llena la matriz de 0
        for (int i = 0; i < ejex.length; i++) {
            c[0][i] = 0;
        }
        for (int i = 0; i < ejey.length; i++) {
            c[i][0] = 0;
        }
        for (int i = 1; i <= ejex.length; i++) {
            for (int j = 1; j <= ejey.length; j++) {
                if (ejex[i - 1] == ejey[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max((c[i - 1][j]), (c[i][j - 1]));
                }
            }
        }
        MostrarMatriz(c, auxejex, auxejey);
        sol1 = "Sigue por el oeste en caso de igualdad: ";
        sol2 = "Sigue por el norte en caso de igualdad: ";
        DisplaySol1(d, auxejey, auxejey.length - 1, auxejex.length - 1);
        DisplaySol2(b, auxejex, auxejex.length - 1, auxejey.length - 1);
        JOptionPane.showMessageDialog(null,sol1);
        JOptionPane.showMessageDialog(null,sol2);
        //solucion1.setText(sol1);
        //solucion2.setText(sol2);
    }

    public int[][] getLength(char[] x, char[] y) {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length];

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 0;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }
        return b;
    }

    public void MostrarMatriz(int[][] m, char[] x, char[] y) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setColumnCount(0);
        for (int i = 1; i < y.length + 2; i++) {
            if (i >= 2) {
                modelo.addColumn(y[i - 2]);
            } else {
                modelo.addColumn("-");
            }
        }
        modelo.setRowCount(x.length);
        modelo.setColumnCount(y.length + 1);
        for (int i = 1; i < x.length + 1; i++) {
            tabla.setValueAt(x[i - 1], i - 1, 0);
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 1; j < y.length + 1; j++) {
                tabla.setValueAt(m[i][j - 1], i, j);
            }
        }
    }

    public void DisplaySol1(int[][] b, char[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            DisplaySol1(b, x, i - 1, j - 1);
            sol1 += x[i] + " ";
        } else if (b[i][j] == 0) {
            DisplaySol1(b, x, i - 1, j);
        } else if (b[i][j] == -1) {
            DisplaySol1(b, x, i, j - 1);
        }
    }

    public void DisplaySol2(int[][] b, char[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            DisplaySol2(b, x, i - 1, j - 1);
            sol2 += x[i] + " ";
        } else if (b[i][j] == 0) {
            DisplaySol2(b, x, i - 1, j);
        } else if (b[i][j] == -1) {
            DisplaySol2(b, x, i, j - 1);
        }
    }

}
