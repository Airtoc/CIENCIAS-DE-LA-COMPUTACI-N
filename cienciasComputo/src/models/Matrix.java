package models;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class Matrix {
    private int contador;
    private int formula;

    public void productoMatriz(int[][] matrizA, int[][] matrizB) {

        contador = 0;
        // Matriz resultado.
        int[][] matrizC = new int[matrizA.length][matrizB[0].length];
        contador++;

        if (matrizA[0].length == matrizB.length) {
            contador++; // i=0
            for (int i = 0; i < matrizA.length; i++) {
                contador++; // Incremento
                contador++; // Comparacion
                contador++; // j=0
                for (int j = 0; j < matrizB[0].length; j++) {
                    contador++; // Incremento
                    contador++; // Comparacion
                    contador++; // k=0
                    for (int k = 0; k < matrizA[0].length; k++) {
                        // Multiplicacion de la matriz
                        contador++; // Incremento
                        contador++; // Comparacion
                        matrizC[i][j] = matrizC[i][j] + matrizA[i][k] * matrizB[k][j];
                        contador = contador + 11; // Operacion de arriba
                    }
                    contador++; // False
                }
                contador++; // False
            }
            contador++; // False
        } else {
            System.out.println("Metiste la matriz mal perro hijueputa.");
        }
        // Imprime
        formula = (13 * (matrizA[0].length * matrizB[0].length * matrizA.length)
                + 4 * (matrizB[0].length * matrizA.length) + (4 * matrizA.length) + 3);
        /*
        JOptionPane.showMessageDialog(null,
                "Resultado por el contador (Programa): " + contador + "\n Resultado por la formula: "
                + (13 * (matrizA[0].length * matrizB[0].length * matrizA.length)
                + 4 * (matrizB[0].length * matrizA.length) + (4 * matrizA.length) + 3));
    */}

    public int getContador() {
        return contador;
    }
    public int getFormula() {
        return formula;
    }
  
        
}
