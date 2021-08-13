package Newton;

import Newton.Cuadratica;
import java.util.Scanner;

public class Newton {
    String funcion="";
    public double numeros[];
    int i, x,grado;
    static Scanner entrada = new Scanner(System.in);

    public Newton(double[] numeros) {
        this.grado = (numeros.length - 1);
        this.numeros = new double[numeros.length];
        this.numeros = numeros;
        calcularRaiz();

    }

    public double derivarTermino(String polinomio, double valor) {

        // Get coefficient
        String coeffStr = "";
        int i;
        for (i = 0; polinomio.charAt(i) != 'x'; i++) {
            if (polinomio.charAt(i) == ' ') {
                continue;
            }
            coeffStr += (polinomio.charAt(i));
        }

        double coeff = Double.parseDouble(coeffStr);

        // Get Power (Skip 2 characters for x and ^)
        String powStr = "";
        for (i = i + 2; i != polinomio.length() && polinomio.charAt(i) != ' '; i++) {
            powStr += polinomio.charAt(i);
        }

        double power = Double.parseDouble(powStr);

        // For ax^n, we return a(n-1)x^(n-1)
        return coeff * power * (double) Math.pow(valor, power - 1);
    }

    public double derivativeVal(String poly, double val) {
        double ans = 0;

        int i = 0;
        String[] stSplit = poly.split("\\+");
        while (i < stSplit.length) {
            ans = (ans + derivarTermino(stSplit[i], val));
            i++;
        }
        return ans;
    }


    public String getPolinomio(){
        funcion += (Math.round(numeros[0]) + "x^" + grado + " ");
        for (i = 1; i <= grado; i++) {

            if (numeros[i] > 0) {
                funcion += " + " + Math.round(numeros[i]) + "x^" + (grado - i) ;

            } else {
                funcion += " + " +(Math.round(numeros[i])) + "x^" + (grado - i);

            }

        }
        System.out.println(funcion);
        return funcion;
    }
    
    public double calcularfuncion(double x) {

        double calculo = 0;

        calculo = (numeros[0] * Math.pow(x, grado));//3        
        
        for (i = 1; i <= grado; i++) {

            if (numeros[i] > 0) {
                calculo = calculo + (numeros[i] * Math.pow(x, grado - i));
                System.out.println(numeros[i] + " *" + Math.pow(x, grado - i) + " = " + calculo);

            } else {

                calculo = calculo + (numeros[i] * Math.pow(x, grado - i));
                System.out.println(numeros[i] + " *" + Math.pow(x, grado - i) + " = " + calculo);

            }

        }
        System.out.println(" ");
        return calculo;
    }

    public void calcularRaiz() {
        //Cuadratica a = new Cuadratica(1,-5,6);
        //a.calcularRaices();
        double x, y, tempo, e;
        int i = 0;
        x = 100;
        String polinomio = getPolinomio();
        
        do {
            tempo = x;          
            x = x - calcularfuncion(x) / (derivativeVal(polinomio, x));//x-(y1/y2)
            e = Math.abs((x - tempo) / x);
            System.out.println("x" + 1 + " = " + x + " Error" + " = " + e + "\n");
            i = i + 1;
        } while (x != tempo && i < 100);

        if (i == 100) {
            System.out.println("no converge");
        } else {
            System.out.println("\n Solucion x = " + x);
        }
    }
}
