package Newton;

import Newton.Cuadratica;
import java.util.ArrayList;
import java.util.Scanner;

public class Newton {

    String funcion = "";
    public double numeros[], raices[];
    int i, x, grado;
    static Scanner entrada = new Scanner(System.in);
    int rep = 0;

    public Newton(double[] numeros) {
        raices = new double[numeros.length - 1];
        this.grado = (numeros.length - 1);
        this.numeros = new double[numeros.length];
        this.numeros = numeros;
        calcularRaiz();

    }
    
    //metodos para obtener la derivada de la funcion :
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
    //////////////////////////////////////////////////
    
    //Metodo que realiza la division sintetica del polinomio
    public double[] divisionSintetica(double raiz) {

        double[] aux = new double[numeros.length - 1];//3
        double[] op = new double[numeros.length - 1];//3

        double x = raiz;
        aux[0] = numeros[0];
        for (int i = 0; i < aux.length - 1; i++) {//4
            op[i] = aux[i] * x;
            aux[i + 1] = Math.round(numeros[i + 1] + op[i]);
        }

        return aux;
    }
    
    //metodo que retorna el polinomio para ser derivado 
    public String getPolinomio() {
        funcion = "";
        funcion += (Math.round(numeros[0]) + "x^" + grado + " ");
        for (i = 1; i <= grado; i++) {

            if (numeros[i] > 0) {
                funcion += " + " + Math.round(numeros[i]) + "x^" + (grado - i);

            } else {
                funcion += " + " + (Math.round(numeros[i])) + "x^" + (grado - i);

            }

        }
        System.out.println(funcion);
        return funcion;
    }
    
    //Metodo que se encarga de evaluar la funcion en el x dado
    public double calcularfuncion(double x) {

        double calculo = 0;

        calculo = (numeros[0] * Math.pow(x, grado));//3        

        for (i = 1; i <= grado; i++) {

            if (numeros[i] > 0) {
                calculo = calculo + (numeros[i] * Math.pow(x, grado - i));
                //System.out.println(numeros[i] + " *" + Math.pow(x, grado - i) + " = " + calculo);

            } else {

                calculo = calculo + (numeros[i] * Math.pow(x, grado - i));
                //System.out.println(numeros[i] + " *" + Math.pow(x, grado - i) + " = " + calculo);
            }
        }
        //System.out.println(" ");
        return calculo;
    }

    
    //Metodo principal que se encarga de calcular las raices;
    public void calcularRaiz() {
        //Newton raphson
        GradoMayorA2(numeros);
        double x, y, tempo, e;
        int i = 0;
        x = 100;
            //si el grado es dos, directamente obtiene las raices mediante cuadratica 
        if (grado == 2) {
            Cuadratica cuad = new Cuadratica(numeros);
            raices = cuad.calcularRaices();
        } else {
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
               
                //guarda la primera raiz obtenida
                System.out.println("\n Solucion x = " + x);
                raices[rep] = Math.round(x*100.0)/100.0;
                System.out.println("mis raices #0 = " + raices[0]);              
                grado --;
                //si al reducir el grado sigue siendo menor a 2 , realiza division sintetica y repite el proceso
                System.out.println(grado);
                if (grado != 2) {
                    System.out.println("XDXDXD");
                    numeros = divisionSintetica(x);
                    for(int j=0;j<numeros.length;j++){
                        System.out.println(numeros[j]);
                    }
                    rep++;
                    calcularRaiz();
                    
                } else {
                    // como el grado ya es 2 , entonces obtiene las raices por cuadratica
                    Cuadratica cuad = new Cuadratica(divisionSintetica(x));
                    double[] cuadraticas = cuad.calcularRaices();

                    for (int j = 1; j < cuadraticas.length + 1; j++) {
                        raices[j+rep] = cuadraticas[j - 1];
                        System.out.println("mis raices #" + (j+rep) + "= " + raices[j+rep]);
                    }
                }
            }
        }
    }

    public double[] getRaices() {
        return raices;
    }
    
    public ArrayList<Double> GradoMayorA2(double[] coeficiente){
        ArrayList<Double> divisoresNum = new ArrayList<>();
        ArrayList<Double> divisoresDen = new ArrayList<>();
        ArrayList<Double> raicesp = new ArrayList<>();
        
        //LLENAR DIVISORES
         if (grado == 2) {
            Cuadratica cuad = new Cuadratica(numeros);
            raices = cuad.calcularRaices();
        } else {
             
        for(int i=1;i<=Math.abs(coeficiente[0]);i++){
            if(coeficiente[0]%i ==0){
                divisoresDen.add((double)i);
            }   
        }
        for(int i=1;i<=Math.abs(coeficiente[coeficiente.length-1]);i++){
            if(coeficiente[coeficiente.length-1]%i == 0){
                divisoresNum.add((double)i);
                divisoresNum.add((double)-i);
            }
        }
        
        int cont =0;
        
        for(int i=0;i<divisoresNum.size();i++){
            for(int j=0;j<divisoresDen.size();j++){
                double result = coeficiente[0];
                double[] aux = new double[coeficiente.length];
                aux[0] = coeficiente[0];
                
                for(int w=1;w<coeficiente.length;w++){
                    result = coeficiente[w]+(result*divisoresNum.get(i)/divisoresDen.get(j));
                    aux[w] = result;
                }
                if(result==0){
                    raicesp.add(divisoresNum.get(i)/divisoresDen.get(j));
                    coeficiente = aux;
                    cont = 0;
                    for(int w=coeficiente.length-1;w>2;w--){
                        if(coeficiente[w]==0){
                            cont++;
                        }else{
                            break;
                        }
                    }
                    if(cont==coeficiente.length-3){
                        i=divisoresNum.size(); 
                    }else{
                        i=-1;
                    }
                    break;
                }
            }
        }
     
        double[] r = new double[2];

        if(cont==coeficiente.length-3){
            Cuadratica cuad = new Cuadratica(numeros);
            r = cuad.calcularRaices();
            raicesp.add(r[0]);
            raicesp.add(r[1]);
        }
        }
         for (int i=0;i<raicesp.size();i++){
            System.out.println("metodo this man" + raicesp.get(i));
        }
        return raicesp;
    }
    
    public double[] ordernarRaices(double[] r){
        double t;
        for(int i=0;i<(r.length-1);i++){
            for(int j=i+1;j<r.length;j++){
                if(r[i]<r[j]){
                    t=r[i];
                    r[i]=r[j];
                    r[j]=t;
                }
            }
        }
        return r;
    }
}
