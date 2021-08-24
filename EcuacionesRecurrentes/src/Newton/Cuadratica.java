package Newton;

public class Cuadratica {

    double a;
    double b;
    double c;

    public Cuadratica(double[] coeficientes) {
        this.a = coeficientes[0];
        this.b = coeficientes[1];
        this.c = coeficientes[2];
    }

    public double[]  calcularRaices() {
        double raices[] = new double[2];
        double d = ((Math.pow(b, 2) - (4 * a * c)));
        double rUnica = ((-b + (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double rDos = ((-b - (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double GT = (-((b) / (2 * a)));
        
        if (d > 0) {
            raices[0] = rUnica / (2 * a);
            System.out.println("x1 = " + rUnica / (2 * a));
            raices[1] = rDos / (2 * a);
            System.out.println("x1 = " + rDos / (2 * a));
        } else if (d == 0) {
            raices[0] = GT;
            raices[1] = GT;
            System.out.println("x1 = " + GT);
            System.out.println("x2 = " + GT);

        } else if (d < 0) {
            System.out.println("no hay raices");
        }
        return raices;
    }

}
