package Models;

public class NodoAvl {

    private Estudiante estudiante;
    private int balance;
    private NodoAvl izquierda, derecha;

    public NodoAvl(Estudiante estudiante) {
        this.estudiante = estudiante;
        balance = 0;
        izquierda = null;
        derecha = null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public NodoAvl getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAvl izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAvl getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAvl derecha) {
        this.derecha = derecha;
    }

    public int nodosComletos(NodoAvl n) {
        if (n == null) {
            return 0;
        } else {
            if (n.getIzquierda() != null && n.getDerecha() != null) {
                return nodosComletos(n.getIzquierda()) + nodosComletos(n.getDerecha()) + 1;
            }
            return nodosComletos(n.getIzquierda()) + nodosComletos(n.getDerecha());
        }
    }

    public int CalcularAltura(NodoAvl r) {
        if (r == null) {
            return 0;
        }
        return Math.max(CalcularAltura(r.getIzquierda()), CalcularAltura(r.getDerecha())) + 1;
    }

    @Override
    public String toString() {
        return "NodoAvl{" + "estudiante=" + estudiante.getTelefono() + ", balance=" + balance + ", izquierda=" + izquierda + ", derecha=" + derecha + '}';
    }
    
    

}
