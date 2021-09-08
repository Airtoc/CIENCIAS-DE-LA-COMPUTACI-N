package Algoritmos;

public class Funciones {

    int num, x, i;
    int numeros[];
    String operaciones[];

    public Funciones(int num, int numeros[], String operaciones[]) {
        this.num = num;
        this.numeros = new int[num];
        this.numeros = numeros;
        this.operaciones = new String[num];
        this.operaciones = operaciones;

    }

    public double calcular(double x) {
        double com = 0;
        com = numeros[0] * Math.pow(x, num);//2
        System.out.println(com);
        for (i = 1; i <= num; i++) {

            if (operaciones[i - 1].equals("+")) {

                com = com + numeros[i] * Math.pow(x, num - i);
                System.out.println(numeros[i] + " *" + Math.pow(x, num - i) + " = " + com);
            } else {

                com = com - numeros[i] * Math.pow(x, num - i);
                System.out.println(numeros[i] + " *" + Math.pow(x, num - i) + " = " + com);
            }

        }
        System.out.println(" ");
        return com;
    }

}
