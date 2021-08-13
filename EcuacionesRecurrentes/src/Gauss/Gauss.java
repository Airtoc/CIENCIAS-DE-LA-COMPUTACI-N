/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gauss;

/**
 *
 * @author andre
 */
public class Gauss {
    private double[] raices;
    private double[] valoresN;
    private double[] valoresFn;
    private String matriz = "";
    
    
    
    public Gauss(double []a, double b[],double c[]){
        raices = a;
        valoresFn = b;
        valoresN = c;
        
    }
    
    public double[] resolverGauss(double a[][], double b[]) {
        // recuerde que el metodo de Gauss Jordan trabaja con la idea de convertir la matriz aumentada en la matriz identidad
        int n = valoresN.length;
        for (int i = 0; i < n; i++) {
            double d, c = 0;
            d = a[i][i];// seleccionamos el pivote
            
            for (int j = 0; j < n; j++) {// pasamos a convertir en 1 al pivote seleionado
                a[i][j] = ((a[i][j]) / d);
            }
            b[i] = ((b[i]) / d);

            // paso a mostrar las opraciones realizadas en la matriz aumentada
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    
                }
                
            }
            System.out.println("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada
            

            for (int x = 0; x < n; x++) {
                if (i != x) {
                    c = a[x][i];
                    matriz+=("");
                    matriz+=("-" + Double.toString(c) + " * fila" + (i + 1) + "+ fila" + (x + 1) + "\n");// mustra en pantalla las opraciones que se realizaran por fila
                    for (int y = 0; y < n; y++) {// se hace cero a todos los elemntos de la colunma que no sean el pivote
                        a[x][y] = a[x][y] - c * a[i][y];

                    }
                    matriz+=("");
                    b[x] = b[x] - c * b[i];

                    // paso a mostrar las opraciones realizadas en la matriz aumentada
                    for (int j = 0; j < n; j++) {

                        for (int k = 0; k < n; k++) {
                            matriz+=(Double.toString(a[j][k]) + "\t");
                        }
                        matriz+=("|\t" + Double.toString(b[j]) + "\n");
                    }
                    System.out.println(matriz);
                    System.out.println("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada

                }// fin if (i != x)
            }// fin for (int x = 0; x <= r.length - 1; x++)

        }//fin bucle i
        return b;// retorna la solucion l sistema
    }

    public double[] obtenerMatriz() {
         int n = valoresN.length;
            double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
            double r[] = new double[n];
        try {
         // almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    double valor = Math.pow(raices[j],valoresN[i]);//*valoresFn[i];
                    if(valor == 0){
                        m[i][j] = 1;
                    }else{
                        m[i][j] = valor;
                    }
                    System.out.println(m[i][j]);

                }
                r[i] = valoresFn[i];//Double.parseDouble(String.valueOf(jTable.getValueAt(i, n)));
            }

            r = this.resolverGauss(m, r);

            //pasamos a mostrar las soluciones del sistema en el area de texto
            for (int i = 0; i < n; i++) {
                System.out.println("x" + (i + 1) + " = " + r[i] + "\n");
            }
        } catch (Exception e) {
            System.out.println("error en la lectura de datos");

        }
        return r;
    }
}
