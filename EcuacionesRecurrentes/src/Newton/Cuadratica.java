package Newton;

public class Cuadratica {

    double a;
    double b;
    double c;

    public Cuadratica(double uno, double dos, double tres) {
        this.a = uno;
        this.b = dos;
        this.c = tres;
    }

    public void calcularRaices() {
        double d = ((Math.pow(b, 2) - (4 * a * c)));
        double rUnica = ((-b + (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double rDos = ((-b - (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double GT = (-((b) / (2 * a)));
        
        if (d > 0) {
            System.out.println("x1 = " + rUnica / (2 * a));
            System.out.println("x1 = " + rDos / (2 * a));
        } else if (d == 0) {

            System.out.println("x1 = " + GT);
            System.out.println("x2 = " + GT);

        } else if (d < 0) {
            System.out.println("no hay raices");
        }
    }

}
